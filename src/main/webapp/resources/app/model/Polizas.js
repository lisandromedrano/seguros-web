Ext.define('app.model.Polizas', {
    extend: 'Ext.data.Model',
    fields: [
		{name:'id'}, 
		{name:'clientes'}, 
		{name:'clientes.id'}, 
		{name:'companias'}, 
		{name:'companias.id'}, 
		{name:'secciones'}, 
		{name:'nroPoliza'}, 
		{name:'endoso'}, 
		{name:'observaciones'}, 
		{name:'fVigDesde',type:'date', dateFormat: 'd-m-Y'}, 
		{name:'fVigHasta',type:'date', dateFormat: 'd-m-Y'}, 
		{name:'cantCuotas'}, 
		{name:'prima'}, 
		{name:'suma'}, 
		{name:'premio'}, 
		{name:'tipoPoliza'}, 
		{name:'tipoPoliza.id'}, 
		{name:'bienACubrir'}, 
		{name:'moneda'}, 
		{name:'riesgoACubrir'}, 
		{name:'clasePoliza'}, 
		{name:'ubicacion'}, 
		{name:'nroChasis'}, 
		{name:'nroMotor'}, 
		{name:'tipoCobertura'}, 
		{name:'fRegistracion',type:'date', dateFormat: 'd-m-Y'}, 
		{name:'orden'}, 
		{name:'patente'}
    ],
	idProperty: 'id',
	validations: [
{
		type : 'daterange',
		name : 'fVigDesde',
		minField : 'fVigDesde',
		maxField : 'fVigHasta',
		minFieldName : 'Vigencia Desde',
		maxFieldName : 'Vigencia Hasta'
	} ,
          {type: 'presence', field: 'nroPoliza'},
          {type: 'presence', field: 'endoso'},
          {type: 'presence', field: 'fVigDesde'},
          {type: 'presence', field: 'fVigHasta'},
          {type: 'presence', field: 'cantCuotas'},
          {type: 'presence', field: 'tipoPoliza.id'},
          {type: 'presence', field: 'companias.id'}
          
      ]
});

