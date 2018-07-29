function getRegisterForm() {

	var registerForm = Ext.create('Ext.form.Panel', {
		title : 'New User',
		frame : true,
		labelWidth : 300,
		width : 600,
		height : 250,
		bodyPadding : 5,

		// The form will submit an AJAX request to this URL when submitted
		url : 'tryLoggingIn.do',

		// Fields will be arranged vertically, stretched to full width
		layout : 'anchor',
		defaults : {
			anchor : '100%'
		},

		// The fields
		defaultType : 'textfield',
		items : [ {
			xtype : 'textfield',
			fieldLabel : 'Name ',
			name : 'dspName',
			id : 'dspName',
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : 'Username',
			name : 'username',
			id : 'username',
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : 'Password',
			name : 'password',
			id : 'password',
			allowBlank : false,
			inputType : 'password'
		},{
			xtype : 'textfield',
			fieldLabel : 'Re Enter Password',
			name : 'repassword',
			id : 'repassword',
			allowBlank : false
			
		} ,{
			xtype : 'textfield',
			fieldLabel : 'E - Mail',
			name : 'email',
			id : 'email',
			allowBlank : false
		},{
			xtype : 'textfield',
			fieldLabel : 'Password Hint',
			name : 'pwdhint',
			id : 'pwdhint',
			allowBlank : false
		},{
			xtype : 'textfield',
			fieldLabel : 'Password Answer',
			name : 'pwdans',
			id : 'pwdans',
			allowBlank : false
		}    
		
		
		],

		// Reset and Submit buttons
		buttons : [ {
			text : 'Register',
			formBind : true, // only enabled once the form is valid
			disabled : false,
			handler : function() {
				var form = this.up('form').getForm();
				if (form.isValid()) {
					form.submit( {
						success : function(form, action) {
							Ext.Msg.alert('Success', action.result.msg);
						},
						failure : function(form, action) {
							Ext.Msg.alert('Failed', action.result.msg);
						}
					});
				}
			}
		} ]
	});

	return registerForm;
}