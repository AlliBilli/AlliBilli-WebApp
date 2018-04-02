Ext.define('Ext.chooser.Window', {
    extend: 'Ext.window.Window',
    uses: [
        'Ext.layout.container.Border',
        'Ext.form.field.Text',
        'Ext.form.field.ComboBox',
        'Ext.toolbar.TextItem'
    ],
    
    height: 420,
    width : 600,
    title : 'Choose the person',
    closeAction: 'hide',
    layout: 'border',
    // modal: true,
    border: false,
    bodyBorder: false,
    
	    initComponent : function() {
	      this.items =
			    [
				    {
					    xtype : 'panel',
					    region : 'center',
					    autoScroll : true,
					    width:'40%',
					    items :
						    {
						    	xtype: 'iconbrowser',
                  id: 'img-chooser-view',
                  listeners: {
                      scope: this,
                      selectionchange: this.onIconSelect
                  }}
					    },
					    {
						    width:'60%',
						    xtype : 'infopanel',
						    region : 'east',
						    split : true
						    }
				    ];
		    
		    this.buttons =
			    [
					    {
					    text : 'Close',
					    scope : this,
					    handler : function() {
						    this.hide();
					    }
					    }
			    ];
		    
		    this.callParent(arguments);
		    this.addEvents('selected');
	    },
	    
	    onIconSelect : function(dataview, selections) {
		    var selected = selections[0];
		    
		    if (selected)
			    {
				    this.down('infopanel').loadRecord(selected);
			    }
	    }
	    });
