Ext.define('app.store.Clientes', {
    extend: 'Ext.data.Store',
    model: 'app.model.Clientes',
	autoLoad: true,	
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/clientes/',
	    reader: {
	        type: 'json',
	        successProperty: 'success'
	    }
	}    
});

