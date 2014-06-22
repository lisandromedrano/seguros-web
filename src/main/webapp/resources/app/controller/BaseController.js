Ext.define('app.controller.BaseController', {
    extend: 'Ext.app.Controller',
    init: function() {
		this.callParent(arguments);
	}
	,gridButtonAdd:function(button){
		var initialRecord=Ext.create(this.model);
		if(this.parentConfig!=undefined){
			//Master-Detail Model
			var parentFieldName=this.parentConfig.fieldName
			var parentRecord=Ext.create(this.parentConfig.model,this.getParentForm().getValues());
			if(parentRecord.data.id)
				initialRecord.data[parentFieldName+'.id']=parentRecord.data.id;		
//			Ext.Object.each(app.utils.flattenObject(parentRecord.data), function(key, value,
//					myself) {
//				initialRecord.data[parentFieldName+'.' + key] = value;
//			})
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
		var sendData = Ext.ModelManager.create(
				e.record.data,
		        this.model
		    );	
		
		this.save(sendData);
	}	
	,gridRowDelete:function(button){		
		var grid=this.getGrid();	
		var selection =	 grid.getSelectionModel().getSelection()[0];
		var url = CONTEXT_ROOT+'/'+this.controller+'/delete';
		var deleteEntity=function(buttonId){
			var cancel = buttonId=='no';
			if(cancel)
				return;
			if (selection) {
				Ext.Ajax.request({
					url: url,
					method: 'POST',
					params: {id:selection.data.id},
					success: function(response){
						var responseObject= Ext.JSON.decode(response.responseText);
				    	if(responseObject.success){
				    		grid.store.reload();			    		
				    	}else{
				    		Ext.Msg.alert({
			                 	  title:'Failed', 
			                 	  msg: responseObject.message?responseObject.message : 'No response',
			                 	  buttons: Ext.Msg.OK,
			                 	  icon:Ext.Msg.ERROR
			                 	 });
				    	}
						
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
		Ext.Msg.show({
            title: 'Borrar',
            msg: 'Esta seguro de borrar el registro?',
            buttons: Ext.Msg.YESNO,
            icon: Ext.Msg.QUESTION,
            fn: deleteEntity
       }); 
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
	,save:function(record){
		var grid=this.getGrid();
		record.fields.each(function(field){
//			console.log(field)
			if(field.type.type=='date'){
				record.data[field.name]=Ext.Date.format(record.data[field.name],field.dateFormat)
			}
		});
		 Ext.Ajax.request({
			    url: CONTEXT_ROOT+'/'+this.controller+'/',
			    method: 'POST',
			    params: record.data,
			    success: function(response){
			    	var r=JSON.parse(response.responseText);
			    	if(r.success && grid){
			    		grid.store.reload();			    		
			    	}else{
			    		Ext.Msg.alert({
			    			title:'Failed', 
			    			msg: r.message ? r.message : 'No response',
			    					buttons: Ext.Msg.OK,
			    					icon:Ext.Msg.ERROR
			    		});
			    		
			    	}
					
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
	/**
	 * Fill all combo fields
	 */
	,fillComboFields:function(form,record,comboFields){
		comboFields.forEach(function(field){
			var formField=form.findField(field.fieldId);
			var comboRecord=record.data[field.fieldName];
			if(comboRecord){
				if(comboRecord['id']){
					if (formField != null) 
						formField.setValue(comboRecord['id'])
				}else if(comboRecord[field.fieldValue]){
					var vpStore=formField.store;
					vpStore.add(comboRecord)
					formField.select(vpStore.getAt(vpStore.getCount()-1))					
					formField.setRawValue(comboRecord[field.fieldValue])
				}
			}
		})
		
	}
	/**
	 * HighLights fields in array 
	 */
	,highlightFields:function(form,fields){
		fields.forEach(function(field){
			var formField=form.findField(field);
			formField.setFieldStyle('background-color:#edc8b4');
		});	
	}
	/**
	 * If a combo has text set but not the value, removes the id in the record, and adds the name property, in order to submit just name
	 */
	,replaceNullValuesCombos:function(form,record,fields){
		fields.forEach(function(field){
			if(isNaN(record[field.fieldId]) || record[field.fieldId]=="" || record[field.fieldId]==null){
				if(isNaN(record[field.fieldId])){
					record[field.fieldName+'.'+field.fieldValue]=record[field.fieldId];					
				}else{
					record[field.fieldName+'.'+field.fieldValue]=form.findField(field.fieldId).getDisplayValue();
				}
				delete record[field.fieldId];
			}			
		});
	}

})
    