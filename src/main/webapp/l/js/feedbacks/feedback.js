
function getFeedbackGrid()
{
  var grid = Ext.create('Ext.grid.Panel', {
    columns: [
        {
            text     : 'Submitted By',
            dataIndex: 'name',
            width    : 225,
        },
        {
            text     : 'Date',
            dataIndex: 'postedDate',
            renderer : Ext.util.Format.dateRenderer('m/d/Y')
        },
        {
            text     : 'Feedback',
            flex     : 1,
            width    : 175,
            dataIndex: 'content'
        }
    ],
    height: '80%',
    width: '100%',
    title: 'Feedback',
    store : feedbackStore,
    viewConfig: {
        stripeRows: true,
        loadMask : true
    }
});
  
  return grid;
}