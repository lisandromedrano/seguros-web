Ext.define('app.controller.Companias', {
    extend: 'app.controller.BaseController',
    views: ['companias.List'],
	stores:  ['Companias'],
	refs: [{
	    ref: 'companiasList',
	    selector: 'companiasList'
	},{
	    ref: 'grid',
	    selector: 'companiasList'
	}],
	init: function() {
		var me=this;
		this.entityName="Compania";
		this.controller="companias";
		this.model="app.model.Companias";
		this.editionFormXtype="companiasEdit";
		this.titleField='nombre';	
		this.control({
			'companiasList':{
					itemdblclick:me.gridRowDblClick
					,edit:me.gridRowEdit
					,scope:me
					,render:function(grid){
						grid.store.load();
					}	
				}
				,'companiasList > toolbar > button#add':{
					click:me.gridButtonAdd,
					scope:me
		    	},'companiasList > toolbar > button#delete':{
		    		click:me.gridRowDelete,
		    		scope: me
		    	}
				,'companiasEdit > button#save':{
					click:me.buttonSaveClick,
					scope: me
		    	}
		
			});
	}
	
});
