Ext.define('app.view.BaseGrid', {
	extend: 'Ext.grid.Panel',
	editionMode:app.utils.EditionMode.ROW,
	
	initComponent:function(){
		if(this.editionMode==app.utils.EditionMode.ROW){
			this.plugins=[Ext.create('Ext.grid.plugin.RowEditing',{
				saveBtnText  : 'Actualizar',
				cancelBtnText: 'Cancelar'			
			})];
		}	
		if(this.dockedItems==undefined){
			this.dockedItems = [{
	            xtype: 'toolbar',
	            items: [{
	            	text: 'Refresh',
		    	    iconCls:'x-tbar-loading',
		    	    scope: this,
		    	    handler: function(){
		    			this.store.load();	
		    		}
		        	
		        },
	            '->',{
	                text: 'Agregar',
	                itemId:'add',
	                iconCls: 'icon-add'
	
	            }, 
	             {
	                itemId: 'delete',
	                text: 'Borrar',
	                iconCls: 'icon-delete',
	                disabled: true
	            }
				]
	        }]
		}
		this.bbar=[{xtype: 'pagingtoolbar',
			pageSize: 25,
			displayInfo: true,
	        store: this.store}];
        this.on('selectionchange', function(selModel, selections){	       
	        this.down('#delete').setDisabled(selections.length === 0);	        
	    });
	    	
    	this.callParent(arguments);
	}

});
