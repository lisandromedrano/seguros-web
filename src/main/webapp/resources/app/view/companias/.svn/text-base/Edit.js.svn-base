Ext.define("app.view.companias.Edit", {
	extend: 'Ext.form.Panel',
    alias:'widget.companiasEdit',
	url:CONTEXT_ROOT+'/companias/',
	layout: 'fit',
	requires:[
			 'app.view.pagos.ComboBox'
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
				xtype:'textfield',
				fieldLabel: 'nombre',
				name:'nombre'
			 },
	
			// combo candidate for pagos
			{
				xtype:'pagosCombo',
				fieldLabel: 'pagos',
				name:'pagos.id'
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
				            	var grid=Ext.query('companiasList');
				            	if(grid != undefined){
					    			grid.getStore().reload();
				            	}		            	
				            	app.util.bubbleMessage("OK", "Companias Saved");
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