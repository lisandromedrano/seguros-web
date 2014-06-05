Ext.define('app.view.polizas.PolizasClienteList', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.polizasClienteList',	
	title: 'Polizas',
	editionMode:app.utils.EditionMode.ROW,
	initComponent: function() {
		var _this=this;
		if(this.editionMode==app.utils.EditionMode.ROW){
			this.plugins=[Ext.create('Ext.grid.plugin.RowEditing')];
		}
		this.store=Ext.create('Ext.data.Store', {
		    model : 'app.model.Polizas',
			proxy: {
			    type: 'ajax',
			    url:  CONTEXT_ROOT+'/'+'polizas/findByCliente',
				reader: {
			        type: 'json',
			        successProperty:'success',
			        totalProperty: 'results'
			    },autoLoad:false
			}
		});
//		if(this.idCliente){
//			this.store.proxy.extraParams={id:this.idCliente};
//		}		
		this.columns=[
              {dataIndex:'id',hidden:true}
		   ,{
			   dataIndex: 'bienACubrir'
				,header: 'Bien A Cubrir'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}
		   ,{
				header: 'Nro. Poliza'
				,dataIndex: 'nroPoliza'
				,flex: 1
				,field: { xtype: 'textfield' }
				
			}
		   ,{
				header: 'F. Desde'
				,dataIndex: 'fVigDesde'
				,flex: 1
				,field: { xtype: 'datefield',format: 'd-m-Y' }
				
			},
	        {
				header: 'F. Hasta'
				,dataIndex: 'fVigHasta'
				,flex: 1
				,field: { xtype: 'datefield' ,format: 'd-m-Y'}
				
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
		        //        _this.store.insert(0, new app.model.Polizas());
	            //    	polizasRowEditing.startEdit(0, 0);                
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
			]
        }]
        this.on('selectionchange', function(selModel, selections){
	        //this.down('#edit').setDisabled(selections.length === 0);
	        this.down('#delete').setDisabled(selections.length === 0);	        
	    });	    	
    	this.callParent(arguments);
	}
});

