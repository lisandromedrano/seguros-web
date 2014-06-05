Ext.define('app.view.pagospolizas.List', {
	extend : 'app.view.BaseGrid',
	alias : 'widget.pagospolizasList',
	requires : [ 'app.view.polizas.ComboBox', 'app.view.companias.ComboBox' ],
	title : 'PagosPolizas',
	// store : 'PagosPolizas',
	initComponent : function() {
		this.store = Ext.create('app.store.PagosPolizas');
		this.columns = [ {
			header : 'fecha',
			dataIndex : 'fecha',
			flex : 1,
			renderer : Ext.util.Format.dateRenderer('d-m-Y'),
			align : 'right',
			field : {
				xtype : 'datefield',
				format : 'd-m-Y'
			}

		}, {
			header : 'importe',
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
			header : 'concepto',
			dataIndex : 'concepto',
			flex : 1,
			field : {
				xtype : 'textfield'
			}

		}, {
			header : 'nroRecibo',
			dataIndex : 'nroRecibo',
			flex : 1,
			field : {
				type : 'number'
			},
			align : 'right'

		}, {
			header : 'fechaVencimiento',
			dataIndex : 'fechaVencimiento',
			flex : 1,
			field : {
				xtype : 'datefield'
			}

		}

		];

		this.callParent(arguments);
	}
});
