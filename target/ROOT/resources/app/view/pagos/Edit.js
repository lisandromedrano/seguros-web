Ext.define("app.view.pagos.Edit", {
	extend: 'Ext.form.Panel',
    alias:'widget.pagosEdit',
	url:CONTEXT_ROOT+'/pagos/',
	layout: 'fit',
	requires:[
			 'app.view.polizas.ComboBox', 
			 'app.view.companias.ComboBox'
    ],
	autoShow: true,
	fieldDefaults: {
	    msgTarget: 'side',
	    //labelWidth: 150,
	    //width:400,
	    //anchor: '50%',
	    style:'padding:10px;margin:10px'
	}, 
	layout: {
		type: 'column'
			// The total column count must be specified here
	    ,columns: 2
	}, 
	initComponent: function(params) {
		this.items=[
			
			 {
				xtype:'datefield',
				fieldLabel: 'fecha',
				name:'fecha'
			 },
				
			 {
				xtype:'textfield',
				fieldLabel: 'importe',
				name:'importe'
			 },
				
			 {
				xtype:'textfield',
				fieldLabel: 'tipoPago',
				name:'tipoPago'
			 },
				
			 {
				xtype:'textfield',
				fieldLabel: 'concepto',
				name:'concepto'
			 },
				
			 {
				xtype:'textfield',
				fieldLabel: 'nroRecibo',
				name:'nroRecibo'
			 },
				
			 {
				xtype:'datefield',
				fieldLabel: 'fechaVencimiento',
				name:'fechaVencimiento'
			 },
	
			// combo candidate for polizas
			{
				xtype:'polizasCombo',
				fieldLabel: 'polizas',
				name:'polizas.id'
			 }, 
				// combo candidate for companias
			{
				xtype:'companiasCombo',
				fieldLabel: 'companias',
				name:'companias.id'
			 }
		];
		this.buttons = [
	            {
	                text:'Save',
	                itemId:'save',
	                iconCls:'icon-save',
 					handler:function(button){
		    			button.up('form').getForm().submit({
	                		waitMsg: 'Saving data...',
	                		submitEmptyText : false,
		    				success: function(form, action) {
				            	var grid=Ext.query('pagosList');
				            	if(grid != undefined){
					    			grid.getStore().reload();
				            	}		            	
				            	app.util.bubbleMessage("OK", "Pagos Saved");
	//	                        Ext.Msg.alert('Success', action.result.message);
		                     },
		                     failure: function(form, action) {
		                         Ext.Msg.alert({
		                        	  title:'Failed', 
		                        	  msg: action.result ? action.result.message : 'No response',
		                        	  buttons: Ext.Msg.OK,
		                        	  icon:Ext.Msg.ERROR
		                        	 });
		                         
		                     }
		               	});
	            	}
	            },
	            {
	                text:'Cancel',
	                scope:this,
	                iconCls:'icon-reset',
	                handler:this.close
	            }
	    ];
		this.callParent(arguments);
	}
	
});