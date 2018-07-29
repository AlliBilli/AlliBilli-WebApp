/**
 * 
 */

Ext.apply(Ext.form.VTypes, {
	uniqueusername : function(val, field) {
		var username = Ext.getCmp('regUsername').getValue();
		Ext.Ajax.request({
			url: 'check_username.php',
			method: 'POST',
			params: 'username=' + username,
			success: function(o) {
				if (o.responseText == 0) {
					setusernamevalidfalse();
				}
			}
		});
		return true;
	},

	uniqueusernameText : 'Username Already In Use'
});

function setusernamevalidfalse() {
	Ext.apply(Ext.form.VTypes, {
		uniqueusername : function(val, field) {
			var username = Ext.getCmp('regUsername').getValue();
			Ext.Ajax.request({
				url: 'check_username.php',
				method: 'POST',
				params: 'username=' + username,
				success: function(o) {
					if (o.responseText == 0) {
						setusernamevalidfalse();
					} else {
						setusernamevalidtrue();
					}
				}
			});
			return false;
		}
	});
}

function setusernamevalidtrue() {
	Ext.apply(Ext.form.VTypes, {
		uniqueusername : function(val, field) {
			var username = Ext.getCmp('regUsername').getValue();
			Ext.Ajax.request({
				url: 'check_username.php',
				method: 'POST',
				params: 'username=' + username,
				success: function(o) {
					if (o.responseText == 0) {
						setusernamevalidfalse();
					} else {
						setusernamevalidtrue();
					}
				}
			});
			return true;
		}
	});
}

Ext.apply( Ext.form.VTypes, {
	
	confirmPwd : function(val,field)
	{
		if(field.initialPassField)
		{
			var pwd = Ext.getCmp(field.initialPassField);
			return (val == pwd.getValue());
		}
		return true;
	},
	pwdText : 'Passwords entered dont macth'
});

 