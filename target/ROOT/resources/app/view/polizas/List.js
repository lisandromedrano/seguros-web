Ext.define('app.view.polizas.List', {
	extend: 'app.view.BaseGrid',
	alias: 'widget.polizasList',
	requires:[
			 'app.view.companias.ComboBox', 
			 'app.view.secciones.ComboBox', 
			 'app.view.pagospolizas.ComboBox', 
			 'app.view.clientes.ComboBox'
    ],
	title: 'Polizas',
	store: 'Polizas',	
	initComponent: function() {
		
		if(this.columns==undefined){
			this.columns = [
			{hidden:true,dataIndex:'id'},
			{
				header: 'nroPoliza'
				,dataIndex: 'nroPoliza'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'endoso'
				,dataIndex: 'endoso'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},

	        {
				header: 'bienACubrir'
				,dataIndex: 'bienACubrir'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},

	        {
				header: 'riesgoACubrir'
				,dataIndex: 'riesgoACubrir'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},

	        {
				header: 'orden'
				,dataIndex: 'orden'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}//,
		
			];
		
		}
		
		
		
    	this.callParent(arguments);
	}
});

