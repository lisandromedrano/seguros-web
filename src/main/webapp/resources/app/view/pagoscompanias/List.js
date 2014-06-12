Ext.define('app.view.pagoscompanias.List',{
	extend : 'app.view.BaseGrid',
	alias : 'widget.pagoscompaniasList',
	requires : [ 'app.view.companias.ComboBox' ],
	title : 'Pagos a Companias',
	store : 'PagosCompanias',
	initComponent : function() {
		var _this = this;
		this.companiasCombo = Ext.create('app.view.companias.ComboBox');
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

		this.callParent(arguments);
	}
});
