Ext.define('app.controller.Companias', {
    extend: 'Ext.app.Controller',
    views: ['companias.List'],
	stores:  ['Companias'],
	refs: [{
	    ref: 'companiasList',
	    selector: 'companiasList'
	}],
	init: function() {
		this.control({
			'companiasList':{
					itemdblclick: function(thisO, record, item, index, e, eOpts){
						if(this.getCompaniasList().editionMode!=app.utils.EditionMode.ROW){
	
							var xtype = 'companiasEdit';
							var idTab = 'companias-'+record.data.id;
							var title = record.data.serverName;
							var form;
							if(this.getCompaniasList().editionMode==app.utils.EditionMode.WINDOW){
								var win=app.utils.openWindow(xtype,title);
								form = win.query('companiasEdit')[0].getForm();
							}else if(this.getCompaniasList().editionMode==app.utils.EditionMode.TAB){							
								var win=app.utils.openTab(xtype,title,idTab);
								form = win.getForm();
							}
							
							
							form.loadRecord(record)
							//fill combos							
							//form.findField('pagos.id').setValue(record.data.pagos.id)
						}	
	
		        	}
					,edit: function(editor, e) {
				        // commit the changes right after editing finished
				        Ext.Ajax.request({
						    url: CONTEXT_ROOT+'/companias/',
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
						//Ext.getCmp('pagos.id').getEditor().setValue(record.data.pagos.id);

				    }	
					,render:function(grid){
						grid.store.load();
					}	
				}
				,'companiasList > toolbar > button#add':{
		    		click:function(button){
						//Uncomment if you want edit on a window instead on the grid
						if(this.getCompaniasList().editionMode!=app.utils.EditionMode.ROW){
							var xtype = 'companiasEdit';
							var idTab = 'companias-new';
							var title = 'New';							  
							app.utils.openTab(xtype,title,idTab);
							if(this.getCompaniasList().editionMode==app.utils.EditionMode.WINDOW){
								app.utils.openWindow(xtype,title);							
							}else if(this.getCompaniasList().editionMode==app.utils.EditionMode.TAB){							
								app.utils.openTab(xtype,title,idTab);
							}   			
						}else{
			    			this.getCompaniasList().store.insert(0, new app.model.Companias());
			    			this.getCompaniasList().plugins[0].startEdit(0, 0);                
			    		}
		    		}
		    	},'companiasList > toolbar > button#delete':{
		    		click:function(button){
			    		var grid=button.up('companiasList');
			    		var selection =	 grid.getSelectionModel().getSelection()[0];
	                    if (selection) {
							Ext.Ajax.request({
							    url: CONTEXT_ROOT+'/companias/delete',
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
				,'companiasEdit > button#save':{
		    		click:function(button){
		    			var grid=button.up('companiasList');
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
