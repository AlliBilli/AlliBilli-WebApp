/**
 * 
 */
 function showLogonForm()
 {
 	 var win;
     var loginForm = Ext.create('Ext.form.Panel', {
        url:'tryLoggingIn.do',
        frame:true,
        border : false,
        bodyBorder : false,
        bodyStyle:'padding:5px 5px 5px 5 px',
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 75
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '100%'
        },
        items: [{
            fieldLabel: 'Email Id',
            name: 'login',
            allowBlank:false,
            vtype: 'email'
        },{
            fieldLabel: 'Password',
            name: 'password',
            allowBlank:false,
            inputType : 'password'
        }],
		
        buttons: [{
            xtype:'box',
            isFormField: false,
            id: "trailerActivityLink",
            fieldLabel:'<nobr>Forgot Passord?',
            style: "padding: 3px",
            html: "&nbsp;<a href='javascript:showForgotPasswordForm()'>forgot password?</a>"
		},{
            text: 'Login',
            formBind : true, // only enabled once the form is valid
			disabled : true,
            handler : function()
            {
            	var form = this.up('form').getForm();
            	if (form.isValid()) {
                
                form.submit({
                    success: function(form, action) {
                       Ext.Msg.alert('Success', action.result.msg);
                    },
                    failure: function(form, action) {
                        Ext.Msg.alert('Failed', action.result.msg);
                    }
                });
            }
            }
        },{
            text: 'Cancel',
            handler : function()
            {
            	if(win)
            	 win.close();
            }
        }
        ]
    });
    
    win = getWindowObj("Login Form", loginForm, 300, 150);
	win.show();
}
function showForgotPasswordForm() {
       alert('test');
    }