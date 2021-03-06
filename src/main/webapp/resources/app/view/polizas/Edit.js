Ext.define("app.view.polizas.Edit", {
	extend : 'app.view.BaseForm',
	alias : 'widget.polizasEdit',
	url : CONTEXT_ROOT + '/polizas/',
	layout : 'fit',
	requires : [ 'app.view.secciones.ComboBox'
	             , 'app.view.companias.ComboBox'// ,
	             , 'app.view.pagospolizas.ListByPoliza'// ,
	// 'app.view.pagospolizas.ComboBox',
	// 'app.view.clientes.ComboBox'
	],
	style:'padding:5px',
	autoShow : true,
	 controllername:'app.controller.Polizas',
	 iconCls:'icon_polizas_edit',
	initComponent : function(params) {
		var _this = this;
		this.layout = {
				type : 'vbox'
				// The total column count must be specified here
				// ,columns : 4
				,align : 'stretch'
			}
		this.defaults = {
				xtype : 'fieldset',
				width : '100%',
				style:'padding:5px'
		}
		this.items = [ {
			
			title : 'Datos Generales',
			defaults : {
				msgTarget : 'side',
				// labelWidth: 150,
				width : 400,
				// anchor: '50%',
				style : 'padding:10px;margin:10px;vertical-align:top'
			},
//			layout : {
//				type : 'table'
//				// The total column count must be specified here
//				,
//				columns : 3
//			}
			layout : {
					type : 'vbox'
					// The total column count must be specified here
					// ,columns : 4
					,
					align : 'stretch'
				},			
			items :[{
				layout : {
					type : 'table',
					columns : 5
				},
				autoScroll:true,
				style : 'padding:10px;padding-bottom:15px;margin:10px;vertical-align:top',
				items:[
						{
						    xtype: 'displayfield',
						    fieldLabel: 'Asegurado',
						    name: 'asegurado',
						    fieldStyle: 'color: blue; text-decoration:underline; cursor:pointer',
//						    listeners:{
//						    	click:function(){alert('ayangena!')}
//						    },
						    tpl:new Ext.XTemplate('<tpl>{apellido}, {nombre}</tpl>')
//						    value: '10'
						},
						{
							xtype: 'fieldcontainer',
							layout: 'hbox',
							fieldLabel : 'Num. Poliza / Endoso',
							items:[
							       {
							    	   xtype : 'textfield',
							    	   hideLabel:true,			
							    	   margins: '0 0 0 0',
//							    	   fieldLabel : 'Num. Poliza',
							    	   name : 'nroPoliza'
							       },
							       {
							    	   xtype : 'textfield',
							    	   hideLabel:true,
//							    	   fieldLabel : 'Endoso',
							    	   width:40,
							    	   name : 'endoso'
							       }						
							
							]
							
						},
				       {
							xtype : 'textfield',
							fieldLabel : 'Bien A Cubrir',
							colspan:2,
							maxLenght:200,
							name : 'bienACubrir'
						},
						{
							xtype : 'textfield',
							fieldLabel : 'Riesgo A Cubrir',
							name : 'riesgoACubrir'
						},
						
						{
							xtype : 'textfield',
							fieldLabel : 'Tipo Cobertura',
							name : 'tipoCobertura'
						},
						//2nd row
						{
							xtype : 'numberfield',
							fieldLabel : 'Cuotas',
							minValue:1,
							maxValue:24,
							name : 'cantCuotas'
						},
						{
							xtype : 'numberfield',
							fieldLabel : 'Prima',
							decimalSeparator:'.',
							name : 'prima'
						},
				
				
						{
							xtype : 'numberfield',
							decimalSeparator:'.',
							fieldLabel : 'Premio',
							name : 'premio'
						},
						{
							xtype : 'numberfield',
							decimalSeparator:'.',
							fieldLabel : 'Suma',
							name : 'suma'
						},
				
						{
							xtype : 'textfield',
							fieldLabel : 'Moneda',
							width:30,
							value:'$',
							name : 'moneda'
						},		{
							xtype : 'datefield',
							fieldLabel : 'Fecha Registracion',
							format: 'd-m-Y',
							name : 'fRegistracion'
						},
				
						{
							xtype : 'numberfield',
							fieldLabel : 'Orden',
							name : 'orden'
						},
				
						// combo candidate for companias
						{
							xtype : 'companiasCombo',
							fieldLabel : 'Compania',
							name : 'companias.id'
						},
						// combo candidate for secciones
						{
							xtype : 'seccionesCombo',
							fieldLabel : 'Tipo Poliza',
							colspan:2,
							name : 'tipoPoliza.id'
						} ,
						{
							xtype : 'fieldset',
							title : 'Vigencia',
							layout:{type:'table'},
							colspan : 2,	
							style:'margin-right:5px',
							items : [ {
								xtype : 'datefield',
								fieldLabel : 'Desde',
								format: 'd-m-Y',
								name : 'fVigDesde'
							}, {
								xtype : 'datefield',
								fieldLabel : 'Hasta',
								format: 'd-m-Y',
								name : 'fVigHasta'
							},
				
							]
						}, {
							xtype : 'fieldset',
							title : 'Datos del Vehiculo',
							colspan : 3,
							layout:{type:'table'},
							items : [ {
								xtype : 'textfield',
								fieldLabel : 'Nro. Chasis',
								name : 'nroChasis'
							}, {
								xtype : 'textfield',
								fieldLabel : 'Patente',
								name : 'patente'
							}, {
								xtype : 'textfield',
								fieldLabel : 'Nro. Motor',
								name : 'nroMotor'
							} ]
						},
						{
							xtype : 'textarea',
							fieldLabel : 'Observaciones',
							width: 400,
							colspan : 3,
							name : 'observaciones'
						},{
							xtype : 'hidden',
							name : 'id'
						},{
							xtype : 'hidden',
							name : 'clientes.id'
						}
						
				]
			}
			]
		}, {
			xtype : 'fieldset',
			title: 'Pagos',
			items:[
			       {
			    	   xtype : 'pagospolizasListByPoliza',
			    	   height:250,
			    	   title:false
			       }
			]
		} // ,
			
		];
		this.customButtons = [
		                {
		                	text:'Crear Copia',
		                	itemId:'copy',
		                	iconCls:'icon_polizas_copy',
		    		        handler:function(button,event){
		    		        	var form=this.up('form');
		    		        	var fieldsToClear=[
		    		        	         'id',
		    		        	        'nroPoliza',
		    		        	        'fRegistracion',
		    		        	        'suma','prima','premio','fVigDesde','fVigHasta'
		    		        	]
		    		        	form.clearFields(fieldsToClear);
		    		        	var pagosList=form.query('pagospolizasListByPoliza')[0];
		    		        	pagosList.store.removeAll();
		    		        	pagosList.query('button#add')[0].setDisabled(false);
		    		        	pagosList.query('button#planPagos')[0].setDisabled(false);
		    		        	pagosList.query('button#generarPlanPagos')[0].setDisabled(false);
//		    		        	estado = NUEVO;
//		    		    		HibernateSessionFactory.getSession().evict(poliza);
//		    		    		this.poliza=new Poliza();
//		    		    		poliza.setCliente(cliente);
////		    		    		txtNroPoliza.setEditable(true);
//		    		    		txtNroPoliza.setText("");
//		    		    		txtPrima.setText("");
//		    		    		txtPremio.setText("");
//		    		    		txtSuma.setText("");
//		    		    		txtf_venc_hasta.setText("");
//		    		    		txtf_venc_desde.setText("");
//		    		    		txtf_registracion.setText("");
//		    		    		pagosTM.setNumRows(0);
//		    		    		txtOrden.setText(""+Poliza.getLastOrden());
//		    		    		habilitarEdicion();
		    		    	}
		                		
		                },
		                {
		                	text:'Guardar',
		                	itemId:'save',
		                	iconCls:'icon-save',
		                	handler:function(button,event){
//		    		    		_this.fireEvent('save');
//		    		        	this.buttonSaveClick()
		                		var form=this.up('form')
		                		form.buttonSaveClick(button,event);
		                	}
		                
		                },
		                {
		                	text:'Cancelar',
		                	scope:this,
		                	iconCls:'icon-cancel',
		                	handler:this.close
		                }
		                ];
		this.callParent(arguments);
	}
	//Function to call after save
	,callbackSuccessFn:function() {
		var controller=Ext.create('app.controller.Polizas');
		var record =this.getValues();
		// Set poliza id for pagos grid			
		controller.getPagosPolizasList().store.proxy.extraParams={'polizas.id':record.id};
		controller.getPagosPolizasList().store.load();
		controller.getPagosPolizasList().idPoliza=record.id;
		
		this.setTitle(record.bienACubrir.substr(0,10));
		
		// Enable add pago button			
		controller.getAddPagoPolizaButton().setDisabled(false);
		controller.getPlanPagosGenerarButton().setDisabled(false);
		var buttonPlanPagos=controller.getPlanPagosButton();
		if(buttonPlanPagos){
			buttonPlanPagos.setDisabled(false);
		}
		
	}

});