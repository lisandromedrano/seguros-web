Ext.define('app.store.PagosPolizas', {
    extend: 'Ext.data.Store',
    model: 'app.model.PagosPolizas',
	autoLoad: false,
	proxy: {
//	    type: 'ajax',
	    type: 'rest',
	    actionMethods:{create: 'POST', read: 'GET', update: 'POST', destroy: 'DELETE'},
	    url: CONTEXT_ROOT+'/pagospolizas/',
	    reader: {
	        type: 'json',
	        totalProperty:'total',
	        root:'data',
	        successProperty: 'success'
	    }
	},   
	idProperty:'id',
	remoteSort: true,
	sorters: {
		property: 'fecha',
		direction: 'DESC'
	}
});

