insert into seguros_test.companias (id,nombre)
 select id,nombre from seguros_test.companias_temp;
 
 insert into seguros_test.clientes (
 	id           
	,nombre       
	,apellido     
	,direccion    
	,telefono     
	,email        
	,observaciones
	,f_nacimiento 
	,DNICUIT)
select 
	id           
	,nombre       
	,apellido     
	,direccion    
	,telefono     
	,email        
	,observaciones
	,STR_TO_DATE(f_nacimiento, '%d/%m/%Y') 
	,DNICUIT
from seguros_test.clientes_temp;
insert into polizas(
	ID                
	,id_cliente        
	,id_compania       
	,SECCION_ID        
	,NRO_POLIZA        
	,ENDOSO            
	,OBSERVACIONES     
	,F_VIG_DESDE       
	,F_VIG_HASTA       
	,CANT_CUOTAS       
	,PRIMA             
	,SUMA              
	,PREMIO            
	,TIPO_POLIZA       
	,BIEN_A_CUBRIR     
	,MONEDA            
	,RIESGO_A_CUBRIR   
	,CLASE_POLIZA      
	,UBICACION         
	,NRO_CHASIS        
	,NRO_MOTOR         
	,TIPO_COBERTURA    
	,f_registracion    
	,ORDEN             
	,PATENTE    )      