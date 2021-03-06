Ext.define("app.view.pagoscompanias.Edit", {
	extend: 'app.view.BaseForm',
    alias:'widget.pagoscompaniasEdit',
	url:CONTEXT_ROOT+'/pagoscompanias/',
	layout: 'fit',
	requires:[
			 'app.view.companias.ComboBox'
    ],
	autoShow: true,
	fieldDefaults: {
	    msgTarget: 'side',
	    //labelWidth: 150,
	    //width:400,
	    //anchor: '50%',
	    style:'padding:10px;margin:10px'
	}, 
	layout: {
		type: 'column'
			// The total column count must be specified here
	    ,columns: 2
	}, 
	initComponent: function(params) {
		this.items=[
			
			 {
				xtype:'datefield',
				fieldLabel: 'fecha',
				name:'fecha'
					,renderer: Ext.util.Format.dateRenderer('d-m-Y')
				,field: { xtype: 'datefield',format: 'd-m-Y' }
			 },
				
			 {
				xtype:'textfield',
				fieldLabel: 'importe',
				name:'importe'
//				,renderer : 'usMoney'
			 },
				
//			 {
//				xtype:'textfield',
//				fieldLabel: 'tipoPago',
//				name:'tipoPago'
//			 },
				
			 {
				xtype:'textfield',
				fieldLabel: 'concepto',
				name:'concepto'
			 },
				
//			 {
//				xtype:'textfield',
//				fieldLabel: 'nroRecibo',
//				name:'nroRecibo'
//			 },
//				
//			 {
//				xtype:'datefield',
//				fieldLabel: 'fechaVencimiento',
//				name:'fechaVencimiento'
//			 },
				// combo candidate for companias
			{
				xtype:'companiasCombo',
				fieldLabel: 'Compania',
				name:'companias.id'
			 }
		];		
		this.callParent(arguments);
	}
	
});