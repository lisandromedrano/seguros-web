Ext.onReady(function(){
    Ext.QuickTips.init();
    var fnLogin=function(){
    	var form=login.getForm();
    	if (form.isValid()) {
    		form.submit({ 
    			method:'POST', 
    			waitTitle: 'Ingresando..', 
    			waitMsg:'Enviando Informacion...',
    			success: function(form, action) {
	            	if(action.result.productores.length>1){
						seleccionarProductor(action.result.productores);
					}else{
						var redirect = 'index.jsp'; 
						window.location = redirect;
					}
	         	},
	         	failure: function(form, action) {
	         		Ext.Msg.alert('Datos Invalidos', 'Introduzca de nuevo sus datos')
	         	}
    		}); 
	    }else{
	    	Ext.Msg.alert('Datos Invalidos', 'Introduzca de nuevo sus datos')	
	    }
	    
    }
    
	// Create a variable to hold our EXT Form Panel. 
	// Assign various config options as seen.	 
    var login = new Ext.FormPanel({ 
        labelWidth:80,
        url:CONTEXT_ROOT+'/j_spring_security_check',
        defaultType:'textfield',
        monitorValid:true,
        renderTo:'login',
//        autoHeight:true,
        width:417,
        height:350,
        title:'Gestion de Asegurados - Ingreso',
        style:'border-radius: 5;',
        border:false,
        bodyStyle:{
        	padding:'10px'
//        	,background:'#EBEBEB'
//        		,background:'#676766'
        		,opacity: '0.9'
        },
        defaults:{            
        	style:'margin-top:30px;text-align:center',
        	width:'100%'
        	
        },
        items:[{
	    	region: 'north',
			//    height:80,
			    xtype:'image',
			    cls: 'seguros-login-logo',
			    src:'css/images/meloyasoc.jpg',
			    border: false,
			    margins: '0 0 5 10'
			    	
			},{ 
                fieldLabel:'Username',
                hideLabel:true,
                id:'username', 
                name:'j_username', 
                emptyText: 'USUARIO',
                allowBlank:false 
            },{ 
                fieldLabel:'Password',
                hideLabel:true,
                emptyText: 'CONTRASEÑA',
//                name:'password', 
                name:'j_password', 
                inputType:'password', 
                allowBlank:false 
            },{ 
            	xtype:'button',
//            	layout : {
//					type : 'vbox',
//					align : 'center'
////					tdAttrs : {
////						style : 'padding: 5px 10px;cellspacing:5px;'
////					}
//				},
				style:'margin-left: 70;margin-top:25px;',
                text: 'Entrar',
                formBind: true,	 
                width:250,
                // Function that fires when user clicks the button 
                handler:function(){
                	fnLogin();                    
                } 
            }],
		listeners: {
	        afterRender: function(thisForm, options){
	            this.keyNav = Ext.create('Ext.util.KeyNav', this.el, {
	                enter: fnLogin,
	                scope: this
	            });
	        }
		},
// 
//        buttons:[{ 
//                text:'Login',
//                formBind: true,	 
//                // Function that fires when user clicks the button 
//                handler:function(){
//                	fnLogin();                    
//                } 
//            }] 
    });
       
    var seleccionarProductor=function(productores){
    	//crear mensaje con combo para elegir
    	var productoresStore=Ext.create('Ext.data.Store', {
    	    fields: ['id', 'nombre'],
    	    data : productores
    	});
    	var win=Ext.create('Ext.window.Window', {
		    title: 'Seleccione Productor',
		    bodyStyle:'padding:20px',
		    labelAlign:'top',
		    buttons: [
		    {text:'Continuar',handler:function(){
		    		var idProductor=win.query('combo')[0].getValue();
		    		Ext.Ajax.request({
		    			url:CONTEXT_ROOT+'/productores/select',
		    			method:'POST',
		    			params:{idProductor:idProductor},
		    			success:function(response){
			    			var redirect = 'index.jsp'; 
			    			window.location = redirect;
		    			}
		    		});
		    }},{
		    	text:'cancelar'
		    	,handler:function(){
		    		win.destroy();					    		
		    	}
		    }],
		    
		    items:   
		    	Ext.create('Ext.form.ComboBox', {
		    	    fieldLabel: 'Seleccione Productor',
		    	    store: productoresStore,
		    	    displayField: 'nombre',
		    	    valueField: 'id'
		    	})
		       
		    
		});
		win.show();
    	// segunda llamada ajax
    };
});