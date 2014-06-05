Ext.define('app.controller.Pagos', {
    extend: 'Ext.app.Controller',
    views: ['pagos.List'],
	stores:  ['Pagos'],
	refs: [{
	    ref: 'pagosList',
	    selector: 'pagosList'
	}],
	init: function() {
		this.control({
			'pagosList':{
					itemdblclick: function(thisO, record, item, index, e, eOpts){
						if(this.getPagosList().editionMode!=app.utils.EditionMode.ROW){
	
							var xtype = 'pagosEdit';
							var idTab = 'pagos-'+record.data.id;
							var title = record.data.serverName;
							var form;
							if(this.getPagosList().editionMode==app.utils.EditionMode.WINDOW){
								var win=app.utils.openWindow(xtype,title);
								form = win.query('pagosEdit')[0].getForm();
							}else if(this.getPagosList().editionMode==app.utils.EditionMode.TAB){							
								var win=app.utils.openTab(xtype,title,idTab);
								form = win.getForm();
							}
							
							
							form.loadRecord(record)
							//fill combos							
							form.findField('polizas.id').setValue(record.data.polizas.id)
							form.findField('companias.id').setValue(record.data.companias.id)
						}	
	
		        	}
					,edit: function(editor, e) {
				        // commit the changes right after editing finished
				        Ext.Ajax.request({
						    url: CONTEXT_ROOT+'/pagos/',
						    method: 'POST',
						    params: e.record.data,
						    success: function(response){
								e.grid.store.reload();
								
						    }
						});
					}
					,beforeedit: function(editor, e) {
				    	var record=e.record;
				    	//fill combos
						Ext.getCmp('polizas.id').getEditor().setValue(record.data.polizas.id);
						Ext.getCmp('companias.id').getEditor().setValue(record.data.companias.id);

				    }	
					,render:function(grid){
						grid.store.load();
					}	
				}
				,'pagosList > toolbar > button#add':{
		    		click:function(button){
						//Uncomment if you want edit on a window instead on the grid
						if(this.getEnvironmentsList().editionMode!=app.utils.EditionMode.ROW){
							var xtype = 'pagosEdit';
							var idTab = 'pagos-new';
							var title = 'New';							  
							app.utils.openTab(xtype,title,idTab);
							if(this.getPagosList().editionMode==app.utils.EditionMode.WINDOW){
								app.utils.openWindow(xtype,title);							
							}else if(this.getPagosList().editionMode==app.utils.EditionMode.TAB){							
								app.utils.openTab(xtype,title,idTab);
							}   			
						}else{
			    			this.getPagosList().store.insert(0, new app.model.Pagos());
			    			this.getPagosList().plugins[0].startEdit(0, 0);                
			    		}
		    		}
		    	},'pagosList > toolbar > button#delete':{
		    		click:function(button){
			    		var grid=button.up('pagosList');
			    		var selection =	 grid.getSelectionModel().getSelection()[0];
	                    if (selection) {
							Ext.Ajax.request({
							    url: CONTEXT_ROOT+'/pagos/delete',
							    method: 'POST',
							    params: {id:selection.data.id},
							    success: function(response){
									grid.store.reload();
							    	app.utils.requestMessageProcessor(grid.store.proxy,response);
									
							    },
							    error: function(response){
							    	app.utils.requestMessageProcessor(grid.store.proxy,response);
									
							    }
							});
	                    }
		    		}
		    	}
				,'pagosEdit > button#save':{
		    		click:function(button){
		    			var grid=button.up('pagosList');
		    			var store = grid.store;
		    			button.up('form').getForm().submit({
		               	 success: function(form, action) {
	//	                        Ext.Msg.alert('Success', action.result.message);
		                        grid.getStore().reload();
		                     },
		                     failure: function(form, action) {
		                         //Ext.Msg.alert('Failed', action.result ? action.result.message : 'No response');
		                     }
		               	});
		    			
		    		}
		    	}
		
			});
	}
	
});
