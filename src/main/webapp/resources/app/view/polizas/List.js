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
				header: 'Numero'
				,dataIndex: 'nroPoliza'
				,flex: 1
				,align:'right'
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'Endoso'
				,dataIndex: 'endoso'
				,align:'right'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},

	        {
				header: 'Bien'
				,dataIndex: 'bienACubrir'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},

	        {
				header: 'Riesgo'
				,dataIndex: 'riesgoACubrir'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},

	        {
				header: 'Orden'
				,dataIndex: 'orden'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}//,
		
			];
		
		}
		
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
	            ,name     : 'buscarPoliza'
	            ,itemId     : 'buscarPoliza'
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

