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
//    	layout:'vbox',
    	//cls:'accura-header',
    	
//    	items:[],
//    	margins: '0 0 5 10',
    	bbar: {
//    		cls:'app-header',
    		items:[{
    		height:80,
    		border: false,
    		xtype:'image',
//    		autoEl: 'div',
//    		style:'max-width:200px',
//    		cls: 'seguros-main-logo',
    		src:'css/images/meloyasoc.jpg'//,
    		
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