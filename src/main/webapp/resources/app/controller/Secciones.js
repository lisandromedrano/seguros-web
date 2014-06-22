Ext.define('app.controller.Secciones', {
//    extend: 'Ext.app.Controller',
    extend: 'app.controller.BaseController',
    views: ['secciones.List'],
	stores:  ['Secciones'],
	refs: [{
	    ref: 'seccionesList',
	    selector: 'seccionesList'
	},{
	    ref: 'grid',
	    selector: 'seccionesList'
	}],
	init: function() {
		var me = this;
		this.entityName="Seccion";
		this.controller="secciones";
		this.model="app.model.Secciones";
		this.editionFormXtype="seccionesEdit";
		this.titleField='nombre';	
		this.control({
				'seccionesList':{
					itemdblclick:me.gridRowDblClick
					,edit:me.gridRowEdit
					,scope:me
					,render:function(grid){
						grid.store.load();
					}	
				}
				,'seccionesList > toolbar > button#add':{
					click:me.gridButtonAdd,
					scope:me
		    	},'seccionesList > toolbar > button#delete':{
		    		click:me.gridRowDelete,
		    		scope: me
		    	}
				,'seccionesEdit > button#save':{
					click:me.buttonSaveClick,
					scope: me
		    	}
		
			});
	}
	
});
