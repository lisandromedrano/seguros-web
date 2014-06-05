describe ("PagosCompanias Test", function () {
	var list = null;
	var edit = null;
	var combo = null;
	var store = null;
	var storeLength = -1;
	var controller = null;
  /* Setup method to be called before each Test case.*/
  beforeEach (function () {
	  controller = Ext.create ('app.controller.PagosCompanias');
	  list = Ext.create ('app.view.pagoscompanias.List');       
	  edit = Ext.create ('app.view.pagoscompanias.Edit');       
	  combo = Ext.create ('app.view.pagoscompanias.ComboBox');
	   store = controller.getStore('PagosCompanias');
       storeLength = store.data.items.length;
  }); // before each

  /* Test if List View is created Successfully.*/
  it ('List View is loaded', function () {
        expect (list != null).toBeTruthy();
  });
  /* Test if Edit View is created Successfully.*/
  it ('Edit View is loaded', function () {
	  expect (edit != null).toBeTruthy ();
  });
  /* Test if Combo View is created Successfully.*/
  it ('Edit Combo is loaded', function () {
	  expect (combo != null).toBeTruthy ();
  });
  /* Test controller is initialized successfully.*/ 
  it ('Controller shouldnt be null', function () {
        expect (controller != null).toBeTruthy();
   });
  /* Test if store is loaded successfully.*/ 
  it ('Store shouldnt be null', function () {
        expect (store != null).toBeTruthy();
   });
  /* Test if Grid in MainPanel is loaded successfully.*/   
  it ('Store has items', function () {
  
       expect (store.data.items.length).toBe (storeLength);
  });
  /* Test if Controller getters return list.*/   
  it ('Controller returns List panel', function () {
	  expect (controller.getGrid()!=null).toBeTruthy();
  });
  /* Test if Controller getters return Edit Panel.*/   
  it ('Controller returns Edit panel', function () {
	  expect (controller.getForm()!=null).toBeTruthy();
  });

	/* Test if new item is added to store.*/   
	it ('New item should be added to store', function () {
		var record = Ext.create ("app.model.PagosCompanias");
		record.id = 1;
		record.fecha = new Date();
        store.add (record);
        expect (store.data.items.length).toBe(storeLength + 1);
        store.removeAt (storeLength);
	});
	it('Grid sort by Date ASC',function(){
		var _store=store;
		_store.on('load',function(_theStore, records, successful){
			expect(successful==true).toBeTruthy();
			console.log('load')
			var minDate=null;
			_store.each(function(rec){
				if(minDate!=null){
					expect(minDate).toBeLessThan(rec.data.fecha);
				}
				minDate=rec.data.fecha;
			});
		});
		_store.sort({direction:'asc',property:'fecha'});
		_store.load();
	});
	it('Grid sort by Date DESC',function(){
		var _store=store;
		_store.on('load',function(_theStore, records, successful){
			expect(successful==true).toBeTruthy();
			console.log('load')
			var minDate=null;
			_store.each(function(rec){
				if(minDate!=null){
					expect(minDate).toBeGreaterThan(rec.data.fecha);
				}
				minDate=rec.data.fecha;
			});
		});
		_store.sort({direction:'desc',property:'fecha'});
		_store.load();
	});

});