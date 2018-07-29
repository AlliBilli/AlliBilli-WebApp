
Ext.define('Ext.chooser.InfoPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.infopanel',
    id: 'img-detail-panel',

    width: 150,
    minWidth: 150,

   tpl: [
        '<div class="details">',
            '<tpl for=".">',
                    (!Ext.isIE6? '<img src="devCredits/photos/{iddevcredits}.jpg" width="120" height="120"/>' :
                    '<div style="width:74px;height:74px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'devCredits/photos/{iddevcredits}.jpg\')"></div>'),
                '<div class="details-info">',
                    '<b><u>Name:</u></b>',
                    '<span>{name}</span>',
                    '<b><u>Location:</u></b>',
                    '<span>{location}</span>',
                    '<b><u>About Me:</u></b>',
                    '<span>{description}</span>',
                    '<b><u>Contributed Work:</u></b>',
                    '<span>{helpType}</span>',
                '</div>',
            '</tpl>',
        '</div>'
    ],

    /**
     * Loads a given image record into the panel. Animates the newly-updated panel in from the left over 250ms.
     */
    loadRecord: function(image) {
        this.body.hide();
        this.tpl.overwrite(this.body, image.data);
        this.body.slideIn('l', {
            duration: 250
        });
    }
});
