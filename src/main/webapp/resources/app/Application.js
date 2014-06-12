Ext.define('app.Application', {
    name: 'app',

    extend: 'Ext.app.Application',

    views: [
       'secciones.List'
       ,'secciones.Edit'
       ,'companias.List'
       ,'clientes.List'
       ,'clientes.Edit'
       ,'polizas.List'
       ,'polizas.Edit'
       ,'polizas.PolizasClienteList'
       ,'pagoscompanias.Edit'
       ,'pagoscompanias.List'
       ,'pagospolizas.Edit'
       ,'pagospolizas.List'

//       ,'BaseForm'
//       'polizas.Edit',
//       'companias.Edit'
//       'companias.ComboBox',
    ],

    controllers: [
        'Main'//,
        ,'Secciones'
        ,'Companias'
        ,'Clientes'
        ,'Polizas'
        ,'BaseController'
        ,'PagosCompanias'
        ,'PagosPolizas'
        ,'PagosPolizasByPoliza'
    ],
    stores: [
       'Secciones'
       ,'Companias'
       ,'Clientes'
       ,'Polizas'
       ,'PagosCompanias'
       ,'PagosPolizas'
    ]
});
