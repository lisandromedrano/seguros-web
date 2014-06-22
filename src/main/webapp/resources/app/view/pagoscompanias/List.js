Ext.define('app.view.pagoscompanias.List',{
	extend : 'app.view.BaseGrid',
	alias : 'widget.pagoscompaniasList',
	requires : [ 'app.view.companias.ComboBox' ],
	title : 'Pagos a Companias',
	store : 'PagosCompanias',
	iconCls:'icon_pagos_companias',
	getComboBoxStore:function(){
		return this.companiasCombo.store
	},
	initComponent : function() {
		var _this = this;
		this.companiasCombo = Ext.create('app.view.companias.ComboBox');
		this.columns = [
				{
					header : 'fecha',
					dataIndex : 'fecha',
					width:200,
					sortType : Ext.data.SortTypes.asDate,
					renderer : Ext.util.Format.dateRenderer('d-m-Y'),
					field : {
						xtype : 'datefield',
						format : 'd-m-Y'
					}

				},
				{
					header : 'Concepto',
					dataIndex : 'concepto',
					flex : 1,
					field : {
						xtype : 'textfield'
					}

				},
				{
					header : 'Compa&nacute;ia',
					dataIndex:'companias.id',
					width:250,
					editor: this.companiasCombo,
//					listeners:{
//	                    afterrender:{
//	                        fn:function(combo){
//	                           combo.getPicker().setWidth(400);
//	                        }
//	                     }
//	                },
					renderer: function(value,p, record){
						var index = this.companiasCombo.store.find('id',value); 
			            if (index != -1){
			                var rs = this.companiasCombo.store.getAt(index).data; 
			                return rs.nombre; 
			            }		           
					}
				}, {
					header : 'Importe',
					dataIndex : 'importe',
					align : 'right',
					type : 'number',
					renderer : Ext.util.Format.usMoney,
					field : {
						xtype : 'textfield'
					}

				} ];
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
            	text: 'Actualizar',
	    	    iconCls:'x-tbar-loading',
	    	    scope: this,
	    	    handler: function(){
	    			this.store.load();	
	    		}
	        	
	        },{
	        	xtype:'textfield'
//	            ,name     : 'buscarPoliza'
	            ,itemId     : 'buscarPagoCompania'
	            ,submitValue:false
	            ,width: 300
	            ,emptyText: 'Buscar por N. Liquidacion o Compania'
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
		

		this.callParent(arguments);
	}
});
