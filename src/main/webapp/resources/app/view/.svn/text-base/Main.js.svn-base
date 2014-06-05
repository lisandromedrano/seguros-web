Ext.define('app.view.Main', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.*',
        'Ext.layout.container.Border'
    ],
    
    xtype: 'app-main',

    layout: {
        type: 'border'
    },

    items: [{
        region: 'west',
        xtype: 'panel',
        title: 'Acciones',
		layout: {
			type: 'vbox',
			align: 'stretch',
			tdAttrs: { style: 'padding: 5px 10px;' }
		},
		defaults:{
			textAlign:'left'
		},		
		items:[
			{
				xtype:'button',
				text:'Clientes',
				itemId:'clientes',
				iconCls:'icon_clientes'
			},{
				xtype:'button',
				itemId:'polizas',
				text:'P&oacute;lizas',
				iconCls:'icon_polizas'
			},{
				xtype:'button',
				itemId:'companias',
				text:'Compa&nacute;ias',
				iconCls:'icon_companias'
			},{
				xtype:'button',
				itemId:'pagosCompanias',
				text:'Pagos a Compa&nacute;ias',
				iconCls:'icon_companias'
			},{
				xtype:'button',
				text:'Secciones',
				itemId:'secciones',
				iconCls:'icon_secciones'
			}
		],
        width: 150
    },{
        region: 'center',
        id:'app-center',
        xtype: 'tabpanel'
        ,items:[{
			xtype:'clientesList'
			,editionMode:app.utils.EditionMode.TAB
        }]
    }]
});