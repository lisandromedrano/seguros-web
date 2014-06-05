Ext.define('app.view.clientes.List', {
	extend: 'app.view.BaseGrid',
	alias: 'widget.clientesList',
	requires:[
			 //'app.view.polizas.ComboBox'
    ],
	title: 'Clientes',
	store: 'Clientes',
	initComponent: function() {
		var _this=this;		
		this.columns = [
			{
				hidden:true
				,dataIndex:'id'
			},
		    {
				header: 'nombre'
				,dataIndex: 'nombre'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'apellido'
				,dataIndex: 'apellido'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
//	        {
//				header: 'direccion'
//				,dataIndex: 'direccion'
//				,flex: 1
//				,field: { xtype: 'textfield' }
//				
//			},
//	        {
//				header: 'telefono'
//				,dataIndex: 'telefono'
//				,flex: 1
//				,field: { xtype: 'textfield' }
//				
//			},
	        {
				header: 'email'
				,dataIndex: 'email'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}//,
//	        {
//				header: 'observaciones'
//				,dataIndex: 'observaciones'
//				,flex: 1
//				,field: { xtype: 'textfield' }
//				
//			},
//	        {
//				header: 'fNacimiento'
//				,dataIndex: 'fNacimiento'
//				,flex: 1
//				,field: { xtype: 'datefield' }
//				
//			},
//	        {
//				header: 'dnicuit'
//				,dataIndex: 'dnicuit'
//				,flex: 1
//				,field: { xtype: 'textfield' }
//				
//			},
//			// combo candidate for polizas
//			{
//				header: 'polizas'
//				,id: 'polizas.id'
//				,flex: 1
//				,editor: { xtype: 'polizasCombo' }				
//				,renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {				       
//				       return store.data.items[rowIndex].data.polizas.name;
//				}
//			},				 
			];
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
            	text: 'Actualizar',
	    	    iconCls:'x-tbar-loading',
	    	    scope: this,
	    	    handler: function(){
	    			this.store.load();	
	    		}
	        	
	        },{
	        	xtype:'textfield'
	            ,name     : 'buscarCliente'
	            ,itemId     : 'buscarCliente'
	            ,width: 140
	            ,emptyText: 'Buscar cliente'
	        },
            '->',{
                text: 'Agregar',
                itemId:'add',
                iconCls: 'icon-add'

            }, 
             {
                itemId: 'delete',
                text: 'Borrar',
                iconCls: 'icon-delete',
                disabled: true
            }
			]
        }]
	    	
    	this.callParent(arguments);
	}
});

