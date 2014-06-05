Ext.define("app.view.pagoscompanias.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.pagoscompaniasCombo',
    store: 'PagosCompanias',
	displayField: 'name',
	valueField: 'id',
	typeAhead: false,
	name: 'pagoscompanias',
	itemId : 'pagoscompanias',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Select PagosCompanias',
	//valueField:'pagoscompanias.id',
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
	   emptyText: 'No matching PagosCompanias found.',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '<b>{name}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		//this.store=Ext.create('Ext.data.Store', {
	    //    model : 'app.model.PagosCompanias',
		//	proxy: {
		//	     type: 'ajax',
		//	     url:  CONTEXT_ROOT+'/'+'pagoscompanias/query',
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