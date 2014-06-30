insert into seguros_test.companias (id,nombre)
 select id,nombre from seguros_test.companias_temp;
 
 insert into CLIENTES (
 	ID           
	,NOMBRE       
	,APELLIDO     
	,DIRECCION    
	,TELEFONO     
	,EMAIL        
	,OBSERVACIONES
	,F_NACIMIENTO 
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
from clientes_temp;
-- 512 filas insertadas. (La consulta tardó 0.0306 seg)

update `clientes` set F_NACIMIENTO=null WHERE `F_NACIMIENTO` = '0000-00-00'
-- 408 filas afectadas. (La consulta tardó 0.0368 seg)

insert into SECCIONES (ID,CODIGO,NOMBRE)
select id,codigo,NOMBRE from secciones_temp;

SET FOREIGN_KEY_CHECKS=0;
insert into polizas(
	ID                
	,ID_CLIENTE        
	,ID_COMPANIA       
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
	,F_REGISTRACION    
	,ORDEN             
	,PATENTE    ) 
	
select 
	id
	,id_cliente
	,id_compania
	,(select id from secciones where codigo=TIPO_POLIZA)
	,NRO_POLIZA
	,ENDOSO
	,OBSERVACIONES
	,STR_TO_DATE(F_VIG_DESDE, '%d/%m/%Y') 
	,STR_TO_DATE(F_VIG_HASTA, '%d/%m/%Y') 
	,CANT_CUOTAS
	,PRIMA
	,SUMA
	,PREMIO
	,null
	,BIEN_A_CUBRIR
	,MONEDA
	,RIESGO_A_CUBRIR
	,CLASE_POLIZA
	,UBICACION
	,NRO_CHASIS
	,NRO_MOTOR
	,TIPO_COBERTURA
	,STR_TO_DATE(f_registracion, '%d/%m/%Y') 
	,ORDEN
	,PATENTE
from polizas_temp;
SET FOREIGN_KEY_CHECKS=1;

update `polizas` set F_VIG_DESDE=null WHERE `F_VIG_DESDE` = '0000-00-00';
update `polizas` set F_VIG_HASTA=null WHERE `F_VIG_HASTA` = '0000-00-00';
update `polizas` set F_REGISTRACION=null WHERE `F_REGISTRACION` = '0000-00-00';

insert into pagos
	(ID
	,ID_POLIZA
	,ID_COMPANIA
	,FECHA
	,IMPORTE
	,TIPO_PAGO
	,CONCEPTO
	,NRO_RECIBO
	,FECHA_VENCIMIENTO)
select 
	id
	,id_poliza
	,id_compania
	,STR_TO_DATE(fecha, '%d/%m/%Y') 
	,importe
	,TIPO_PAGO
	,CONCEPTO
	,NRO_RECIBO
	,STR_TO_DATE(fechaVencimiento, '%d/%m/%Y') 
from pagos_temp;
--7599 filas afectadas.

update pagos set FECHA_VENCIMIENTO=null WHERE FECHA_VENCIMIENTO = '0000-00-00';
update pagos set FECHA=null WHERE FECHA = '0000-00-00';