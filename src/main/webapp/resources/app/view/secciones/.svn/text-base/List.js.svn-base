Ext.define('app.view.secciones.List', {
//	extend: 'Ext.grid.Panel',
	extend: 'app.view.BaseGrid',
	alias: 'widget.seccionesList',
	requires:[
			 //'app.view.listofpolizas.ComboBox'
    ],
	title: 'Secciones',
	store: 'Secciones',
	initComponent: function() {
		var _this=this;		
		this.columns = [
	        {
				dataIndex: 'id'
				,hidden:true	
				
			},
	        {
				header: 'nombre'
				,dataIndex: 'nombre'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'codigo'
				,dataIndex: 'codigo'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}
					 
		];
	    	
    	this.callParent(arguments);
	}
});

