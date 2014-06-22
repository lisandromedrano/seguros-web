Ext.define('app.controller.Polizas', {
    extend: 'app.controller.BaseController',
    views: ['polizas.List'],
	stores:  ['Polizas'],
	refs: [{
	    ref: 'polizasList',
	    selector: 'polizasList'
	},{
	    ref: 'pagosPolizasList',
	    selector: 'pagospolizasListByPoliza'
	},{
		ref: 'form',
		selector: 'polizasEdit'
	},{
	    ref: 'addPagoPolizaButton',
	    selector: 'pagospolizasListByPoliza>toolbar>button#add'
	},{
		ref: 'planPagosButton',
		selector: 'pagospolizasListByPoliza>toolbar>button#planPagos'
	},{
	    ref: 'grid',
	    selector: 'polizasList'
	}],
	entityName:"Poliza",
	controller:"polizas",
	model:'app.model.Polizas',
	editionFormXtype:"polizasEdit",
	titleField:'name',
	comboFields:[
		{
			fieldName : 'companias',
			fieldId : 'companias.id',
			fieldValue : 'nombre'
		},
		{
			fieldName : 'secciones',
			fieldId : 'secciones.id',
			fieldValue : 'nombre'
		}
	],
	init: function() {
		
		var me = this;		
		this.titleField='name';
		this.afterFillFormFn=function(panel,form,record){
			panel.setTitle(record.data.bienACubrir.substr(0,10));
			//fill combos					
			form.findField('companias.id').setValue(record.data.companias.id);
			form.findField('tipoPoliza.id').setValue(record.data.tipoPoliza.id);
//			this.fillComboFields(form, record, this.comboFields)
			var pagosPolizasList=panel.query('pagospolizasListByPoliza')[0]
			pagosPolizasList.store.proxy.extraParams={'polizas.id':record.data.id};
			pagosPolizasList.store.load();
			pagosPolizasList.idPoliza=record.data.id;
			pagosPolizasList.query('button#add')[0].setDisabled(false);
			pagosPolizasList.query('button#planPagos')[0].setDisabled(false);
//			var buttonPlanPagos=me.getPlanPagosButton();
//			if(buttonPlanPagos){
//				buttonPlanPagos.setDisabled(false);
//			}
			
			//fill asegurado
			var asegurado=form.findField('asegurado');
			var value='<a onclick="app.utils.openClienteTab('+record.data.clientes.id+')">'+record.data.clientes.apellido+' '+record.data.clientes.nombre+'</a>'
			asegurado.setValue(value);
		}
		this.control({
				'polizasList':{
					itemdblclick:me.gridRowDblClick
					,edit:me.gridRowEdit
					,validateedit:me.validateedit
					,scope:me
				}
				,'polizasList > toolbar > button#add':{
					click:me.gridButtonAdd,
					scope:me
		    	}				
				,'polizasList > toolbar > button#delete':{
		    		click:me.gridRowDelete,
		    		scope: me
		    	}		    	
//				,'polizasEdit>toolbar>button#save':{
//					render:function(){
//						//disable add button from Contract Lines Grid
//						me.getAddPolizaButton().setDisabled(true);
//					}
//				}
//				,'polizasEdit>toolbar>button#save':{
//					click:function(button,event){
//						me.buttonSaveClick(button, event,function(){
//							me.getAddPagoPolizaButton().setDisabled(false);							
//						});
//						
//					},
//					scope: me
//				}
				,'polizasList > toolbar > textfield#buscarPoliza':{
		    		  specialkey: function(f,e){
		    				
		                  if (e.getKey() == e.ENTER) {
		                	  var inputValue=f.value.toUpperCase();
		                	  me.getPolizasList().store.currentPage = 1;
		                	  me.getPolizasList().store.proxy.extraParams={findByName:inputValue};
		                	  me.getPolizasList().store.load();
//		                	  me.getPolizasList().store.load({
//		                		  params:{findByName:f.value.toUpperCase()}})
		                  }
		               }
		        
		    	}
				,'polizasEdit>seccionesCombo':{
//					change:alert('changed')
				}
		
			});
		this.callParent(arguments);
		
	}
	
});
