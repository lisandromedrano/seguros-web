Ext.define("app.view.clientes.Edit", {
//	extend: 'Ext.form.Panel',
	extend: 'app.view.BaseForm',
    alias:'widget.clientesEdit',
    controllername:'app.controller.Clientes',
	url:CONTEXT_ROOT+'/clientes/',
	layout: 'fit',
	requires:[
			 'app.view.polizas.List'
			 ,'app.view.BaseForm'
    ],
	autoShow: true,
	autoHeight:true,
	autoScroll: false,
	style:'padding:5px',
	fieldDefaults: {
	    msgTarget: 'side',
	    //labelWidth: 150,
	    width:400,
	    //anchor: '50%',
	    style:'padding:10px;margin:10px'
	}, 
//	layout: {
//		type: 'border'			
//	}, 
	initComponent: function(params) {
		this.layout = {
				type : 'vbox'
				// The total column count must be specified here
				// ,columns : 4
				,
				align : 'stretch'
			}
//		this.polizasGrid=Ext.create('app.view.polizas.List',{
////			viewConfig: {
////		        stripeRows: true
////		    }
//			autoScroll:true
//			,title:false
//			,autoHeight : true
//			,editionMode:app.utils.EditionMode.TAB
//		    ,store:Ext.create('Ext.data.Store', {
//			    model : 'app.model.Polizas',
//				proxy: {
//				    type: 'ajax',
//				    url:  CONTEXT_ROOT+'/'+'polizas/polizasPorCliente',
//					reader: {
//				        type: 'json',
//				        successProperty:'success',
//				        totalProperty: 'results'
//				    },autoLoad:false
//				}
//			})
//			,columns:[
//			      {dataIndex:'id',hidden:true}
//				   ,{
//					   dataIndex: 'bienACubrir'
//						,header: 'Bien A Cubrir'
//						,flex: 1
//						,field: { xtype: 'textfield' }
//						
//					}
//				   ,{
//						header: 'Nro. Poliza'
//						,dataIndex: 'nroPoliza'
//						,flex: 1
//						,field: { xtype: 'textfield' }
//						
//					}
//				   ,{
//						header: 'Endoso'
//						,dataIndex: 'endoso'
//						,flex: 1
//						,field: { xtype: 'textfield' }
//						
//					}
//				   ,{
//					   text:'Vigencia'
//						,flex: 1
//					   ,columns:[
//						   {
//								header: 'Desde'
//								,dataIndex: 'fVigDesde'
//								,renderer: Ext.util.Format.dateRenderer('d-m-Y')
//								,field: { xtype: 'datefield',format: 'd-m-Y' }
//								
//							},
//					        {
//								header: 'Hasta'
//								,dataIndex: 'fVigHasta'
//								,renderer: Ext.util.Format.dateRenderer('d-m-Y')
//								,field: { xtype: 'datefield' ,format: 'd-m-Y'}
//								
//							}
//					   ]
//				   }
//			]
//		 });
		this.items=[
		{
			xtype:'fieldset',
			title:'Datos del cliente',
			style:'margin-right:5px',
			layout: {
				type: 'table'
					// The total column count must be specified here
			    ,columns: 3
			}
		    ,items:[
				 {
					xtype:'textfield',
					fieldLabel: 'Nombre',
					name:'nombre'
				 },
					
				 {
					xtype:'textfield',
					fieldLabel: 'Apellido',
					name:'apellido'
				 },
					
				 {
					xtype:'textfield',
					fieldLabel: 'Direccion',
					name:'direccion'
				 },
					
				 {
					xtype:'textfield',
					fieldLabel: 'Telefono',
					name:'telefono'
				 },
					
				 {
					xtype:'textfield',
					fieldLabel: 'Email',
					name:'email'
				 },
					
				 {
					xtype:'textarea',
					fieldLabel: 'Observaciones',
					name:'observaciones'
				 },
					
				 {
					xtype:'datefield',
					fieldLabel: 'F. Nacimiento',
					format: 'd-m-Y',
					name:'fNacimiento'
				 },
					
				 {
					xtype:'textfield',
					fieldLabel: 'DNI/CUIT',
					name:'dnicuit'
				 },
				 {
					 xtype:'textfield',
					 name:'id',
					 hidden:true
				 }
		    ]
		},{
			 xtype:'fieldset',
				title: 'Polizas',
			//	width:'70%',
				items:[
//				       	this.polizasGrid
{	xtype:'polizasClienteList'}
				 ]
		}
		];
		
//		//Function to call after save
//		this.callbackSuccessFn=function(record) {
//			var controller=Ext.create('app.controller.Clientes');
//			// Set environment id for licences grid			
//			controller.getPolizasGrid().clienteId = record.id;
//			// Enable add button
////			controller.getAddLicenseButton().setDisabled(false);
////			controller.saveAppOptions();
//			
//			this.setTitle(record.data.nombre+' '+record.data.apellido);
//			controller.getPolizasGrid().store.proxy.extraParams={id:record.data.id};
//			controller.getPolizasGrid().store.load();
//		};
//		this.customButtons = [
//   		    '->',{
//   		        text: 'Guardar',
//   		        itemId:'save',
//   		        iconCls:'icon-save',
//   		        handler:function(button,event){
//   		        	this.buttonSaveClick(button,event)
//   		        }
//   		    
//   		    },
//   		    {
//   		        text: 'Cancelar',
//   		        scope:this,
//   		        iconCls:'icon-cancel',
//   		        handler:this.close
//   		    }
//   		];
		
		
		this.callParent(arguments);
        this.enableBubble('change');
	}
	
});