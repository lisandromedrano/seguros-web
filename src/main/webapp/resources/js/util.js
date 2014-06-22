Ext.define('app.utils', {
    statics: {
		bubbleMessage:function(title, message){
		    if(!this.msgCt){
		        this.msgCt = Ext.core.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
		    }
		    this.msgCt.alignTo(document, 't-t');
		    var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
		    var m = Ext.core.DomHelper.append(this.msgCt, {html:'<div class="msg"><h3>' + title + '</h3><p>' + s + '</p></div>'}, true);

		    m.slideIn('t').pause(3000).ghost('t', {remove:true});
		}
    	,openClienteTab:function(clienteId){
//			var idTab = 'cliente-'+record.data.id;
//			var xtype = 'clienteEdit';
//			var title = record.data.apellido;
//    		var tab=this.openTab(xtype,idTab,title);
//    		tab.getForm().loadRecord(record);
    		var Cliente = Ext.ModelManager.getModel('app.model.Clientes')
    		Cliente.load(clienteId,{
    			success: function(cliente) {
    		        var clientesController=Ext.create('app.controller.Clientes')
    		        clientesController.gridRowDblClick(null,cliente);	
    		    }
    		})
    		    		
    		//
    		
		}
    	,openTab:function(xtype,title,idTab,config){
    		var panel=Ext.apply({
	        	xtype:xtype
	        	,id: idTab
	        	,title:title
	        	,closable:true
	        },config);
			var tab;
			var tabPanel=Ext.getCmp('app-center')
			var isTabOpened = false;
			for (var index = 0; index < tabPanel.items.length; index++) {
		        var t = tabPanel.items.get(index);
				if (t.id && t.id == idTab) {
					tabPanel.setActiveTab(index);
					isTabOpened = true;
					tab=tabPanel.getActiveTab();
				}
			}
			if(!isTabOpened){
				tab=tabPanel.add(panel);
		//		}
			    //tab.getForm().loadRecord(record);
				tab.show();
			}
			return tab;
    	}
    	,openWindow:function(xtype,title,config){
    		var panel = Ext.apply({
    		        xtype: xtype,
    		        border: false,
    		        title:false,
    		        listeners:{
    		    		close:function(){
//    						alert('closeeee');
//    						alert(win.title);
    						win.destroy();
    		        	}
    		    	}
    			},
    			config
    		);
    		var win=Ext.create('Ext.window.Window', {
    		    title: title,
    		    height: 400,
    		    width: 600,
    		    layout: 'fit',
    		    items: panel
    		}).show();
    		return win;
    	}
    	,events:{
    		SAVE:'SAVE',
    		CANCEL:'CANCEL'
    	}
    	,EditionMode:{
	        ROW:'row'
	        ,WINDOW:'window'
	        ,TAB:'tab'
	    }
    	,deleteNullIds:function(obj){    		
    		for(var key in obj){				
    			if(obj[key]!=null && typeof obj[key]== 'object'){
    				this.deleteNullIds(obj[key]);
    			}else if(key=='id' && obj[key]==null){
    				delete obj[key];
    			}
    		}
    	}
    	,flattenObject : function(ob) {
    		var toReturn = {};
    		
    		for (var i in ob) {
    			if (!ob.hasOwnProperty(i)) continue;
    			
    			if ((typeof ob[i]) == 'object') {
    				var flatObject = this.flattenObject(ob[i]);
    				for (var x in flatObject) {
    					if (!flatObject.hasOwnProperty(x)) continue;
    					
    					toReturn[i + '.' + x] = flatObject[x];
    				}
    			} else {
    				toReturn[i] = ob[i];
    			}
    		}
    		return toReturn;
    	}
    	,deflatObject:function(existingObject,aString){
    		var dotFirstIndex=aString.indexOf('.')
    		if(dotFirstIndex>-1){
    			var firstElement=aString.substr(0,dotFirstIndex)
    			var remaining=aString.substr(dotFirstIndex+1)
    			existingObject[firstElement]={}    		
    			this.deflatObject(existingObject[firstElement],remaining);    			
    		}else{
    			existingObject[aString]='';
    		}
    	}
    	,flattenObjectKeys : function(ob) {
    		var toReturn = new Array();
    		
    		for (var i in ob) {
    			if (!ob.hasOwnProperty(i)) continue;
    			
    			if ((typeof ob[i]) == 'object') {
    				var flatObject = this.flattenObject(ob[i]);
    				for (var x in flatObject) {
    					if (!flatObject.hasOwnProperty(x)) continue;
    					
    					toReturn.push(i + '.' + x)
    				}
    			} else {
    				toReturn.push(i);
    			}
    		}
    		return toReturn;
    	}
    	
	}
});

		
