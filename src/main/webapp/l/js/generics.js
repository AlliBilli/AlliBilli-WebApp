function getIFramePnl(eleId, text, url) {
	
	var pnlObj = Ext.create('Ext.panel.Panel',
				{
					title : text,
					closable : true,
					autoScroll : true,
					id : getPreparedId(text, eleId),
					html : '<iframe src =\"' + url
					    + '\" width=\"100%\" height=\"100%\"></iframe>'
				});
		
	 pnlObj.on('activate', processActivate);
	 
	return pnlObj;
}
function processActivate() {
	if(youTubeWndw!=null)
		youTubeWndw.hide();
}
function isTabInTabsAvailable(tabId) {
	var isTabAvailable = false;
	centerObj.items.each(function(tabPnl) {
		if (tabPnl.id == tabId)
			isTabAvailable = true;
	});
	return isTabAvailable;
	
}
function getPreparedId(text, eleId) {
	return text + '_' + eleId;
}

function checkAndTabOrActivateTab(text, eleId, eleUrl) {
	var isTabAvailable = isTabInTabsAvailable(getPreparedId(text, eleId));
	if (!isTabAvailable)
		{
			var objToActive = centerObj.add(getIFramePnl(eleId, text, eleUrl));
			centerObj.setActiveTab(objToActive);
		} else
		{
			centerObj.setActiveTab(Ext.getCmp(getPreparedId(text, eleId)));
		}
}

function showProgress() {
	
	if (Ext.isIE)
			progressBar.setTitle("IE is very slow, please wait until it paints the screen...");
	else
			progressBar.setTitle("Hold on, Loading items one by one...");

	var pconfig =
		{
		msg : 'Loading items...',
		progressText : loadingMsg,
		width : 500,
		progress : true,
		closable : true,
		animEl : Ext.getBody()
		};
	
	progressBar.on('afterrender', onProgressShown);
	progressBar.show(pconfig);
	
}
function onProgressShown(comp, opts) {
	progressBar.removeListener('afterrender', onProgressShown);
	intervalTime = setInterval(function() {
		updateProgressBar(progressBar);
	}, 1000);
	
}
function updateProgressBar(progressBar) {
	progressIndicator += 0.05;
	progressBar.updateProgress(progressIndicator, loadingMsg);
	
	if (isTreessBuildCompleted)
		{
			window.clearInterval(intervalTime);
			progressBar.close();
			loadYoutubePlayer(Ext.getCmp('youTubeWndw'));
			listDevCreditsStore.load();
		} else if (progressIndicator >= 1)
		{
			progressIndicator = 0.8;
		}
	
}

function handleSessionExpire(result) {
	if (result && typeof result == "object")
		result = result.toString();
	
	var responseJson = Ext.decode(result);
	if (responseJson == null)
		return;
	
	var isSessionExpired = responseJson.sessionExpired;
	if (isSessionExpired != null && isSessionExpired == true)
		{
			var exceptionMessage = responseJson.exceptionMessage;
			
			Ext.MessageBox.show(
				{
				title : 'Session Expired!',
				msg : exceptionMessage + ', You must have to login back. ',
				buttons : Ext.MessageBox.OK,
				fn : moveToLoginScreen,
				animEl : Ext.getBody(),
				minWidth : 200,
				icon : Ext.MessageBox.QUESTION
				});
			
		}
}

function getWindowObj(winTitle, form, width, height) {
	
	var myWin = Ext.create('Ext.window.Window',
		{
		title : winTitle,
		id : 'win_' + winTitle,
		layout : 'fit',
		width : width,
		height : height,
		closable : true,
		defaults :
			{
				anchor : '100%'
			}
		});
	if (form)
		myWin.add(form);
	return myWin;
}

function getPnlObj(text) {
	var pnlObj = Ext.create('Ext.panel.Panel',
		{
		title : text,
		closable : true,
		autoScroll : true,
		id : 'myPnl_' + text
		});
	
	return pnlObj;
}

