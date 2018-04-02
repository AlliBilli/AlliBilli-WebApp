function getSignInForm() {

	var singInForm = Ext.create('Ext.form.Panel', {
		title : 'Sign In',
		frame : true,
		labelWidth : 300,
		width : 600,
		height : 150,
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
		} ],

		// Reset and Submit buttons
		buttons : [ {
			text : 'Sign In',
			handler : function() {

				alert('login');

			}
		}, {
			text : 'SignIn',
			formBind : true, // only enabled once the form is valid
			disabled : true,
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

	return singInForm;
}