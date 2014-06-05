Ext.define('app.view.pagoscompanias.List',{
	extend : 'app.view.BaseGrid',
	alias : 'widget.pagoscompaniasList',
	requires : [ 'app.view.companias.ComboBox' ],
	title : 'Pagos a Companias',
	store : 'PagosCompanias',
	initComponent : function() {
		var _this = this;
		this.columns = [
				{
					header : 'fecha',
					dataIndex : 'fecha'
					// ,flex: 1
					,
					sortType : Ext.data.SortTypes.asDate,
					field : {
						xtype : 'datefield',
						format : 'd-m-Y'
					}

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

				},
				{
					header : 'companias',
					dataIndex:'companias',
					editor : {
						xtype : 'companiasCombo'
					},
//					field : {
//						xtype : "companiasCombo"
//						typeAhead : true,
//						triggerAction : 'all',
//						valueField : 'companias.id',
//						displayField : 'companias.nombre'
					// typeAhead: true,
					// triggerAction: 'all',
					// store: listtypesStore,
					// displayField: 'listtype',
					// valueField: 'listtype'
					// valueField: 'listtype'
//					},
					renderer : function(value, metaData,
							record, rowIndex, colIndex, store,
							view) {
						return store.data.items[rowIndex].data.companias.nombre;
					}
				}, {
					header : 'importe',
					dataIndex : 'importe',
					align : 'right',
					type : 'number',
					field : {
						xtype : 'textfield'
					}

				} ];

		this.callParent(arguments);
	}
});
