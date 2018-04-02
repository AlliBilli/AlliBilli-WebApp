Ext.onReady(function()
{
	listSandboxStore.load(
			{
				callback : onSandboxLoad
			});
	showProgress();
});

var listSandboxStore = Ext.create('Ext.data.Store', {
    model: "Sandbox",
    proxy: listSandboxDataProxy,
    autoLoad: false,
    totalProperty: 'total'
});

var listDevCreditsStore = Ext.create('Ext.data.Store', {
  model: "DevCredits",
  proxy: listDevCreditsProxy,
  autoLoad: false,
  totalProperty: 'total'
});