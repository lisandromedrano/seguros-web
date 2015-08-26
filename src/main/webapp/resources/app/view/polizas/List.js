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
	iconCls:'icon_polizas',
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
				,width:50
//				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
			{
				header: 'Asegurado'
				,dataIndex: 'clientes.nombreApellido'
//				,align:'right'
				,flex: 1
				,field: { xtype: 'textfield' }
				,renderer: function(value,p, record){
//					return record.data.clientes.nombreApellido
					return record.data.clientes.apellido+ ' '+record.data.clientes.nombre
				}
			
			},
			
	        {
				header: 'Bien'
				,dataIndex: 'bienACubrir'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},

			{
				header: 'Patente'
					,dataIndex: 'patente'
						,width:250
						,field: { xtype: 'textfield' }
			
			},
	        {
				header: 'Riesgo'
				,dataIndex: 'riesgoACubrir'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}//,

//	        {
//				header: 'Orden'
//				,dataIndex: 'orden'
//				,flex: 1
//				,field: { xtype: 'textfield' }
//				
//			}//
			,{
			header : 'Vencimiento',
			dataIndex : 'fVigHasta',
			width:200,
			sortType : Ext.data.SortTypes.asDate,
			renderer : Ext.util.Format.dateRenderer('d-m-Y'),
			field : {
				xtype : 'datefield',
				format : 'd-m-Y'
			}

		},
		
			];
		
		}
		if(!this.dockedItems){
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
//	            ,name     : 'buscarPoliza'
						,itemId     : 'buscarPoliza'
							,submitValue:false
							,width: 300
							,emptyText: 'Buscar por Numero, Asegurado, Bien, o Patente'
				},
				'->',
//            {
//                text: 'Agregar',
//                itemId:'add',
//                iconCls: 'icon-add'
//
//            }, 
				{
					itemId: 'delete',
					text: 'Borrar',
					iconCls: 'icon-delete',
					disabled: true
				}
				]
			}]
			
		}
		
    	this.callParent(arguments);
	}
});

