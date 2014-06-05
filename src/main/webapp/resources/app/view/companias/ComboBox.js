Ext.define("app.view.companias.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.companiasCombo',
//    store: 'Companias',
	displayField: 'nombre',
	valueField: 'id',
	typeAhead: false,
	name: 'companias',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Seleccione Compania',
	//valueField:'companias.id',
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
	   loadingText: 'Buscando...',
	   emptyText: 'No se encontraron compañias',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '<b>{nombre}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		this.store=Ext.create('Ext.data.Store', {
	        model : 'app.model.Companias',
	        proxy: {
			     type: 'ajax',
			     url:  CONTEXT_ROOT+'/'+'companias/query',
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