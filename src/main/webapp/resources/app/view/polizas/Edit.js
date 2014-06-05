Ext.define("app.view.polizas.Edit", {
	extend : 'app.view.BaseForm',
	alias : 'widget.polizasEdit',
	url : CONTEXT_ROOT + '/polizas/',
	layout : 'fit',
	requires : [ 'app.view.secciones.ComboBox', 'app.view.companias.ComboBox'// ,
	// 'app.view.pagospolizas.ComboBox',
	// 'app.view.clientes.ComboBox'
	],
	autoShow : true,
	initComponent : function(params) {
		var _this = this;
		this.items = [ {
			xtype : 'tabpanel',
			items : [

			{
				title : 'Datos Generales',
				border : false,
				autoScroll : true,
				defaults : {
					msgTarget : 'side',
					// labelWidth: 150,
					width : 400,
					// anchor: '50%',
					style : 'padding:10px;margin:10px;vertical-align:top'
				},
				layout : {
					type : 'table'
					// The total column count must be specified here
					,
					columns : 3
				},
				items : [{
					xtype : 'hidden',
					name : 'id'
				}, {
					xtype : 'textfield',
					fieldLabel : 'Num. Poliza',
					name : 'nroPoliza'
				},

				{
					xtype : 'textfield',
					fieldLabel : 'Endoso',
					name : 'endoso'
				},

				{
					xtype : 'textfield',
					fieldLabel : 'Observaciones',
					columns : 3,
					name : 'observaciones'
				}, {
					xtype : 'textfield',
					fieldLabel : 'Bien A Cubrir',
					name : 'bienACubrir'
				},

				{
					xtype : 'numberfield',
					fieldLabel : 'Cuotas',
					name : 'cantCuotas'
				},

				{
					xtype : 'numberfield',
					fieldLabel : 'Prima',
					name : 'prima'
				},

				{
					xtype : 'numberfield',
					fieldLabel : 'Suma',
					name : 'suma'
				},

				{
					xtype : 'numberfield',
					fieldLabel : 'Premio',
					name : 'premio'
				},

				{
					xtype : 'textfield',
					fieldLabel : 'Moneda',
					name : 'moneda'
				}, 

				{
					xtype : 'textfield',
					fieldLabel : 'Riesgo A Cubrir',
					name : 'riesgoACubrir'
				},

				{
					xtype : 'textfield',
					fieldLabel : 'Tipo Cobertura',
					name : 'tipoCobertura'
				},

				{
					xtype : 'datefield',
					fieldLabel : 'Fecha Registracion',
					name : 'fRegistracion'
				},

				{
					xtype : 'numberfield',
					fieldLabel : 'Orden',
					name : 'orden'
				},

				// combo candidate for companias
				{
					xtype : 'companiasCombo',
					fieldLabel : 'Compania',
					name : 'companias.id'
				},
				// combo candidate for secciones
				{
					xtype : 'seccionesCombo',
					fieldLabel : 'Tipo Poliza',
					name : 'secciones.id'
				} ,
				{
					xtype : 'fieldset',
					title : 'Vigencia',
					
					rowspan : 3,					
					items : [ {
						xtype : 'datefield',
						fieldLabel : 'Desde',
						name : 'fVigDesde'
					}, {
						xtype : 'datefield',
						fieldLabel : 'Hasta',
						name : 'fVigHasta'
					},

					]
				}, {
					xtype : 'fieldset',
					title : 'Datos del Vehiculo',
					rowspan : 2,
					items : [ {
						xtype : 'textfield',
						fieldLabel : 'Nro. Chasis',
						name : 'nroChasis'
					}, {
						xtype : 'textfield',
						fieldLabel : 'Patente',
						name : 'patente'
					}, {
						xtype : 'textfield',
						fieldLabel : 'Nro. Motor',
						name : 'nroMotor'
					} ]
				}]
			}, {
				xtype : 'pagospolizasList'
					,title: 'Pagos'
			} // ,
			]
		}

		];
		this.callParent(arguments);
	}

});