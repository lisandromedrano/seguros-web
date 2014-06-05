Ext.define('app.controller.Polizas', {
    extend: 'app.controller.BaseController',
    views: ['polizas.List'],
	stores:  ['Polizas'],
	refs: [{
	    ref: 'polizasList',
	    selector: 'polizasList'
	},{
	    ref: 'pagosPolizasList',
	    selector: 'pagospolizasList'
	},{
	    ref: 'addPagoPolizaButton',
	    selector: 'pagospolizasList>toolbar>button#add'
	},{
	    ref: 'grid',
	    selector: 'polizasList'
	}],
	init: function() {
		var me = this;
		this.entityName="Poliza";
		this.controller="polizas";
		this.model="app.model.Polizas";
		this.editionFormXtype="polizasEdit";
		this.titleField='name';
		this.afterFillFormFn=function(panel,form,record){
			//fill combos					
			panel.setTitle(record.data.bienACubrir.substr(0,10));
			form.findField('companias.id').setValue(record.data.companias.id);
			form.findField('secciones.id').setValue(record.data.tipoPoliza.id);
			
			me.getPagosPolizasList().store.proxy.extraParams={'polizas.id':record.data.id};
			me.getPagosPolizasList().store.load();
			me.getAddPagoPolizaButton().setDisabled(false);
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
				,'polizasEdit>seccionesCombo':{
//					change:alert('changed')
				}
		
			});
		this.callParent(arguments);
		
	}
	
});
