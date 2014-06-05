Ext.define("app.view.clientes.ComboBox", {
	extend: 'Ext.form.ComboBox',
	alias:'widget.clientesCombo',
    store: 'Clientes',
	displayField: 'name',
	valueField: 'id',
	typeAhead: false,
	name: 'clientes',
	itemId : 'clientes',
	queryParam: 'name',
	hideTrigger:false,
	emptyText:'Select Clientes',
	//valueField:'clientes.id',
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
	   emptyText: 'No matching Clientes found.',	
	   getInnerTpl: function() {
		   return '<a>' +
		   '<b>{name}</b><br>'+
		   '</a>';
	   }
	},
	initComponent:function(){
		//this.store=Ext.create('Ext.data.Store', {
	    //    model : 'app.model.Clientes',
		//	proxy: {
		//	     type: 'ajax',
		//	     url:  CONTEXT_ROOT+'/'+'clientes/query',
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