Ext.define('app.view.pagospolizas.List', {
	extend : 'app.view.BaseGrid',
	alias : 'widget.pagospolizasList',
	requires : [ 'app.view.polizas.ComboBox', 'app.view.companias.ComboBox' ],
	title : 'PagosPolizas',
	iconCls:'icon_pagos_polizas',
	// store : 'PagosPolizas',
	initComponent : function() {
		this.polizasCombo = Ext.create('app.view.polizas.ComboBox');
		this.store = Ext.create('app.store.PagosPolizas');
		this.columns = [ {
			header : 'Fecha Pago',
			dataIndex : 'fecha',
			flex : 1,
			renderer : Ext.util.Format.dateRenderer('d-m-Y'),
			align : 'right',
			field : {
				xtype : 'datefield',
				format : 'd-m-Y'
			}

		},
		{
			header : 'Poliza',
			dataIndex:'polizas.id',
			align:'right',
			editor: this.polizasCombo,
			flex : 1,
			renderer: function(value,p, record){
//				return record.data.nroPoliza;
				var index = this.polizasCombo.store.find('id',value); 
	            if (index != -1){
	                var rs = this.polizasCombo.store.getAt(index).data; 
	                return rs.nroPoliza; 
	            }else{
	            	this.polizasCombo.store.add(record.data.polizas)
	            	return record.data.polizas.nroPoliza
	            }		           
			}
		},
		{
			header : 'Bien a Cubrir',
//			align:'left',
			flex : 1,
			renderer: function(value,p, record){
				if(record.data.polizas.bienACubrir)
				return record.data.polizas.bienACubrir
				else return ''
				
			}
		},
		{
			header : 'Concepto',
			dataIndex : 'concepto',
			flex : 1,
			field : {
				xtype : 'textfield'
			}
		}, {
			header : 'Importe',
			dataIndex : 'importe',
			flex : 1,
			field : {
				type : 'number'
			},
			align : 'right',
			renderer : Ext.util.Format.usMoney,
		}, {
			header : 'Nro. Recibo',
			dataIndex : 'nroRecibo',
//			flex : 1,
			field : {
				type : 'number'
			},
			align : 'right'

		}, {
			header : 'Fecha Vencimiento',
			dataIndex : 'fechaVencimiento',
			flex : 1,
			renderer : Ext.util.Format.dateRenderer('d-m-Y'),
			field : {
				xtype : 'datefield'
			}

		}

		];
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
	            ,itemId     : 'buscarPagoPoliza'
	            ,submitValue:false
	            ,width: 300
	            ,emptyText: 'Buscar por N. Poliza, Bien o N. Recibo'
	        },
            '->',{
                text: 'Agregar',
                itemId:'add',
                iconCls: 'icon-add'

            }, 
             {
            	text: 'Ver Poliza',
            	itemId:'verPoliza',
            	iconCls: 'icon_polizas_edit'
            		
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
