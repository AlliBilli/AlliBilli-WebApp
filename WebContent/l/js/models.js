
Ext.define('Children', {
    extend: 'Ext.data.Model',
    fields: [
            {
		        name : 'eleId',
		        type : 'int'
		    },
		    {
		        name : 'text',
		        type : 'string'
		    },
		    {
		        name : 'accdId',
		        type : 'int'
		    },
		    {
		        name : 'rootId',
		        type : 'int'
		    },
		    {
		        name : 'leaf',
		        type : 'boolean'
		    },
		    {
		        name : 'orderList',
		        type : 'int'
		    },
		    {
		        name : 'eleUrl',
		        type : 'string'
		    }
    ],
    hasMany: {model: 'Children', name: 'children'}
});


Ext.define('TreeElement', {
    extend: 'Ext.data.Model',
    fields: [
            {
		        name : 'eleId',
		        type : 'int'
		    },
		    {
		        name : 'text',
		        type : 'string'
		    },
		    {
		        name : 'accdId',
		        type : 'int'
		    },
		    {
		        name : 'rootId',
		        type : 'int'
		    },
		    {
		        name : 'leaf',
		        type : 'boolean'
		    },
		    {
		        name : 'orderList',
		        type : 'int'
		    },
		    {
		        name : 'eleUrl',
		        type : 'string'
		    },
		    {
	        name : 'expanded',
	        type : 'boolean'
		    },
		    
		    {
		        name : 'children',
		        type : 'Children'
		    }
    ],
    belongsTo: 'Accordian'
});


Ext.define('Accordian', {
    extend: 'Ext.data.Model',
    fields: [
            {
		        name : 'accdId',
		        type : 'int'
		    },
		    {
		        name : 'orderList',
		        type : 'int'
		    },
		    {
		        name : 'accdName',
		        type : 'string'
		    },
		    {
		        name : 'panelId',
		        type : 'int'
		    },
		    {
		        name : 'iconCls',
		        type : 'string'
		    },
		    {
	        name : 'expand',
	        type : 'boolean'
		    }
		    
    ],
    hasMany: {model: 'TreeElement', name: 'treeElements'},
    belongsTo: 'Panel'
});

Ext.define('Panel', {
    extend: 'Ext.data.Model',
    fields: [
            {
 		        name : 'panelId',
 		        type : 'int'
 		    },
 		    {
 		        name : 'panelName',
 		        type : 'string'
 		    }
    ],
    hasMany: {model: 'Accordian', name: 'accs'}

});

Ext.define('Sandbox', {
    extend: 'Ext.data.Model',
    fields: [],
    hasMany: {model: 'Panel', name: 'panels'}
});

Ext.define('DevCredits', {
	extend: 'Ext.data.Model',
  fields: [
  'name', 'location', 'description', 'iddevcredits', 'helpType', 'archived'
  ]
});