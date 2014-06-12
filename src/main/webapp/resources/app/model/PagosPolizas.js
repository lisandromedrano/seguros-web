Ext.define('app.model.PagosPolizas', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id'
	}, {
		name : 'fecha',
		type : 'date',
		dateFormat : 'd-m-Y'
	}, {
		name : 'importe'
	}, {
		name : 'polizas'
	}, {
		name : 'polizas.id'
	}, {
		name : 'tipoPago'
	}, {
		name : 'concepto'
	}, {
		name : 'nroRecibo'
	}, {
		name : 'fechaVencimiento',
			type : 'date',
			dateFormat : 'd-m-Y'
	} ],
	idProperty : 'id'//,
//	 proxy: {
//        type: 'ajax',
////        type: 'rest',
//        restful:true,
////        format: 'json',
////        headers: {
////            'Content-Type': 'application/json'
////        },
//        url : CONTEXT_ROOT+'/pagospolizas/',
//        reader: {
//            type: 'json',
//            root: 'data',
//            successProperty: 'success'
//        },
//        writer: {
//            type: 'json'
////            writeAllFields: true,
////            encode: true
////            root: 'data'
//        },
//    }
});
