Ext.define('app.model.Clientes', {
    extend: 'Ext.data.Model',
    fields: [
		{name:'id'}, 
		{name:'nombre'}, 
		{name:'apellido'}, 
		{name:'direccion'}, 
		{name:'telefono'}, 
		{name:'email'}, 
		{name:'observaciones'}, 
		{name:'fNacimiento',type:'date', dateFormat: 'd-m-Y'}, 
		{name:'dnicuit'}
    ],
    proxy:{
		type:'rest'
		,url: CONTEXT_ROOT+'/clientes'
	},
	idProperty: 'id'
});

