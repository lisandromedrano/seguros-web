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
	    ref: 'polizasGrid',
	    selector: 'clientesEdit > polizasList'
	}],
	init: function() {
		
		var me = this;
		me.entityName="Cliente";
		me.controller="clientes";
		me.model="app.model.Clientes";
		me.editionFormXtype="clientesEdit";
		me.titleField='nombre';
		me.afterFillFormFn=function(panel,form,record){			
			panel.setTitle(record.data.nombre+' '+record.data.apellido);
			panel.polizasGrid.store.proxy.extraParams={id:record.data.id};
			panel.polizasGrid.store.load();
		}
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
		    	}		    	
				,'clientesEdit>toolbar>button#save':{
					click:me.buttonSaveClick,
					scope: me
				},'clientesList > toolbar > textfield#buscarCliente':{
		    		  specialkey: function(f,e){
		    				
		                  if (e.getKey() == e.ENTER) {
		                	  me.getClientesList().store.filterBy(function(record){
		                		  var inputValue=f.value.toUpperCase();
		                		  if(inputValue.length<2)return true;
		                		  if(record.data.nombre.toUpperCase().indexOf(inputValue)!=-1)
		                			  return true;
		                		  else if(record.data.apellido.toUpperCase().indexOf(inputValue)!=-1)
		                			  return true;
		                		  return false;
		                	  })
		                  }
		               }
		        
		    	}
		});	
		me.callParent(arguments);
	}
});
