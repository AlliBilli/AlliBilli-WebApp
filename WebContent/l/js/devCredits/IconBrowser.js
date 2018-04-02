Ext
    .define('Ext.chooser.IconBrowser',
	    {
	    extend : 'Ext.view.View',
	    alias : 'widget.iconbrowser',
	    uses : 'Ext.data.Store',
	    singleSelect : true,
	    overItemCls : 'x-view-over',
	    itemSelector : 'div.thumb-wrap',
	    tpl :
		    [
		    '<tpl for=".">', '<div class="thumb-wrap">', '<div class="thumb">', (!Ext.isIE6 ? '<img src="devCredits/photos/{iddevcredits}.jpg" width="120" height="120"/>' : '<div style="width:74px;height:74px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'devCredits/photos/{iddevcredits}.jpg\')"></div>'), '</div>', '<span>{name}</span>', '<hr noshade color="#92B7C9"><br></div>', '</tpl>'
		    ],
	    store : listDevCreditsStore	    
	    });
