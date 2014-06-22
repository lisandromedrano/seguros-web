Ext.define('app.view.clientes.List', {
	extend: 'app.view.BaseGrid',
	alias: 'widget.clientesList',
	requires:[
			 //'app.view.polizas.ComboBox'
    ],
	title: 'Clientes',
	store: 'Clientes',
	iconCls:'icon_clientes',
	initComponent: function() {
		var _this=this;		
		this.columns = [
			{
				hidden:true
				,dataIndex:'id'
			},
			{
				header: 'Apellido o Razon Social'
					,dataIndex: 'apellido'
						,flex: 1
						,field: { xtype: 'textfield' }
			
			},
		    {
				header: 'Nombre'
				,dataIndex: 'nombre'
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
	        {
				header: 'Telefono'
				,dataIndex: 'telefono'
				,flex: 1
				,align:'right'
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'email'
				,dataIndex: 'email'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
//	        {
//				header: 'observaciones'
//				,dataIndex: 'observaciones'
//				,flex: 1
//				,field: { xtype: 'textfield' }
//				
//			},
	        {
				header: 'F. Nacimiento'
				,dataIndex: 'fNacimiento'
				,renderer : Ext.util.Format.dateRenderer('d-m-Y')
				,flex: 1
				,field: { xtype: 'datefield' }
				
			},
	        {
				header: 'CUIT/DNI'
				,dataIndex: 'dnicuit'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}
			 
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
	            ,width: 300
	            ,emptyText: 'Buscar por nombre, razon social o CUIT/DNI'
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

