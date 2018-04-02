var eastObj;
var westObj;
var centerObj;
var iconClassName;
var global_iframe_id = 0;
var youTubeWndw;

var myArr = "";
var treeStore = Ext.create('Ext.data.TreeStore',{root:{expanded:true}});
var sandboxModel = "";
var panels = "";
var accs = "";
var treeElements = "";
var onAccdSelect = false;
var evtName = 'beforeexpand';
var isIntervalAlredaySet = false;
var progressIndicator = 0.5;

var isInitialLoadCompleted = false;
var isTreessBuildCompleted = false;

var dockedItems = "";
var loadingMsg = "No more kidding, waiting for its load";
var progressBar = Ext.MessageBox;
var uTubePlayListId="AB08DED66B868FC5";
var contextMenu = new Ext.menu.Menu({
	  items: [{
	    text: 'Report Invalid',
	    iconCls: 'invalid',
	    handler : onInvalidClick
	  }]
	});
var cte;
function onInvalidClick()
{
	var url = "reportInvalid.do?eleId="+cte.raw.eleId+"&text="+ cte.raw.text+"&eleURL="+cte.raw.eleUrl;
	sendRequest(url,success,failure);
	cte = null;
}

