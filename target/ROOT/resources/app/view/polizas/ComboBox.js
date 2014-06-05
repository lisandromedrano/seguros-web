Ext.define("app.view.polizas.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.polizasCombo',
    store: 'Polizas',
	displayField: 'name',
	valueField: 'id',
	typeAhead: false,
	name: 'polizas',
	itemId : 'polizas',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Select Polizas',
	//valueField:'polizas.id',
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
	   emptyText: 'No matching Polizas found.',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '<b>{name}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		//this.store=Ext.create('Ext.data.Store', {
	    //    model : 'app.model.Polizas',
		//	proxy: {
		//	     type: 'ajax',
		//	     url:  CONTEXT_ROOT+'/'+'polizas/query',
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