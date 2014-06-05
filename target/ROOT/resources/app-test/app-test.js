/*
    This file is generated and updated by Sencha Cmd. You can edit this file as
    needed for your application, but these edits will have to be merged by
    Sencha Cmd when upgrading.
*/

Ext.application({
    name: 'app',

    extend: 'app.Application',
    
    autoCreateViewport: false,
 // using the Launch method of Application object to execute the Jasmine
    //Test Cases
    launch: function () {
    	var jasmineEnv = jasmine.getEnv ();
    	jasmineEnv.updateInterval = 1000;
    	var htmlReporter = new jasmine.HtmlReporter ();
    	jasmineEnv.addReporter (htmlReporter);
    	jasmineEnv.execute ();
    }
});
