Ext.define('app.store.Clientes', {
    extend: 'Ext.data.Store',
    model: 'app.model.Clientes',
	autoLoad: true,	
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/clientes/',
	    reader: {
	        type: 'json',
	        root: 'data',
            successProperty: 'success',
            totalProperty: 'totalCount'
	    }
	}
	,sorters: {
		property: 'apellido',
		direction: 'ASC'
	}
});

