Ext.define('app.model.PagosCompanias', {
    extend: 'Ext.data.Model',
    fields: [
		{name:'id'}, 
		{name:'companias'},
		{name:'companias.id'},
		{name:'fecha'}, 
		{name:'importe'},  
		{name:'concepto'} 

    ],
	idProperty: 'id'
});

