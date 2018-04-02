function getCenterObj() {
	if (centerObj)
		return centerObj;
	
	centerObj = Ext.createWidget('tabpanel', {
		region : 'center',
		activeTab : 0,
		width : '64%',
		dockedItems :
			[
				getTopDockedItems(),
				getBottomDockedItems()
			],
		
    items: [
    				{
    					title : 'Think Speical',
    					layout:'fit',
    					iconCls:'think',
    					closable : false,
    					items : [cLayout],
    					listeners: {
                activate: function(tab){
                	if(youTubeWndw!=null )
                		{
                			youTubeWndw.show();
                		}
                }
    					}
    				}
    ]
});
	
	/*centerObj = Ext.create('Ext.tab.Panel',
		{
		region : 'center',
		activeTab : 0,
		width : '64%',
		dockedItems :
			[
				getTopDockedItems(),
				getBottomDockedItems()
			],
		
		items :
			[
				{
				title : 'Think Speical',
				layout:'fit',
				iconCls:'think',
				closable : false,
				items : [cLayout]
				}
			]
		});
	
	centerObj.on('activate',function(tab){
		if(tab.title="Think Speical")
			{
				if(youTubeWndw!=null && !youTubeWndw.isHidden())
      		{
      			youTubeWndw.show();
      		}
			}
	});*/
	
	return centerObj;
	
}

function showTab() {
	
	setTimeout(function() {
		tabs.child('#home').tab.hide();
		var users = tabs.child('#users');
		users.tab.show();
		tabs.setActiveTab(users);
	}, 1000);
	
}