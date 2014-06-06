Ext.define('app.model.PagosPolizas', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id'
	}, {
		name : 'fecha',
		type : 'date',
		dateFormat : 'd-m-Y'
	}, {
		name : 'importe'
	}, {
		name : 'tipoPago'
	}, {
		name : 'concepto'
	}, {
		name : 'nroRecibo'
	}, {
		name : 'fechaVencimiento',
			type : 'date',
			dateFormat : 'd-m-Y'
	} ],
	idProperty : 'id'
});