function loadYoutubePlayer(ref) {
	
		youtubePlayerPanel = new Ext.ux.YoutubePlayer(
		{
		developerKey : 'AI39si7X8wWeWaHLYkwvNdJppy42VHoIRj8iWSeXPyFl8V-XDPDnuqiRx8yu6XbRnlZIQjAsSNI5uoCc2ZLRIJLTc5wujJaC4Q',
		playerId : 'myplayer',
		ratioMode : 'strict',
		bgColor : "#000000",
		cls : 'ext-ux-youtubeplayer'
		});
	
		youTubeWndw = Ext.create('widget.window',
		{
		title : 'Youtube Videos',
		width : youtubePlayerPanelWidth,
		height : youtubePlayerPanelHeight,
		plain : true,
		iconCls:'youtube',
		minimizable : true,
		headerPosition : 'left',
		closeAction : 'destroy',
		layout : 'fit',
		animateTarget : ref.getEl(),
		floating:true,
		maximizable : true,
		items :
			[
				youtubePlayerPanel
			],
		bbar : new Ext.ux.YoutubePlayer.Control(
			{
			player : youtubePlayerPanel,
			border : false,
			id : 'control',
			style : 'border:none;',
			autoDestroy : true
			})
		});
	youTubeWndw.on('close', onYouTubeWindowClose);
	youTubeWndw.on('minimize', onYouTubeWindowMinimize);
	youTubeWndw.on('restore', onYouTubeWindowRestore);
	youTubeWndw.show();
	
}
function onYouTubeWindowClose() {
	youTubeWndw.remove('close', onYouTubeWindowClose);
	youTubeWndw.remove('minimize', onYouTubeWindowMinimize);
	youTubeWndw = null;
	expandAll();
}
function onYouTubeWindowMinimize() {
	if(youTubeWndw)
		youTubeWndw.hide();
	expandAll();
}
function onYouTubeWindowRestore() {
	expandAll();
}
/*
 * Shows how to create a tag based html element in EXT JS
 */
/*
 * Ext.onReady(function() { Ext.QuickTips.init(); Ext.IframeWindow =
 * Ext.extend(Ext.panel.Panel, { onRender: function() { this.bodyCfg = { tag:
 * 'iframe', src: this.src, title:this.text, closable : true, width:"100%",
 * height:"100%", style: { border: '0px none' } };
 * Ext.IframeWindow.superclass.onRender.apply(this, arguments); } });
 * 
 * });
 */
function collapseAlliBilliHeader() {
	Ext.getCmp('ctrCollapsablePnl').collapse();
}
function expandAlliBilliHeader() {
	Ext.getCmp('ctrCollapsablePnl').expand();
}
function collapseLeft() {
	Ext.getCmp('west-panel').collapse();
}
function collapseRight() {
	Ext.getCmp('east-panel').collapse();
}
function collapseBoth() {
	collapseLeft();
	collapseRight();
}
function collapseAll() {
	collapseRight();
	collapseAlliBilliHeader();
}
function expandAll() {
	Ext.getCmp('west-panel').expand();
	Ext.getCmp('east-panel').expand();
	expandAlliBilliHeader();
}
function expandBoth() {
	Ext.getCmp('west-panel').expand();
	Ext.getCmp('east-panel').expand();
}

function failure(response, opts) {
    alert('Request Failed');
 }

function success(response, opts) {
    alert('Thank you.');
 }


function sendRequest(url,sFn,fFn)
{

	Ext.Ajax.request({
		   url: url,
		   success: sFn,
		   failure: fFn
		});
}

function playAudioButton(type)
{
	loadAudioPlayer(Ext.getCmp('playAudioWndw'), type);
}

function loadyoutubeResult(response, opts)
{
	alert(response);
}
function failyoutubeResult(response, opts)
{
	
}

function searchMovie()
{
	var value = document.getElementById('searchMovieTxt').value;
	if((value!=null && value.length==0) || value == null )
		return;
	
	var isTabAvailable = false;
	isTabAvailable = isTabInTabsAvailable(getPreparedId('Soku', 'soku'));
	if(isTabAvailable)
		centerObj.remove(getPreparedId('Soku', 'soku'));
	
	isTabAvailable = false;
	isTabAvailable = isTabInTabsAvailable(getPreparedId('Bing', 'bing'));
	if(isTabAvailable)
		centerObj.remove(getPreparedId('Bing', 'bing'));
	
	var soku='http://www.soku.com/search_video/q_'+value;
	var bingLink = 'http://www.bing.com/search?q=youtube+'+value+' movie india';
	
	var ifPnl = getIFramePnl('soku', 'Soku', soku);
	var souku = centerObj.add(ifPnl);
	
	var bPnl = getIFramePnl('bing', 'Bing', bingLink);
	var bing = centerObj.add(bPnl);
	
	centerObj.setActiveTab(souku);
}

