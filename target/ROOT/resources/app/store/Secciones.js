Ext.define('app.store.Secciones', {
    extend: 'Ext.data.Store',
    model: 'app.model.Secciones',
	autoLoad: true,	
	proxy: {
	    type: 'ajax',
	    url: CONTEXT_ROOT+'/secciones/',
	    reader: {
	        type: 'json',
	        successProperty: 'success'
	    }
	}    
});

