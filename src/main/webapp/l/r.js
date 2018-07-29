var rAccordion;
function getEastObj() {
	
	if (rAccordion != null)
		{
			console.log('alreday exists');
			return rAccordion;
		}
	
	rAccordion = Ext.create('Ext.panel.Panel',
		{
		layout : 'accordion',
		region : 'east',
		id : 'east-panel',
		title : 'Entertainment',
		split : true,
		minWidth : 220,
		maxWidth : 250,
		width : '18%',
		collapsible : true,
		animCollapse : true,
		margins : '0 5 0 0',
		activeOnTop : true
		});
	return rAccordion;
}