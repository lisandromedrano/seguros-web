Ext.define("app.view.pagospolizas.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.pagospolizasCombo',
    store: 'PagosPolizas',
	displayField: 'name',
	valueField: 'id',
	typeAhead: false,
	name: 'pagospolizas',
	itemId : 'pagospolizas',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Select PagosPolizas',
	//valueField:'pagospolizas.id',
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
	   emptyText: 'No matching PagosPolizas found.',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '<b>{name}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		//this.store=Ext.create('Ext.data.Store', {
	    //    model : 'app.model.PagosPolizas',
		//	proxy: {
		//	     type: 'ajax',
		//	     url:  CONTEXT_ROOT+'/'+'pagospolizas/query',
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