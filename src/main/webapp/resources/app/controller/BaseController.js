Ext.define('app.controller.BaseController', {
    extend: 'Ext.app.Controller',
    init: function() {
		this.callParent(arguments);
	}
	,gridButtonAdd:function(button){
		var initialRecord=Ext.create(this.model);
		if(this.parentConfig!=undefined){
			//Master-Detail Model
			var parentRecord=Ext.create(this.parentConfig.model,this.getParentForm().getValues());
			initialRecord.data[this.parentConfig.fieldName]=parentRecord.data;			
		}
		if(this.getGrid().editionMode!=app.utils.EditionMode.ROW){
			var xtype = this.editionFormXtype;
			var idTab = this.controller+'-new';
			var title = 'New';							  
			//app.utils.openTab(xtype,title,idTab);
			var win;
			if(this.getGrid().editionMode==app.utils.EditionMode.WINDOW){
				win=app.utils.openWindow(xtype,title);							
			}else if(this.getGrid().editionMode==app.utils.EditionMode.TAB){							
				win=app.utils.openTab(xtype,title,idTab);
			}   
			this.getForm().loadRecord(initialRecord);
		}else{
			this.getGrid().store.insert(0, initialRecord);
			this.getGrid().plugins[0].startEdit(0, 0);                
		}
	}
	,gridRowDblClick:function(thisO, record, item, index, e, eOpts){
		if(this.getGrid().editionMode!=app.utils.EditionMode.ROW){			
			var xtype = this.editionFormXtype;
			var idTab = this.controller+'-'+record.data.id;
			var title = record.data[this.titleField];
			var form;
			var win;
			if(this.getGrid().editionMode==app.utils.EditionMode.WINDOW){
				win=app.utils.openWindow(xtype,title);
				form = win.query(this.editionFormXtype)[0].getForm();
			}else if(this.getGrid().editionMode==app.utils.EditionMode.TAB){							
				win=app.utils.openTab(xtype,title,idTab);
				form = win.getForm();
			}				
			form.loadRecord(record)
			//fill combos
			if(typeof this.afterFillFormFn == 'function') { 
			    this.afterFillFormFn(win,form,record); 
			}			}		
	}	
	,gridRowEdit:function(editor, e){
		 Ext.Ajax.request({
			    url: CONTEXT_ROOT+'/'+this.controller+'/',
			    method: 'POST',
			    params: e.record.data,
			    success: function(response){
					e.grid.store.reload();
					
			    }, failure: function(form, action) {
                  Ext.Msg.alert({
                 	  title:'Failed', 
                 	  msg: action.result ? action.result.message : 'No response',
                 	  buttons: Ext.Msg.OK,
                 	  icon:Ext.Msg.ERROR
                 	 });
                  
              }
			});
	}	
	,gridRowDelete:function(button){		
		var grid=this.getGrid();	
		var selection =	 grid.getSelectionModel().getSelection()[0];
        if (selection) {
			Ext.Ajax.request({
			    url: CONTEXT_ROOT+'/'+this.controller+'/delete',
			    method: 'POST',
			    params: {id:selection.data.id},
			    success: function(response){
					grid.store.reload();
					
//			    	app.utils.requestMessageProcessor(grid.store.proxy,response);
					
			    },
			    error: function(response){
			    	//app.utils.requestMessageProcessor(grid.store.proxy,response);
			    	 Ext.Msg.alert({
			        	  title:'Failed', 
			        	  msg: action.result ? action.result.message : 'No response',
			        	  buttons: Ext.Msg.OK,
			        	  icon:Ext.Msg.ERROR
			        	 });
					
			    }
			});
        }
	}	
	,buttonSaveClick:function(button){
		console.log('button save click');
		var grid=this.getGrid();		
		var entityName=this.entityName;
		var form=button.up('form').getForm();
		var formObj = Ext.ModelManager.create(
	        form.getValues(),
	        this.model
	    );	
	    //console.log(errors);
	
//	    form.loadRecord(customer);
	
	    //form.isValid();
	    //console.log(form.isValid());
		var errors = formObj.validate();
		if(errors.isValid()){
			form.submit({
				waitMsg: 'Saving data...',
				submitEmptyText : false,
				success: function(form, action) {
			    	app.utils.bubbleMessage("OK", entityName+" Saved");
			    	if(grid.editionMode==app.utils.EditionMode.WINDOW || button.itemId=='saveAndClose'){
			    		button.up('panel').close()
			    	}
					grid.store.reload();
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
		}else{
			form.markInvalid(errors);	
		}
		
		
	}
	,validateedit: function(editor, e, eOpts){
	    var newModel = e.record.copy(); //copy the old model
	    newModel.set(e.newValues); //set the values from the editing plugin form

	    var errors = newModel.validate(); //validate the new data
	    if(!errors.isValid()){
	      editor.editor.form.markInvalid(errors); //the double "editor" is correct
	      return false; //prevent the editing plugin from closing
	    }
	}

})
    