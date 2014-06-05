Ext.define('app.store.Pagos', {
    extend: 'Ext.data.Store',
    model: 'app.model.Pagos',
	autoLoad: true,	
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/pagos/',
	    reader: {
	        type: 'json',
	        successProperty: 'success'
	    }
	}    
});

