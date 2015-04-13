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
       ,'polizas.PolizasPorVencerList'
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
        ,'PolizasByCliente'
        ,'PolizasPorVencer'
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
