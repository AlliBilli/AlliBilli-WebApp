function getIFramePnl(eleId, text, url) {
	var pnlObj =
		{
		xtype : 'panel',
		title : text,
		closable : true,
		autoScroll : true,
		id : getPreparedId(text, eleId),
		html : '<iframe src =\"' + url
		    + '\" width=\"100%\" height=\"100%\"></iframe>'
		};
	
	return pnlObj;
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
	var youtubePlayerPanel = new Ext.ux.YoutubePlayer(
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
		width : 400,
		height : 200,
		plain : true,
		iconCls:'youtube',
		minimizable : true,
		headerPosition : 'left',
		closeAction : 'destroy',
		layout : 'fit',
		renderTo:'youtubeWndCont',
		animateTarget : ref.getEl(),
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
	youTubeWndw.show();
}
function onYouTubeWindowClose() {
	youTubeWndw.remove('close', onYouTubeWindowClose);
	youTubeWndw.remove('minimize', onYouTubeWindowMinimize);
	youTubeWndw = null;
}
function onYouTubeWindowMinimize() {
	if(youTubeWndw)
		youTubeWndw.hide();
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

function collapseLeft() {
	var w = Ext.getCmp('west-panel');
	w.collapse();
}
function collapseRight() {
	var e = Ext.getCmp('east-panel');
	e.collapse();
}
function collapseBoth() {
	collapseLeft();
	collapseRight();
}
function expandBoth() {
	var w = Ext.getCmp('west-panel');
	w.expand();
	var e = Ext.getCmp('east-panel');
	e.expand();
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
