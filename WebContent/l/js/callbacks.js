function onSandboxLoad() {
		
	if(Ext.isIE)
		loadingMsg = "Your IE is now building components...";
	else
		loadingMsg = "Loaded, your browser is now building components...";
	progressBar
	    .updateProgress(0.38);
	
	sandboxModel = listSandboxStore.first();
	panels = sandboxModel.panels();
	var accd;
	var accName;
	
	 var task = new Ext.util.DelayedTask(function(){
		 loadingMsg = "Now Rendering...";
		 progressBar.updateProgress(0.78);
			panels.each(function(panel) {
				accs = panel.accs();
				
				accs.each(function(accordian) {
					
					iconClassName = accordian.get('iconCls');
					if (iconClassName == null || iconClassName == "")
						iconClassName = 'settings';
					
					accName = accordian.get('accdName');
					treeElements = getTree(accordian);
					
					accd = Ext.create('Ext.panel.Panel',
							{
								title : accName,
								iconCls : iconClassName,
								layout : 'fit',
								id : accName,
								items :
									[
										treeElements
									]
							});
					
					accd.on(evtName,onAccdExpand);
					
					if (accordian.get('panelId') == 1)
						{
							lAccordion.add(accd);
							
						} else
						{
							rAccordion.add(accd);
							if (accordian.get('expand')){
								rAccordion.getComponent(accName).expand();
							}
						}
					
				});
			});
			loadingMsg = "Now painting your screen";
			progressBar.updateProgress(0.9);
			isTreessBuildCompleted = true;
 });
	 task.delay(1000);
}

function getEmptyTreeStore() {
	treeStore = Ext.create('Ext.data.TreeStore',{root:{expanded : true}});
}

function getTreeStore(myArr) {
	treeStore = Ext.create('Ext.data.TreeStore',{root :{expanded : true,children : myArr}});
}
function getTree(accordian) {
	var jsonTreeElements;
	
	if (accordian.get('expand') || onAccdSelect == true)
	{
		jsonTreeElements = accordian.treeElements();
		myArr = new Array();
		var tree = "";
		jsonTreeElements.each(function(treeElement) {
			myArr.push(treeElement.data);
		});
		getTreeStore(myArr);
		onAccdSelect = false;
	}
	else
		{
			getEmptyTreeStore();
		}
	
		tree = Ext.create('Ext.tree.Panel',
		{
		store : treeStore,
		rootVisible : false,
		border : false,
		autoScroll : true,
		listeners :
			{
				itemclick : function(view, record, item, index, e, eOpts){onTreeClick(view, record, item, index, e, eOpts,accordian);}
			},
		dockedItems :
			[
					{
					xtype : 'toolbar',
					items :
						[
							{
							text : 'Expand Trees',
							iconCls : 'treeBtn',
							handler : function() {
								tree.expandAll();
							}
							}, '->',
							{
							text : 'Collapse Trees',
							iconCls : 'treeBtnDel',
							handler : function() {
								tree.collapseAll();
							}
							}
						]
					}
			]
		});
		tree.on('itemcontextmenu', function(view, record, item, index, event){
			cte = record;
			event.stopEvent();
			 if (record.isLeaf())
				 contextMenu.showAt(event.getXY());
            
		},this);

		
	return tree;
}

function onTreeClick(view, record, item, index, e, eOpts, accordian) {
	
	if (record.isLeaf())
		{
			onYouTubeWindowMinimize();
			if (record && record.raw && record.raw.eleUrl)
				{
					var isTabAvailable = false;
					
					isTabAvailable = isTabInTabsAvailable(getPreparedId(record.raw.text, record.raw.eleId));
					
					if (isTabAvailable)
						centerObj.setActiveTab(Ext
						    .getCmp(getPreparedId(record.raw.text, record.raw.eleId)));
					else
						{
							
							if (accordian.get('panelId') == 1)
								collapseRight();
							else if (accordian.get('panelId') == 2)
								collapseLeft();
							
							var objToActive = centerObj
							    .add(getIFramePnl(record.raw.eleId, record.raw.text, record.raw.eleUrl));
							centerObj.setActiveTab(objToActive);
						}
					
				} else
				alert("No URL is appended to this tree node");
		} else
		(record.isExpanded()) ? record.collapse() : record.expand();
}
function onAccdExpand(accdPnl)
{

	if(accdPnl.hasListener(evtName))
		{
			accdPnl.removeListener(evtName,onAccdExpand);
		}
	var children = accdPnl.items ? accdPnl.items.items : [];
	
	if(children[0].getRootNode().hasChildNodes())
		{
			return;
		}
		
	onAccdSelect = true;
	var tree="";
	
	panels.each(function(panel) {
		accs = panel.accs();
		accs.each(function(accordian) {
			if(accordian.get('accdName') == accdPnl.getId())
				{
					tree = getTree(accordian);
					accdPnl.removeAll();
					accdPnl.add(tree);
				}
		});
	});
	
}