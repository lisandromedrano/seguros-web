Ext.define('app.store.PagosPolizas', {
    extend: 'Ext.data.Store',
    model: 'app.model.PagosPolizas',
	autoLoad: false,
	proxy: {
	    type: 'ajax',
//	    type: 'rest',
//	    actionMethods:{create: 'POST', read: 'GET', update: 'POST', destroy: 'DELETE'},
	    url: CONTEXT_ROOT+'/pagospolizas/',
	    reader: {
	        type: 'json',
	        root: 'data',
            successProperty: 'success',
            totalProperty: 'totalCount'
	    }
	},   
	idProperty:'id',
	remoteSort: true,
	sorters: {
		property: 'fecha',
		direction: 'DESC'
	}
});

