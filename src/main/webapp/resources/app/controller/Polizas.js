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
	    ref: 'addPagoPolizaButton',
	    selector: 'pagospolizasListByPoliza>toolbar>button#add'
	},{
		ref: 'planPagosButton',
		selector: 'pagospolizasListByPoliza>toolbar>button#planPagos'
	},{
	    ref: 'grid',
	    selector: 'polizasList'
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
		this.afterFillFormFn=function(panel,form,record){
			panel.setTitle(record.data.bienACubrir.substr(0,10));
			//fill combos					
			form.findField('companias.id').setValue(record.data.companias.id);
			form.findField('secciones.id').setValue(record.data.tipoPoliza.id);
//			this.fillComboFields(form, record, this.comboFields)
			
			me.getPagosPolizasList().store.proxy.extraParams={'polizas.id':record.data.id};
			me.getPagosPolizasList().store.load();
			me.getPagosPolizasList().idPoliza=record.data.id;
			me.getAddPagoPolizaButton().setDisabled(false);
			var buttonPlanPagos=me.getPlanPagosButton();
			if(buttonPlanPagos){
				buttonPlanPagos.setDisabled(false);
			}
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
				,'polizasEdit>toolbar>button#save':{
					render:function(){
						//disable add button from Contract Lines Grid
						me.getAddPolizaButton().setDisabled(true);
					}
				}
				,'polizasEdit>toolbar>button#save':{
					click:function(button,event){
						me.buttonSaveClick(button, event,function(){
							me.getAddPagoPolizaButton().setDisabled(false);							
						});
						
					},
					scope: me
				}
				,'polizasList > toolbar > textfield#buscarPoliza':{
		    		  specialkey: function(f,e){
		    				
		                  if (e.getKey() == e.ENTER) {
		                	  var inputValue=f.value.toUpperCase();
		                	  me.getPolizasList().store.load({
		                		  params:{findByName:f.value.toUpperCase()}})
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
