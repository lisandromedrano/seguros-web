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
    
//	
//    proxy: {
//	    type: 'rest',
//	    actionMethods:{create: 'POST', read: 'GET', update: 'PUT', destroy: 'DELETE'},
//	    url: CONTEXT_ROOT+'/clientes',
//	    api:{
//	    	create: CONTEXT_ROOT+'/clientes/'
//	    },
//	    reader: {
//	        type: 'json',
//	        successProperty: 'success'
//	    }
//	},
    validations: [
	      {type: 'email', field: 'email'},
//	      {type: 'presence', field: 'nombre'},
	      {type: 'presence', field: 'apellido'}
	  ],
	idProperty: 'id'
});

