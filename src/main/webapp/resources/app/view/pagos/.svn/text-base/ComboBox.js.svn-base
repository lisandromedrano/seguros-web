Ext.define("app.view.pagos.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.pagosCombo',
    store: 'Pagos',
	displayField: 'name',
	valueField: 'id',
	typeAhead: false,
	name: 'pagos',
	itemId : 'pagos',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Select Pagos',
	//valueField:'pagos.id',
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
	   emptyText: 'No matching Pagos found.',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '<b>{name}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		//this.store=Ext.create('Ext.data.Store', {
	    //    model : 'app.model.Pagos',
		//	proxy: {
		//	     type: 'ajax',
		//	     url:  CONTEXT_ROOT+'/'+'pagos/query',
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