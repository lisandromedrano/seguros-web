describe ("ExtJS App Test Suite", function () {
	var mainPanel = null;
	var questionStore = null;
	var questionStore = null;
	var storeLength = -1;
	var controller = null;
  /* Setup method to be called before each Test case.*/
  beforeEach (function () {
        // Initializing the mainPanel.
       mainPanel = Ext.create ('app.view.Main');       
       controller = Ext.create ('app.controller.Main');
//       storeLength = questionStore.data.items.length;
  }); // before each

  /* Test if View is created Successfully.*/
  it ('Main View is loaded', function () {
        expect (mainPanel != null).toBeTruthy ();
  });

});