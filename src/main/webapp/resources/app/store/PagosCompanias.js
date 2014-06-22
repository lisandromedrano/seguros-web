Ext.define('app.store.PagosCompanias', {
    extend: 'Ext.data.Store',
    model: 'app.model.PagosCompanias',
//	autoLoad: true,
	filterOnLoad: false,
	remoteSort: true,
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/pagoscompanias/',
	    reader: {
	        type: 'json',
	        root: 'data',
            successProperty: 'success',
            totalProperty: 'totalCount'
	    }
	}  
	,sorters: {
		property: 'fecha',
		direction: 'DESC'
	}
});

