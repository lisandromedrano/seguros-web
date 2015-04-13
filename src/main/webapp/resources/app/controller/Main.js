Ext.define('app.controller.Main', {
    extend: 'Ext.app.Controller',
    views:  ['Main'
             //,'secciones.List'
    ],
    init: function() {
    	this.control({
    		'button#clientes':{
    			click:function(){
    				alert('hola');
//	    			click:function(){
//		    			var idTab = 'seccionesList';
//		    			var xtype = 'seccionesList';
//		    			var title = 'Secciones';
//		    			app.utils.openWindow(xtype,title,{
//		    				editionMode:app.utils.EditionMode.ROW
//		    			});
//	    			}
    			}
    	
    		}
    		,'button#secciones':{
    			click:function(){
	    			var idTab = 'seccionesList';
	    			var xtype = 'seccionesList';
	    			var title = 'Secciones';
	    			app.utils.openWindow(xtype,title,{
	    				editionMode:app.utils.EditionMode.ROW
	    			});
    			}
    	
    		}//,
    		,'button#polizas':{
    			click:function(){
	    			var idTab = 'polizasList';
	    			var xtype = 'polizasList';
	    			var title = 'Polizas';
	    			app.utils.openTab(xtype,title,idTab,{
	    				editionMode:app.utils.EditionMode.TAB
	    				}
	    			);
    			}
    	
    		}
    		,'button#companias':{
    			click:function(){	    			
	    			var xtype = 'companiasList';
	    			var title = 'Companias';
	    			app.utils.openWindow(xtype,title,{
	    				editionMode:app.utils.EditionMode.ROW
	    				,width:600
	    			}).setIconCls('icon_companias');
    			}
    	
    		}
    		,'button#pagosPolizas':{
    			click:function(){	    			
    				var xtype = 'pagospolizasList';
    				var idTab = 'pagospolizasList';
    				var title = 'Pagos de Polizas';
    				app.utils.openTab(xtype,title,idTab,{
    					editionMode:app.utils.EditionMode.ROW
    				});
    			}
    		
    		}
    		,'button#pagosCompanias':{
    			click:function(){	    			
    				var xtype = 'pagoscompaniasList';
    				var idTab = 'pagoscompaniasList';
    				var title = 'Pagos Companias';
    				app.utils.openTab(xtype,title,idTab,{
    					//editionMode:app.utils.EditionMode.WINDOW
    				});
    			}
    		
    		}
    		,'button#polizasPorVencer':{
    			click:function(button){
    				var idTab = 'polizasPorVencerList';
	    			var xtype = 'polizasPorVencerList';
	    			var title = 'Polizas X Venc.';
	    			app.utils.openTab(xtype,title,idTab,{
	    				editionMode:app.utils.EditionMode.TAB
	    				}
	    			);
				}
			}	
//    	
    	})
    	
	}

});
