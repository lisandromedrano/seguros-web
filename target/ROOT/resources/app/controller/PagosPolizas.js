Ext.define('app.controller.PagosPolizas', {
    extend: 'app.controller.BaseController',
    views: ['pagospolizas.List'],
	stores:  ['PagosPolizas'],
	refs: [{
	    ref: 'pagospolizasList',
	    selector: 'pagospolizasList'
	},{
	    ref: 'grid',
	    selector: 'pagospolizasList'
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
			'pagospolizasList':{
				itemdblclick:me.gridRowDblClick
				,edit:me.gridRowEdit
				,validateedit:me.validateedit
				,scope:me
			}
			,'pagospolizasList > toolbar > button#add':{
				click:me.gridButtonAdd,
				scope:me
	    	}
			,'pagospolizasList > toolbar > button#delete':{
	    		click:me.gridRowDelete,
	    		scope: me
	    	}		    	
			,'polizasEdit>toolbar>button#save':{
				click:me.buttonSaveClick,
				scope: me
			}
		
			});
	}
	
});
