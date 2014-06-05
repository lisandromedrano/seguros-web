Ext.define('app.store.PagosCompanias', {
    extend: 'Ext.data.Store',
    model: 'app.model.PagosCompanias',
	autoLoad: true,
	filterOnLoad: false,
	remoteSort: true,
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/pagoscompanias/',
	    reader: {
	        type: 'json',
	        successProperty: 'success'
	    }
	}  
	,sorters: {
		property: 'fecha',
		direction: 'DESC'
	}
});

