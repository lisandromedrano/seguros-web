Ext.define('app.controller.PagosPolizasByPoliza', {
    extend: 'app.controller.BaseController',
    views: ['pagospolizas.List'],
	stores:  ['PagosPolizas'],
	refs: [{
	    ref: 'pagospolizasList',
	    selector: 'pagospolizasListByPoliza'
	},{
	    ref: 'grid',
	    selector: 'pagospolizasListByPoliza'
	},{
	    ref: 'form',
	    selector: 'pagospolizasEdit'
	},{//Master-detail config
	    ref: 'parentForm',
	    selector: 'polizasEdit'
	}],
	init: function() {
		var me = this;
		this.entityName="Pago Poliza";
		this.controller="pagospolizas";
		//Master-detail config
		this.parentConfig={
				model:"app.model.Polizas"
				,fieldName:'polizas'				
		}
		//--
		this.model="app.model.PagosPolizas";
		this.editionFormXtype="pagospolizasEdit";
		this.titleField='fecha';
		this.afterFillFormFn=function(panel,form,record){
			//fill combos					
//			panel.setTitle(record.data.bienACubrir.substr(0,10));
//			form.findField('companias.id').setValue(record.data.companias.id);
//			form.findField('secciones.id').setValue(record.data.tipoPoliza.id);
		}
		this.control({
			'pagospolizasListByPoliza':{
				itemdblclick:me.gridRowDblClick
//				,edit:me.gridRowEdit
//				,edit: function(editor, object) {
//                    object.store.save();
//                    object.store.commitChanges();
//                }
				,edit:function(editor, e){
					//truncate polizas Data
//					var polizaID=e.record.data.polizas.id
					delete e.record.data.polizas
//					e.record.data.polizas={
//							id:polizaID
//					};					
					//e.record.data['polizas.id']=polizaID
					me.save(e.record);
				}
				,validateedit:me.validateedit
				,scope:me
			}
			,'pagospolizasListByPoliza > toolbar > button#add':{
				click:me.gridButtonAdd,
				scope:me
	    	}
			,'pagospolizasListByPoliza > toolbar > button#delete':{
	    		click:me.gridRowDelete,
	    		scope: me
	    	}	
			,'pagospolizasListByPoliza > toolbar > button#generarPlanPagos':{
				click:function(button){
					var idPoliza=me.getGrid().idPoliza
					//preguntar fecha primer vencimiento
					var win=Ext.create('Ext.window.Window', {
					    title: 'Seleccione fecha primer vencimiento',
//					    height: 150,
//					    width: 300,
					    bodyStyle:'padding:20px',
					    buttons: [{text:'OK',handler:function(){
					    	var date=win.query('datefield')[0].getValue();
					    	if(date!=undefined){
					    		date=Ext.Date.format(date,'d-m-Y')
					    		Ext.Ajax.request({
					    			url:CONTEXT_ROOT+'/polizas/crearPlandePagos',
					    			method:'GET',
					    			params:{idPoliza:idPoliza,fechaPrimerVencimiento:date},
					    			success:function(response){
										var responseObject= Ext.JSON.decode(response.responseText);
								    	if(responseObject.success){
								    		me.getGrid().store.reload();			    		
								    		win.destroy();
								    	}else{
								    		Ext.Msg.alert({
							                 	  title:'Error', 
							                 	  msg: responseObject.message?responseObject.message : 'No response',
							                 	  buttons: Ext.Msg.OK,
							                 	  icon:Ext.Msg.ERROR
							                 	 });
								    		win.destroy();
								    	}
					    			}
					    		});
					    	}
				    			
					    }},{
					    	text:'cancelar'
					    	,handler:function(){
					    		win.destroy();					    		
					    	}
					    }],
					   
					    items: {  // Let's put an empty grid in just to illustrate fit layout
					        xtype: 'datefield',
					        format: 'd-m-Y',
					        fieldLabel:'Fecha'
					       
					    }
					});
					win.show();
					//ajax
					//si OK recargar grid
				},
				scope: me
			}	
			,'pagospolizasListByPoliza > toolbar > button#planPagos':{
				click: function(){
					var idPoliza=me.getGrid().idPoliza
					window.location=CONTEXT_ROOT+'/reportes/plandepagos/?idPoliza='+idPoliza;
				},
				scope:me
			}

			});
	}
	
});
