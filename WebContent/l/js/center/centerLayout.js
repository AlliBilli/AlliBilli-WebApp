var cLayout =
	{
   "xtype": "container",
   "layout": {
       "align": "stretch",
       "type": "vbox"
   },
   defaults :
 		{
 			bodyStyle : 'padding:10px'
 		},
   "items": [
       {
           "xtype": "container",
           contentEl : 'activeTab',
           flex:1
       },
       {
           "xtype": "container",
           flex:3,
           id:"youtubeWndCont"
       }
   ]
};