function loadAudioPlayer(ref, type) {

	audioWndw = Ext.create('widget.window',
			{
			title : 'Audio',
			width : 280,
			height : 150,
			plain : true,
			iconCls:'audio',
			minimizable : true,
			headerPosition : 'left',
			closeAction : 'destroy',
			layout : 'fit',
			animateTarget : ref.getEl(),
			floating:true,
			id: 'audioWindow',
			maximizable : false,
			listeners: {
        'render': function()
            {
                Ext.Ajax.request({
                    url: 'audio.html',
                    success: function(response){
                        Ext.getCmp('audioWindow').update(response.responseText);
                        audioPlayer = $("#jquery_jplayer_1").jPlayer({
                      		ready: function (event) {
                      			$(this).jPlayer("setMedia", {
                      				 mp3: "http://www.allibilli.com/"+type+".mp3"
                      			});
                      		},
                      		swfPath: "http://jplayer.org/latest/js",
                      		supplied: "mp3",
                      		wmode: "window",
                      		smoothPlayBar: true,
                      		keyEnabled: true
                      	});
                        
                       document.getElementById('audioLable').innerHTML = "Telugu "+type;
                    }
                });    
                
                
              	
            }
    }});
	audioWndw.on('close', onAudioWindowClose);
	audioWndw.on('minimize', onAudioWindowMinimize);
	audioWndw.on('restore', onAudioWindowRestore);
	audioWndw.show();

}

function onAudioWindowClose() {
	audioWndw.remove('close', onAudioWindowClose);
	audioWndw.remove('minimize', onAudioWindowMinimize);
	audioWndw = null;
	//expandAll();
}
function onAudioWindowMinimize() {
	if(audioWndw)
		audioWndw.hide();
	//expandAll();
}
function onAudioWindowRestore() {
	//expandAll();
}

function playButton(type)
{
	
	if(youtubePlayerPanel==null)
		{
			loadYoutubePlayer(Ext.getCmp('youTubeWndw'));
		}
	youtubePlayerPanel.stopVideo();
	youtubePlayerPanel.clearVideo();
	
	
	if (type == "TEL")
		{
			uTubePlayListId = "2EBED2C9F31DF80D";
			youtubePlayerPanel.cuePlaylist();
		} else if (type == "ENG")
		{
			uTubePlayListId = "56C9CC4CCC01830B";
			youtubePlayerPanel.cuePlaylist();
		} else if (type == "BHA")
		{
			setBhajanId();
		} else if (type == "OM")
		{
			uTubePlayListId = "1Jwoeb4AsFk";
			youtubePlayerPanel.cueVideoById(uTubePlayListId,10);
			youtubePlayerPanel.playVideo();
		} else if (type == "ALL")
		{
			uTubePlayListId = "OM0ZAMGwyiM";
			youtubePlayerPanel.cueVideoById(uTubePlayListId,0);
			youtubePlayerPanel.playVideo();
		} else if (type == "JES")
		{
			uTubePlayListId = "4CMn2vu140w";
			youtubePlayerPanel.cueVideoById(uTubePlayListId,0);
			youtubePlayerPanel.playVideo();
		}
		 else if (type == "SUP")
				{
					uTubePlayListId = "yq_DuefpxMs";
					youtubePlayerPanel.cueVideoById(uTubePlayListId,3);
					youtubePlayerPanel.playVideo();
				}
	collapseAll();
	youTubeWndw.maximize();
}

function setBhajanId()
{
	isPlayListPlaying = false;
	var sat = "19HHiHUmAqw";
	var sun = "32TGOFRIVmE";
	var mon = "4eJ-Ue415Tw";
	var tue = "AIDFBdvoEew";
	var wed = "QY15oP3vvWk";
	var thu = "wgIf0FX6WzI";
	var fri = "9oJtWHjJpvE";

	var d=new Date();
	var weekday=new Array(7);
	weekday[0]=sun;
	weekday[1]=mon;
	weekday[2]=tue;
	weekday[3]=wed;
	weekday[4]=thu;
	weekday[5]=fri;
	weekday[6]=sat;
	uTubePlayListId = weekday[d.getDay()];
	youtubePlayerPanel.cueVideoById(uTubePlayListId,0);
	youtubePlayerPanel.playVideo();
	
}
