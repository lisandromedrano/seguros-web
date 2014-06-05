Ext.define("app.view.pagospolizas.Edit", {
	extend : 'app.view.BaseForm',
	alias : 'widget.pagospolizasEdit',
	url : CONTEXT_ROOT + '/pagospolizas/',
	layout : 'fit',
	requires : [ 'app.view.polizas.ComboBox', 'app.view.companias.ComboBox' ],
	autoShow : true,
	fieldDefaults : {
		msgTarget : 'side',
		// labelWidth: 150,
		// width:400,
		// anchor: '50%',
		style : 'padding:10px;margin:10px'
	},
	layout : {
		type : 'column'
		// The total column count must be specified here
		,
		columns : 2
	},
	initComponent : function(params) {
		this.items = [

		{
			xtype : 'datefield',
			fieldLabel : 'fecha',
			name : 'fecha'
		},

		{
			xtype : 'textfield',
			fieldLabel : 'importe',
			name : 'importe'
		},

		// {
		// xtype:'textfield',
		// fieldLabel: 'tipoPago',
		// name:'tipoPago'
		// },

		{
			xtype : 'textfield',
			fieldLabel : 'concepto',
			name : 'concepto'
		},

		{
			xtype : 'textfield',
			fieldLabel : 'nroRecibo',
			name : 'nroRecibo'
		},

		{
			xtype : 'datefield',
			fieldLabel : 'fechaVencimiento',
			name : 'fechaVencimiento'
		}

		// combo candidate for polizas
		// {
		// xtype:'polizasCombo',
		// fieldLabel: 'polizas',
		// name:'polizas.id'
		// },
		// combo candidate for companias
		// {
		// xtype:'companiasCombo',
		// fieldLabel: 'companias',
		// name:'companias.id'
		// }
		];

		this.callParent(arguments);
	}

});