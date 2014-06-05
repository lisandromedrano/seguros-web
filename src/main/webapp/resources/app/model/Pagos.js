Ext.define('app.model.Pagos', {
    extend: 'Ext.data.Model',
    fields: [
		{name:'id'}, 
		{name:'idPoliza'}, 
		{name:'idCompania'}, 
		{name:'fecha'}, 
		{name:'importe'}, 
		{name:'tipoPago'}, 
		{name:'concepto'}, 
		{name:'nroRecibo'}, 
		{name:'fechaVencimiento'}
    ],
	idProperty: 'id'
});

