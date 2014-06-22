Ext.define('app.view.pagospolizas.ListByPoliza', {
	extend : 'app.view.BaseGrid',
	alias : 'widget.pagospolizasListByPoliza',
	requires : [ 'app.view.polizas.ComboBox', 'app.view.companias.ComboBox' ],
	title : 'PagosPolizas',
	// store : 'PagosPolizas',
	initComponent : function() {
		this.store = Ext.create('Ext.data.Store', {
			model: 'app.model.PagosPolizas',
			autoLoad: false,
			proxy: {
			    type: 'ajax',
			    url: CONTEXT_ROOT+'/pagospolizas/',
			    reader: {
			        type: 'json',
			        root:'data',
			        totalProperty:'totalCount',
			        successProperty: 'success'
			    }
			},   
			remoteSort: true,
			sorters: {
				property: 'fecha',
				direction: 'DESC'
			}
		});
//		Nº  de cuota-importe y fecha de pago n ese mismo orden
		this.columns = [{
			header : 'Nro. Recibo',
			dataIndex : 'nroRecibo',
			flex : 1,
			field : {
				type : 'number'
			},
			align : 'right'

		},{
			header : 'Importe',
			dataIndex : 'importe',
			flex : 1,
			field : {
				type : 'number'
			},
			align : 'right',
			renderer : Ext.util.Format.usMoney,

		},
		// {
		// header: 'tipoPago'
		// ,dataIndex: 'tipoPago'
		// ,flex: 1
		// ,field: { xtype: 'textfield' }
		//				
		// },
		{
			header : 'Concepto',
			dataIndex : 'concepto',
			flex : 1,
			field : {
				xtype : 'textfield'
			}

		},   {
			header : 'Fecha Pago',
			dataIndex : 'fecha',
			flex : 1,
			renderer : Ext.util.Format.dateRenderer('d-m-Y'),
			align : 'right',
			field : {
				xtype : 'datefield',
				format : 'd-m-Y'
			}

		}, {
			header : 'Fecha Vencimiento',
			dataIndex : 'fechaVencimiento',
			flex : 1,
			renderer : Ext.util.Format.dateRenderer('d-m-Y'),
			field : {
				xtype : 'datefield',
				format : 'd-m-Y'
			}

		}

		];
		
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [
            '->',{
                text: 'Agregar',
                itemId:'add',
                iconCls: 'icon-add',
                disabled: true

            }, {
                text: 'Plan de Pagos',
                itemId:'planPagos',
                iconCls: 'icon_plan_pago',
                disabled: true

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
