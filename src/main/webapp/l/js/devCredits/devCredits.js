Ext.Loader.setConfig(
	{
		enabled : true
	});
Ext.Loader.setPath('Ext.chooser', 'l/js/devCredits');
Ext.Loader.setPath('Ext.ux', '../../../extJsLib/ux');


Ext.require([
    'Ext.button.Button',
    'Ext.data.proxy.Ajax',
    'Ext.chooser.InfoPanel',
    'Ext.chooser.IconBrowser',
    'Ext.chooser.Window',
    'Ext.ux.DataView.Animated',
    'Ext.toolbar.Spacer'
]);
var devCreditsWindow = "";


function showDevCreditsWindow(ref) {


	if (!devCreditsWindow && devCreditsWindow == "")
		devCreditsWindow = Ext.create('Ext.chooser.Window',
			{
			id : 'img-chooser-dlg',
			iconCls:'dev',
			animateTarget : ref.getEl()
			});
	devCreditsWindow.show();

}