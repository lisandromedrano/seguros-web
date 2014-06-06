Ext.define("app.view.BaseForm", {
	extend: 'Ext.form.Panel',
	alias:'widget.baseForm',
	autoScroll: true,
	fieldDefaults : {
		msgTarget : 'side',
		// labelWidth: 150,
		// width:400,
		// anchor: '50%',
		width : '80%',
		labelAlign : 'top',
		style : 'padding:10px;margin:10px'
	},
	initComponent: function(params) {
		var _this=this
		if(!this.customButtons){
			this.buttons = [
            {
            	text:'Guardar',
            	itemId:'save',
            	iconCls:'icon-save',
		        handler:function(button,event){
//		    		_this.fireEvent('save');
//		        	this.buttonSaveClick()
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
		}else{
			this.buttons=this.customButtons;
		}
		this.callParent(arguments);
	}
	,buttonSaveClick:function(button,event){
		var controller=Ext.create(button.up('form').controllername)
		var grid=controller.getGrid();		
		var entityName=controller.entityName;
		var titleField=controller.titleField;
		var record;
		var form=controller.getForm();
		if(typeof controller.getFormValues == 'function') { 
			record=controller.getFormValues(this.up('form')); 
		}else{
			record=form.getValues();
		}
		var formObj = Ext.ModelManager.create(
	        record,
	        controller.model
	    );	
	    //console.log(errors);	
	    //form.isValid();
	    //console.log(form.isValid());
		var errors = formObj.validate();
		if(errors.isValid()){
			var myMask = new Ext.LoadMask(button.up('form'), {msg: 'Guardando'});
			myMask.show();
			var backendController=controller.controller;
			Ext.Ajax.request({
	            url: CONTEXT_ROOT+'/'+backendController+'/',
	            method: 'POST',
	            type: "json",
	            params: record,
	            success: function(response) {
	            	var responseObject= Ext.JSON.decode(response.responseText);
	            	myMask.hide();
	            	if(responseObject.success){
	            		app.utils.bubbleMessage("OK", entityName+" "+ 'Guardado');
	            		form.setTitle(formObj.data[titleField]);
	            		if(grid!=undefined){
	            			grid.store.reload();			    		
	            		}
	            		if(responseObject.id!=undefined){
	            			//set Id for the new Entity
	            			form.getForm().setValues({'id':responseObject.id});
	            			//change window/tab title
	            		}
	            		if(form.editionMode==app.utils.EditionMode.WINDOW || button.itemId=='saveAndClose'){
	            			form.close();
	            		}
	            		if(typeof this.callbackSuccessFn == 'function') { 
	            			callbackSuccessFn(form.getValues());						
	            		}
	            	}else{
	            		Ext.Msg.alert({
		                 	  title:'Failed', 
		                 	  msg: responseObject.message?responseObject.message : 'No response',
		                 	  buttons: Ext.Msg.OK,
		                 	  icon:Ext.Msg.ERROR
		                 	 });
	            	}
	            },
	            error:function(form, action){
	            	myMask.hide();
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

});