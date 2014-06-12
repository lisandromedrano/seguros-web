Ext.define("app.view.polizas.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.polizasCombo',
    store: 'Polizas',
	displayField: 'nroPoliza',
	valueField: 'id',
	typeAhead: false,
	name: 'polizas',
	itemId : 'polizas',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Seleccione Poliza',
	//valueField:'polizas.id',ione
	minChars:3,
	forceSelection:true,
	mode:'remote',
	listeners:{
	   select:{
		   fn:function(combo,records,eOpts){
//			   var jobGroupChain=combo.up('form').getForm().findField('jobGroupChain');
//			   jobGroupChain.setValue(records[0].data.jobGroup);
		   }
	   }
	
	},			       
	listConfig: {
	   loadingText: 'Searching...',
	   emptyText: 'No se encontraron Polizas.',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '{nroPoliza}  - {companias.nombre}<br>'+
		   '<b>{bienACubrir}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		this.store=Ext.create('Ext.data.Store', {
	        model : 'app.model.Polizas',
			proxy: {
			     type: 'ajax',
			     url:  CONTEXT_ROOT+'/'+'polizas/query',
				reader: {
			        type: 'json',
			        root: 'data',
			        successProperty:'success',
			        totalProperty: 'results'
			    }
			}
	    });
		this.store.load({params:{name:''}})
		this.callParent(arguments);
	}
	
});