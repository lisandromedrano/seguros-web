Ext.define('app.model.Dummy', {
    extend: 'Ext.data.Model',
    fields: [
		{name:'id'}, 
		{name:'nombre'}, 
		{name:'codigo'}
    ],
	idProperty: 'id',
//    proxy : {
//	    type: 'rest',
//	    actionMethods:{create: 'POST', read: 'GET', update: 'POST', destroy: 'DELETE'},
//	    url : CONTEXT_ROOT+'/dummy/',
//	    reader:{
//	        type: 'json',
//	        root: 'data'
//	    },
//	    writer: {
//			type:'json',
////			encode: true,
////			root:'data',
//			writeAllFields: true
//		}
//    }
	
//	proxy : {
//		api: {
////		create : CONTEXT_ROOT+'/dummy/',
////		read : 'contact/view.action',
//		update: CONTEXT_ROOT+'/dummy/',
////		destroy: 'contact/delete.action'
//		},
//		reader:{
//			type:'json',
//			totalProperty: 'total',
//			successProperty: 'success',
//			idProperty: 'id',
//			root: 'data'
//	//		messageProperty: 'message'
//		},
//		writer: {
//			type:'json',
//			encode: true,
//			writeAllFields: true
//		}
//	}
});

