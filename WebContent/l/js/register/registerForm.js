/**
 * 
 */
 function showRegisterForm()
 {
 	 var win;
     var registerFrom = Ext.create('Ext.form.Panel', {
        url:'register.do',
        frame:true,
        border : false,
        bodyBorder : false,
        bodyStyle:'padding:10px 10px 10px 10px',
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 100
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '100%'
        },
        items: [{
            fieldLabel: 'Display Name',
            name: 'displayName',
            allowBlank:false
        },{
            fieldLabel: 'Email Id',
            name: 'Email Id',
            allowBlank:false,
            vtype: 'email, uniqueusername'
        },{
            fieldLabel: 'Password',
            name: 'pwd',
            allowBlank:false,
            inputType : 'password'
        },{
            fieldLabel: 'Confirm Password',
            name: 'confPwd',
            allowBlank:false,
            inputType : 'password',
            vtype: 'confirmPwd', 
            initialPassField: 'pwd'
        }],

        buttons: [{
            text: 'Register',
            formBind : true, // only enabled once the form is valid
			disabled : true,
            handler : function()
            {
            	var form = this.up('form').getForm();
            if (form.isValid()) {
                // Submit the Ajax request and handle the response
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
        }]
    });
    
    win = getWindowObj("Registration Form", registerFrom, 400, 200);
	win.show();
}