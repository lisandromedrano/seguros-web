Ext.define('app.store.PagosPolizas', {
    extend: 'Ext.data.Store',
    model: 'app.model.PagosPolizas',
	autoLoad: false,
	remoteSort: true,
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/pagospolizas/',
	    reader: {
	        type: 'json',
	        successProperty: 'success'
	    }
	}    
});

