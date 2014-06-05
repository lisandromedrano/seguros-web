Ext.define("app.view.clientes.Edit", {
//	extend: 'Ext.form.Panel',
	extend: 'app.view.BaseForm',
    alias:'widget.clientesEdit',
	url:CONTEXT_ROOT+'/clientes/',
	layout: 'fit',
	requires:[
			 'app.view.polizas.List'
			 ,'app.view.BaseForm'
    ],
	autoShow: true,
	autoScroll: false,
	fieldDefaults: {
	    msgTarget: 'side',
	    //labelWidth: 150,
	    width:400,
	    //anchor: '50%',
	    style:'padding:10px;margin:10px'
	}, 
	layout: {
		type: 'border'			
	}, 
	initComponent: function(params) {
		this.polizasGrid=Ext.create('app.view.polizas.List',{
			viewConfig: {
		        stripeRows: true
		    }
			,autoScroll:true
			,editionMode:app.utils.EditionMode.TAB
		     ,store:Ext.create('Ext.data.Store', {
			    model : 'app.model.Polizas',
				proxy: {
				    type: 'ajax',
				    url:  CONTEXT_ROOT+'/'+'polizas/polizasPorCliente',
					reader: {
				        type: 'json',
				        successProperty:'success',
				        totalProperty: 'results'
				    },autoLoad:false
				}
			})
			,columns:[
			      {dataIndex:'id',hidden:true}
				   ,{
					   dataIndex: 'bienACubrir'
						,header: 'Bien A Cubrir'
						,flex: 1
						,field: { xtype: 'textfield' }
						
					}
				   ,{
						header: 'Nro. Poliza'
						,dataIndex: 'nroPoliza'
						,flex: 1
						,field: { xtype: 'textfield' }
						
					}
				   ,{
						header: 'Endoso'
						,dataIndex: 'endoso'
						,flex: 1
						,field: { xtype: 'textfield' }
						
					}
				   ,{
					   text:'Vigencia'
						,flex: 1
					   ,columns:[
						   {
								header: 'Desde'
								,dataIndex: 'fVigDesde'
								,renderer: Ext.util.Format.dateRenderer('d-m-Y')
								,field: { xtype: 'datefield',format: 'd-m-Y' }
								
							},
					        {
								header: 'Hasta'
								,dataIndex: 'fVigHasta'
								,renderer: Ext.util.Format.dateRenderer('d-m-Y')
								,field: { xtype: 'datefield' ,format: 'd-m-Y'}
								
							}
					   ]
				   }
			]
		 });
		this.items=[
		{
			region: 'center'			
			,layout: {
				type: 'column'
					// The total column count must be specified here
			    ,columns: 2
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
				 }
		    ]			 
		},{
			region:'south'
			,xtype:'form'
			,style:'padding:10px;'
			,height:'50%'
			 ,items:[this.polizasGrid]
			}
		];
		this.callParent(arguments);
        this.enableBubble('change');
	}
	
});