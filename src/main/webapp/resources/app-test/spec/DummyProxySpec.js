/**
 * 
 */
describe ("PagosCompanias Test", function () {
	var myStore = Ext.create('Ext.data.Store', {
	    model: 'app.model.Dummy',
	    proxy: {
	    	actionMethods:{create: 'POST', read: 'GET', update: 'POST', destroy: 'DELETE'},
		    url : CONTEXT_ROOT+'/dummy/',
//	        api: {
//	            create: '/some/url/to/insert/records/in/db',
//	            read: '/some/url/to/select/records/from/db',
//	            update: '/some/url/to/update/records/in/db',
//	            destroy: '/some/url/to/delete/records/in/db'
//	        }
	    }
	}

	// this calls the api.read URL
	myStore.load(); 

	// assuming we now have records, this will delete the first record 
	// on the client side (it will error if there are not records)
	myStore.remove(myStore.first());

	// the store knows we deleted a record so this will call the api.destroy URL
	myStore.sync();

	// this updates the first record on the client side
	myStore.first().set('some_field_name', 'a string value');

	// now we are creating a record on the client side
	myStore.add(Ext.create('MyApp.model.SomeModel'));

	// the store knows we updated AND created a record so this will call the
	// api.update URL AND the api.create URL
	myStore.sync();
	
}