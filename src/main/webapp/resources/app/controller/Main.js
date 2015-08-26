Ext.define('app.controller.Main', {
    extend: 'Ext.app.Controller',
    views:  ['Main'
             //,'secciones.List'
    ],
    init: function() {
    	this.control({
//    		'viewport > panel': {
//                render: funtion(){
//                	alert('render!!')
//                }
//            },
    		'button#clientes':{
    			click:function(){
//    				alert('hola');
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
    		, 'component#panelUsuario':{
    			render:function(panelUsuario){
    				Ext.Ajax.request({
    					url: CONTEXT_ROOT+'/productores/getCurrentProductor',
    					success: function(response){
    						var responseObject= Ext.JSON.decode(response.responseText);
    						console.log(responseObject)
    						panelUsuario.update('<p><b>Usuario: </b>'+usuario+'</p>'
    								+ '<p><b>Productor: </b>'+responseObject.nombre+
//    								' [<a href="" class="cambiarProductor">Cambiar</a>]'+
    								'</p>');
//    						Ext.select('a.cambiarProductor').on('click', function(e)
//    								{
//    								   var target = e.getTarget();
//    								   alert(target.id);
//    								}
//    								);
    					}
    				})
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
//    	
    	})
    	
	}

});
