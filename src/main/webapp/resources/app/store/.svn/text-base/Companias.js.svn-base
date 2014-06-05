Ext.define('app.store.Companias', {
    extend: 'Ext.data.Store',
    model: 'app.model.Companias',
	autoLoad: true,	
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/companias/',
	    reader: {
	        type: 'json',
	        successProperty: 'success'
	    }
	}    
});

