Ext.define('app.controller.Cliente', {
    extend: 'Ext.app.Controller',
    views: ['clientes.List'],
	stores:  ['Cliente'],
	refs: [{
	    ref: 'clientesList',
	    selector: 'clientesList'
	}],
	init: function() {
		this.control({
				'toolbar > textfield#nombreApellido':{
					keyup:function(textfield,e){
						var text=textfield.getValue();
						var store=this.getClientesList().getStore();
						
						if(text.length>3){
							store.clearFilter()
							store.filterBy(function(rec, id) {
							    if(rec.get('nombre').toUpperCase().indexOf(text.toUpperCase()) !=-1
							    || rec.get('apellido').toUpperCase().indexOf(text.toUpperCase()) !=-1
							    ) {
							        return true;
							    }
							    else {
							        return false;
							    }
							});
//							this.getClientesList().getStore().nameFilter(text);
//							this.getClientesList().getStore().clearFilter()
//							this.getClientesList().getStore().filter([
//							Ext.create('Ext.util.Filter', {property: "nombre", value: text, root: ''})
////							    {property: "nombre", value: text,anyMatch:true,caseSensitive:false},
////							    {property: "apellido", value: text,anyMatch:true,caseSensitive:false}
//							 ])
						}else{
							store.filterBy(function(rec, id) {
								return true;
							});
							
						}						
//			        	console.log(textfield.getValue());
			        }
				}
				,'#clientesList':{
					itemdblclick: function(thisO, record, item, index, e, eOpts){
//		        			app.utils.bubbleMessage(record.data.nombre,record.data.apellido)
		        			app.utils.openClienteTab(record)
		        		
		        	}	
				}
		
			});
	}
	
});
