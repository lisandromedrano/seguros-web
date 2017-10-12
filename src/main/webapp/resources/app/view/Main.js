Ext.define('app.view.Main', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.*',
        'Ext.layout.container.Border'
    ],
    
    xtype: 'app-main',

    layout: {
        type: 'border'
    },

    items: [{	
    	region: 'north',
    	id: 'north-menu',
    	bbar: {
    		items:[{
    		height:80,
    		border: false,
    		xtype:'image',
    		src:'css/images/meloyasoc.jpg'//,
    		
    	},'->'
//    	,'<b>Usuario:</b> '+usuario + '<br><b>Productor:</b>'
    	, Ext.create('Ext.Component', {
//    		html: 'HOLA',
    		id:'panelUsuario',
//    		xtype:'panel',
    		 tpl: '<span>Hello {name}</span>'
    	})
    	,{
    		text:'Salir',
    		scale: 'large',
    		handler:function(button){
    			button.setDisabled(true);
    			var redirect = 'login.jsp';
                window.location = redirect;
                
    		}
    	}]}
    },{
        region: 'west',
        xtype: 'panel',
        title: 'Menu',
//		layout: {
//			type: 'vbox',
//			align: 'stretch',
//			tdAttrs: { style: 'padding: 5px 10px;' }
//		},
//		defaults:{
//			textAlign:'left'
//		},
//        layout : {
//			type : 'accordion',
//			fill:false,
//			hideCollapseTool:true,
//			animate : true
//			
//		},
		defaults : {
			xtype : 'buttongroup',
			collapsed:false,
			layout : {
				type : 'vbox',
				align : 'stretch',
				tdAttrs : {
					style : 'padding: 5px 10px;cellspacing:5px;'
				}
			}
		},
		items:[
		       {
		    	   title:'Clientes',
		    	   defaults : {
						textAlign : 'left',
//						xtype:'button',
						style : 'margin-top:5px'
					},
		    	   items:[
		    	          {
		    	        	  xtype:'button',
		    	        	  text:'Administrar',
		    	        	  itemId:'clientes',
		    	        	  iconCls:'icon_clientes'
		    	          }
		    	          ]
		       
		       },{
		    	   title:'Polizas',
		    	   defaults : {
						textAlign : 'left',
//						xtype:'button',
						style : 'margin-top:5px'
					},
		    	   items:[
						{
							xtype:'button',
							itemId:'polizas',
							text:'P&oacute;lizas',
							iconCls:'icon_polizas'
						}  ,{
							xtype:'button',
							itemId:'pagosPolizas',
							text:'Pagos de Polizas',
							iconCls:'icon_pagos_polizas'
						} ,{
			   				xtype:'button',
			   				text:'Secciones',
			   				itemId:'secciones',
			   				iconCls:'icon_secciones'
			   			}
		    	    ]
		       },{
		    	   title:'Companias',
		    	   defaults : {
						textAlign : 'left',
//						xtype:'button',
						style : 'margin-top:5px'
					},
		    	   items:[
		    		   {
		   				xtype:'button',
		   				itemId:'companias',
		   				text:'Administrar',
		   				iconCls:'icon_companias'
		   			},{
		   				xtype:'button',
		   				itemId:'pagosCompanias',
		   				text:'Pagos',
		   				iconCls:'icon_pagos_companias'
		   			} 
		    	   ]
		       },{
		    	   title:'Listados',
		    	   defaults : {
						textAlign : 'left',
//						xtype:'button',
						style : 'margin-top:5px'
					},
		    	   items:[
				      {
								xtype : 'button',
								itemId : 'polizasPorVencer',
								text : 'Polizas x Vencer',
								iconCls : 'icon_pagos_companias'
					}
		    	          ]
		       }
		],
		
        width: 150
    },{
        region: 'center',
        id:'app-center',
        xtype: 'tabpanel'
        ,items:[{
			xtype:'clientesList'
			,editionMode:app.utils.EditionMode.TAB
        }]
    }]
});