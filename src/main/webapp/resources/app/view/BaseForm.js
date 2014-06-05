Ext.define("app.view.BaseForm", {
	extend: 'Ext.form.Panel',
	alias:'widget.baseForm',
	autoScroll: true,
	initComponent: function(params) {
		this.buttons = [
		    {
		        text:'Guardar',
		        itemId:'save',
		        iconCls:'icon-save'//,
		//        handler:function(){
		//    		_this.fireEvent('save');
		//    	}
		    
		    },
		    {
		        text:'Cancelar',
		        scope:this,
		        iconCls:'icon-cancel',
		        handler:this.close
		    }
		];
		this.callParent(arguments);
	}

});