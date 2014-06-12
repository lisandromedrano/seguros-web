Ext.define('app.store.Polizas', {
    extend: 'Ext.data.Store',
    model: 'app.model.Polizas',
	autoLoad: true,	
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/polizas/',
	    reader: {
	    	 type: 'json',
		        root: 'data',
	            successProperty: 'success',
	            totalProperty: 'totalCount'
	    }
	}    
});

