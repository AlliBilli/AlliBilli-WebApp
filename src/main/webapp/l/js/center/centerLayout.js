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
           "xtype": "panel",
           contentEl : 'activeTab',
           collapsible: true,
           border : false,
           flex:1,
           minHeight : 290,
           id:"ctrCollapsablePnl"
       },
       {
           "xtype": "container",
           flex:3,
           id:"youtubeWndCont"
       }
   ]
};