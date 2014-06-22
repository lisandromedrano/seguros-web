Ext.define('app.controller.PolizasByCliente', {
    extend: 'app.controller.BaseController',
    views: ['polizas.PolizasClienteList'],
//	stores:  ['Polizas'],
	refs: [{
	    ref: 'polizasList',
	    selector: 'polizasClienteList'
	},{
	    ref: 'pagosPolizasList',
	    selector: 'pagospolizasListByPoliza'
	},{
	    ref: 'addPagoPolizaButton',
	    selector: 'pagospolizasListByPoliza>toolbar>button#add'
	},{
		ref: 'planPagosButton',
		selector: 'pagospolizasListByPoliza>toolbar>button#planPagos'
	
	},{//Master-detail config
	    ref: 'parentForm',
	    selector: 'clientesEdit'
	},{
		ref: 'form',
		selector: 'polizasEdit'
	},{
	    ref: 'grid',
	    selector: 'polizasClienteList'
	}],
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
		this.entityName="Poliza";
		this.controller="polizas";
		this.model="app.model.Polizas";
		this.editionFormXtype="polizasEdit";
		this.titleField='name';
		this.parentConfig={
				model:"app.model.Clientes"
				,fieldName:'clientes'				
		}
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
		}
		this.control({
				'polizasClienteList':{
					itemdblclick:me.gridRowDblClick
					,edit:me.gridRowEdit
					,validateedit:me.validateedit
					,scope:me
//					,render:function(grid){
//						//disable add button
//						grid.query("button#add")[0].setDisabled(true);
//					}
				}
				,'polizasClienteList > toolbar > button#add':{
					click:me.gridButtonAdd,
//					click : function(button, event) {
//						me.gridButtonAdd(button, event, {
//							record : {
//								data : {
//									'clientes.id' : me.getGrid().up('contractsEdit').getValues().id
//								}
//							}
//						});
//					},
					scope:me
		    	}				
				,'polizasClienteList > toolbar > button#delete':{
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
				,'polizasEdit>seccionesCombo':{
//					change:alert('changed')
				}
		
			});
		this.callParent(arguments);
		
	}
	
});
