/**
 * 
 */
Ext.define('app.controller.PolizasPorVencer', {
	extend : 'app.controller.BaseController',
	views : [ 'polizas.PolizasPorVencerList' ],
	refs : [ {
		ref : 'polizasPorVencerList',
		selector : 'polizasPorVencerList'
	}, {
		ref : 'fechaDesde',
		selector : 'polizasPorVencerList > toolbar > datefield#fechaDesde'
	}, {
		ref : 'fechaHasta',
		selector : 'polizasPorVencerList > toolbar > datefield#fechaHasta'
	} ],
	init : function() {
		this.loadGrid=function(){
			var fechaDesde=this.getFechaDesde().getValue()
			var fechaHasta=this.getFechaHasta().getValue()
			this.getPolizasPorVencerList().store.load({
				params:{
					'fechaDesde' : Ext.Date.format(fechaDesde, 'd-m-Y'),
					'fechaHasta' : Ext.Date.format(fechaHasta, 'd-m-Y')
							
				}})
		}
		var me = this;
		this.control({
			'polizasPorVencerList' : {
				afterrender : function() {
					me.loadGrid()
				},
				scope:me
			},
			'polizasPorVencerList > toolbar > button#reload' : {
				click : function() {
					me.loadGrid()
				},
				scope:me
			},
			'polizasPorVencerList > toolbar > button#reportePolizasPorVencer' : {
				click : function() {
					var fechaDesde=me.getFechaDesde().getValue()
					var fechaHasta=me.getFechaHasta().getValue()
					window.location = CONTEXT_ROOT
							+ '/reportes/polizasPorVencer/?fechaDesde='+fechaDesde+'&fechaHasta='+fechaHasta ;
				},
				scope : me
			}
		})
	}

});