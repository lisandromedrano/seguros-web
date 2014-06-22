Ext.define("app.view.secciones.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.seccionesCombo',
    store: 'Secciones',
	displayField: 'nombre',
	valueField: 'id',
	typeAhead: false,
	name: 'secciones',
	itemId : 'secciones',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Seleccione Tipo de Poliza',
	//valueField:'secciones.id',
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
	   emptyText: 'No se encontraron Secciones.',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '<b>{nombre}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		//this.store=Ext.create('Ext.data.Store', {
	    //    model : 'app.model.Secciones',
		//	proxy: {
		//	     type: 'ajax',
		//	     url:  CONTEXT_ROOT+'/'+'secciones/query',
		//		reader: {
		//	        type: 'json',
		//	        root: 'data',
		//	        successProperty:'success',
		//	        totalProperty: 'results'
		//	    }
		//	}
	    //});
		this.callParent(arguments);
	}
	
});