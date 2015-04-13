/**
 * Listado de polizas por vencer
 */
Ext.define('app.view.polizas.PolizasPorVencerList', {
	extend : 'app.view.polizas.List',
	alias : 'widget.polizasPorVencerList',
	requires : [ 'app.view.companias.ComboBox', 'app.view.secciones.ComboBox',
			'app.view.pagospolizas.ComboBox', 'app.view.clientes.ComboBox' ],
	title : 'Polizas Por Vencer',
	store : 'Polizas',
	iconCls : 'icon_polizas',
	initComponent : function() {
		this.store = Ext.create('Ext.data.Store', {
			model : 'app.model.Polizas',
			proxy : {
				type : 'ajax',
				url : CONTEXT_ROOT + '/' + 'polizas/porVencer',
				reader : {
					type : 'json',
					root : 'data',
					successProperty : 'success',
					totalProperty : 'totalCount'
				},
				autoLoad : false
			},
			remoteSort : true,
			sorters : {
				property : 'fVigHasta',
				direction : 'DESC'
			}

		});
		this.dockedItems = [ {
			xtype : 'toolbar',
			items : [ {
				text : 'Actualizar',
				itemId : 'reload',
				iconCls : 'x-tbar-loading',
				scope : this
//				handler : function() {
//					this.store.load();
//				}

			}, {
				xtype : 'datefield',
				fieldLabel : 'Desde',
				name : 'fechaDesde',
				itemId : 'fechaDesde',
				renderer : Ext.util.Format.dateRenderer('d-m-Y'),
				field : {
					xtype : 'datefield',
					format : 'd-m-Y'
				},
				value : Ext.Date.getFirstDateOfMonth(new Date())
			}, {
				xtype : 'datefield',
				fieldLabel : 'Hasta',
				name : 'fechaHasta',
				itemId : 'fechaHasta',
				renderer : Ext.util.Format.dateRenderer('d-m-Y'),
				field : {
					xtype : 'datefield',
					format : 'd-m-Y'
				},
				value : Ext.Date.getLastDateOfMonth(new Date())
			}, {
				text : 'Generar Excel',
				itemId : 'reportePolizasPorVencer',
				iconCls : 'icon_plan_pago'
//				disabled : true

			} ]
		} ]
		this.callParent(arguments);
	}
});