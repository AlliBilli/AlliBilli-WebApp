Ext.require(
[
	'*'
]);
var viewport = "";
Ext.onReady(function()
{
	
	Ext.QuickTips.init();
	
	// Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
	Ext.Ajax.timeout = 90000;
	
	viewport = Ext.create('Ext.Viewport',
	{
	id : 'AlliBilli_ThinkSpecial',
	layout : 'border',
	items :
	[
	getEastObj(), getWestObj(), getCenterObj()
	]
	});
	
	viewport.doLayout();
});