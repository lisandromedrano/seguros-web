var pagosRowEditing = Ext.create('Ext.grid.plugin.RowEditing');
Ext.define('app.view.pagos.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.pagosList',
	requires:[
			 'app.view.polizas.ComboBox', 
			 'app.view.companias.ComboBox'
    ],
	title: 'Pagos',
	store: 'Pagos',
	plugins: [pagosRowEditing],
	initComponent: function() {
		var _this=this;
		if(this.editionMode==app.utils.EditionMode.ROW){
			this.plugins=[Ext.create('Ext.grid.plugin.RowEditing')];
		}
		this.columns = [
	        {
				header: 'fecha'
				,dataIndex: 'fecha'
				,flex: 1
				,field: { xtype: 'datefield' }
				
			},
	        {
				header: 'importe'
				,dataIndex: 'importe'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'tipoPago'
				,dataIndex: 'tipoPago'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'concepto'
				,dataIndex: 'concepto'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'nroRecibo'
				,dataIndex: 'nroRecibo'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			},
	        {
				header: 'fechaVencimiento'
				,dataIndex: 'fechaVencimiento'
				,flex: 1
				,field: { xtype: 'datefield' }
				
			},
			// combo candidate for polizas
			{
				header: 'polizas'
				,id: 'polizas.id'
				,flex: 1
				,editor: { xtype: 'polizasCombo' }				
				,renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {				       
				       return store.data.items[rowIndex].data.polizas.name;
				}
			},				 
				// combo candidate for companias
			{
				header: 'companias'
				,id: 'companias.id'
				,flex: 1
				,editor: { xtype: 'companiasCombo' }				
				,renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {				       
				       return store.data.items[rowIndex].data.companias.name;
				}
			},				 
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
		        //        _this.store.insert(0, new app.model.Pagos());
	            //    	pagosRowEditing.startEdit(0, 0);                
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
		//	    url: CONTEXT_ROOT+'/pagos/',
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

