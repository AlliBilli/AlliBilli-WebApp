var lAccordion;
function getWestObj() {
	
	if (lAccordion)
		return lAccordion;
	
	lAccordion = Ext.create('Ext.panel.Panel',
		{
		layout : 'accordion',
		region : 'west',
		id : 'west-panel',
		title : 'Quick Links',
		split : true,
		width : '18%',
		minWidth : 220,
		maxWidth : 250,
		collapsible : true,
		animCollapse : true,
		margins : '0 0 0 5',
		activeOnTop : true
		});
	return lAccordion;
}