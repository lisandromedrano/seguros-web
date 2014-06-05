Ext.define('app.view.companias.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.companiasList',
	requires:[
			 //'app.view.pagos.ComboBox'
    ],
	title: 'Companias',
	store: 'Companias',
	initComponent: function() {
		var _this=this;
		if(this.editionMode==app.utils.EditionMode.ROW){
			this.plugins=[Ext.create('Ext.grid.plugin.RowEditing')];
		}
		this.columns = [
		    {
		    	hidden:true
		    	,dataIndex:'id'
		    },
	        {
				header: 'nombre'
				,dataIndex: 'nombre'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}
			];
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
                text: 'Add',
                itemId:'add',
                iconCls: 'icon-add'//,
				//handler: function(){
	            //    // empty record
				//	if(_this.editionMode==app.utils.EditionMode.ROW){					
		        //        _this.store.insert(0, new app.model.Companias());
	            //    	companiasRowEditing.startEdit(0, 0);                
				//	}
                //
	            //}
            }, 
             {
                itemId: 'delete',
                text: 'Delete',
                iconCls: 'icon-delete',
                disabled: true
            }
			//,{
            //    itemId: 'edit',
            //    text: 'Edit',
            //    iconCls: 'icon-edit',
            //    disabled: true
            //}
			]
        }]
        this.on('selectionchange', function(selModel, selections){
	        //this.down('#edit').setDisabled(selections.length === 0);
	        this.down('#delete').setDisabled(selections.length === 0);	        
	    });
		//this.on('edit', function(editor, e) {
	    //    // commit the changes right after editing finished
	    //    Ext.Ajax.request({
		//	    url: CONTEXT_ROOT+'/companias/',
		//	    method: 'POST',
		//	    params: e.record.data,
		//	    success: function(response){
		//			e.grid.store.reload();
		//			
		//	    }
		//	});
	    //});
	    	
    	this.callParent(arguments);
	}
});

