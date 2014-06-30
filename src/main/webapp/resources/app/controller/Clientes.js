Ext.define('app.controller.Clientes', {
//    extend: 'Ext.app.Controller',
    extend: 'app.controller.BaseController',
    views: ['clientes.List','clientes.Edit'],
	stores:  ['Clientes'],
	refs: [{
	    ref: 'clientesList',
	    selector: 'clientesList'
	},{
	    ref: 'grid',
	    selector: 'clientesList'
	},{
	    ref: 'clientesEdit',
	    selector: 'clientesEdit'
	},{
		ref: 'form',
		selector: 'clientesEdit'
	},{
	    ref: 'polizasGrid',
	    selector: 'polizasClienteList'
	},{
		ref: 'addPolizaButton',
		selector: 'polizasClienteList > toolbar > button#add'
	}]
	,entityName:"Cliente"
	,controller:"clientes"
	,model:"app.model.Clientes"
	,editionFormXtype:"clientesEdit"
	,titleField:'nombre'
	,afterFillFormFn:function(panel,form,record){			
		panel.setTitle(record.data.nombre+' '+record.data.apellido);
		panel.query('polizasClienteList')[0].store.proxy.extraParams={'clientes.id':record.data.id};
		panel.query('polizasClienteList')[0].store.load();
		panel.query('polizasClienteList > toolbar > button#add')[0].setDisabled(false);
	}
	,init: function() {
		
		var me = this;
		me.control({
				'clientesList':{
					itemdblclick:me.gridRowDblClick
					,edit:me.gridRowEdit
					,scope:me
				}
				,'clientesList > toolbar > button#add':{
					click:me.gridButtonAdd,
					scope:me
		    	}
				,'clientesList > toolbar > button#delete':{
		    		click:me.gridRowDelete,
		    		scope: me
//		    	}		    	
//				,'clientesEdit>toolbar>button#save':{
//					click:me.buttonSaveClick,
//					scope: me
//	    		,'clientesEdit':{
//					render:function(){
//						//disable add button from Polizas Grid
//						this.getAddPolizaButton().setDisabled(true);
//					}
//				}
				},'clientesList > toolbar > textfield#buscarCliente':{
		    		  specialkey: function(f,e){
		    				
		                  if (e.getKey() == e.ENTER) {
		                	  me.getClientesList().store.currentPage = 1;
		                	  me.getClientesList().store.load({
		                		  params:{findByName:f.value.toUpperCase(),page:0}
		                	  	})

		                  }
		               }
		        
		    	}
		});	
		me.callParent(arguments);
	}
});
