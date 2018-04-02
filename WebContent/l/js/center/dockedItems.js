function getBottomDockedItems() {

	dockedItems =
		{
		dock : 'bottom',
		xtype : 'toolbar',
		items :
			[
			'->',
				{
				xtype : 'button',
				text : 'New User?',
				disabled : true,
				tooltip : 'Register free, to cutomize your screens!',
				listeners :
					{
						click : function() {
							showRegisterForm();
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'LogIn',
				disabled : true,
				tooltip : 'Get into application to play with',
				listeners :
					{
						click : function() {
							showLogonForm();
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'Development Credits',
				tooltip : 'Helping hands are purer than saying lips.',
				iconCls:'dev',
				listeners :
					{
						click : function() {
							showDevCreditsWindow(this);
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'Download Fonts',
				tooltip : 'Download your local fonts',
				disabled : true,
				listeners :
					{
						click : function() {
							var tempForm = getSignInForm();
							getWindowObj("Login Form", tempForm, 300, 150);
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'Switch to Newface',
				iconCls:'think',
				tooltip : 'Move to AlliBilli Newface, Think Special',
				listeners :
					{
						click : function() {
							window.location = "http://www.allibilli.com/flex4/AlliBilli.html";
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'Curruption',
				id : 'corruption',
				disabled : true,
				tooltip : 'Fight againist Corruption in India',
				listeners :
					{
						click : function() {
							checkAndTabOrActivateTab('AlliBilli Blog', 'AlliBilliBlog', "http://allibilli.blog.com");
						}
					}
				},'->'
			]
		};

	return dockedItems;
}
function getTopDockedItems() {

	dockedItems =
		{
		dock : 'bottom',
		xtype : 'toolbar',
		items :
			[
			'->',
				{
				xtype : 'button',
				text : 'Customize Screens',
				tooltip : 'Customize the links and screens as needed, Login Required',
				disabled : true,
				listeners :
					{
						click : function() {
							var tempForm = getSignInForm();
							getWindowObj("Login Form", tempForm, 300, 150);
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'Password Manager',
				disabled : true,
				tooltip : 'Remember your Passwords',
				listeners :
					{
						click : function() {
							var tempForm = getRegisterForm();
							getWindowObj("New User Form", tempForm, 600, 250);
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'Expenses Tracker',
				disabled : true,
				tooltip : 'Note my Expenses',
				listeners :
					{
						click : function() {
							var tempForm = getRegisterForm();
							var win = getWindowObj("New User Form", tempForm, 600, 250);
							win.show();
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'CCS',
				iconCls:'ccs',
				tooltip : 'Move to Center Communication Systems',
				listeners :
					{
						click : function() {
							window.location = "http://kumon.allibilli.com";
						}
					}
				},'-',
				{
				xtype : 'button',
				text : 'Youtube Music',
				id:'youTubeWndw',
				iconCls:'youtube',
				tooltip : 'You can avoid the Ads in yout tube',
				listeners :
					{
						click : function(button) {

							if(youTubeWndw==null)
								loadYoutubePlayer(this);
							else if(youTubeWndw!=null && youTubeWndw.isHidden())
								{
									youTubeWndw.show();
								}
							else
								youTubeWndw.hide();
	
						}
					}
				}, '-',
				{
				xtype : 'button',
				text : 'Collapse',
				id : 'exColl',
				iconCls : 'collapseBtn',
				tooltip : 'Close both side panels',
				listeners :
					{
						click : function() {
							
							if(this.text == 'Collapse')
								{
								collapseBoth();
								
								this.setText('Expand');
								}
							else
								{
								expandBoth();
								this.setText('Collapse');
								}
							
						}
					}
				},'->'
			]
		};


	return dockedItems;
}