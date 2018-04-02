/* PROXY */
var listSandboxDataProxy = new Ext.data.HttpProxy(
{
    method : 'GET',
    type: 'rest',
    url : 'listSandboxComponents.do',
    reader: {
        type: 'json',
        root: 'sandboxData'
    }
});

var listDevCreditsProxy = new Ext.data.HttpProxy(
		{
			method : 'GET',
      type : 'ajax',
      url : 'listDevCredits.do',
      reader : {
        type : 'json',
        root : 'devCredits'
      }
     });
