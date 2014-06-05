Ext.define('app.model.Companias', {
    extend: 'Ext.data.Model',
    fields: [
		{name:'id',type:'string'}, 
		{name:'nombre'}
    ],
	idProperty: 'id'
});

