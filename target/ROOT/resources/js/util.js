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
    	,openClienteTab:function(record){
			var idTab = 'cliente-'+record.data.id;
			var xtype = 'clienteEdit';
			var title = record.data.apellido;
    		var tab=this.openTab(xtype,idTab,title);
    		tab.getForm().loadRecord(record);    		    		
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
    		    height: 200,
    		    width: 400,
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
    	
    	
	}
});

		
