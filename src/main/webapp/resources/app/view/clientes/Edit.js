Ext.define("app.view.clientes.Edit", {
//	extend: 'Ext.form.Panel',
	extend: 'app.view.BaseForm',
    alias:'widget.clientesEdit',
    controllername:'app.controller.Clientes',
	url:CONTEXT_ROOT+'/clientes/',
	layout: 'fit',
	requires:[
			 'app.view.polizas.PolizasClienteList'
			 ,'app.view.BaseForm'
    ],
	autoShow: true,
	autoHeight:true,
	iconCls:'icon_clientes_edicion',
	autoScroll: true,
	style:'padding:5px',
//	fieldDefaults: {
//	    msgTarget: 'under',
//	    //labelWidth: 150,
//	    width:400,
//	    //anchor: '50%',
//	    labelAlign : 'top',
//	    style:'padding:10px;margin:10px'
//	}, 
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
		            	fieldLabel: 'Apellido / Razon Social',
		            	name:'apellido'
		            },
				 {
					xtype:'textfield',
					fieldLabel: 'Nombre',
					name:'nombre'
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
//					vtype:'email',
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
					{	xtype:'polizasClienteList'
						,height:300}
				 ]
		}
		];		
		this.callParent(arguments);
        this.enableBubble('change');
	}
	//Function to call after save
	,callbackSuccessFn:function() {
		var controller=Ext.create('app.controller.Clientes');
		var record =this.getValues();
		// Set environment id for licences grid			
		controller.getPolizasGrid().clienteId = record.id;
		controller.getPolizasGrid().query('button#add')[0].setDisabled(false)
		// Enable add button			
		var title=record.apellido;
		if(record.nombre){
			title = title + ', '+record.nombre
		}
		this.setTitle(title);
		controller.getPolizasGrid().store.proxy.extraParams={'clientes.id':record.data.id};
		controller.getPolizasGrid().store.load();
	}
	
});