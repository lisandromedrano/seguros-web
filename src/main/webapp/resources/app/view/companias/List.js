Ext.define('app.view.companias.List', {
	extend: 'app.view.BaseGrid',
	alias: 'widget.companiasList',
	requires:[
			 //'app.view.pagos.ComboBox'
    ],
//    iconCls:'icon_companias',
	title: 'Companias',
	store: 'Companias',
	initComponent: function() {
		var _this=this;

		this.columns = [
		    {
		    	hidden:true
		    	,dataIndex:'id'
		    },
	        {
				header: 'Nombre'
				,dataIndex: 'nombre'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}
		];
    	this.callParent(arguments);
	}
});

