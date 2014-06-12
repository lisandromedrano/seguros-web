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
		{name:'dnicuit'},
		{
			name : 'nombreApellido',
			type : 'string',
			convert : function(v, record) {
				return record.data.apellido+ ' '+record.data.nombre 
			}
		}
    ],
    proxy:{
		type:'rest'
		,url: CONTEXT_ROOT+'/clientes'
	},
	idProperty: 'id'
});

