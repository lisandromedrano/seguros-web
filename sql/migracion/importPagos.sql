-- CSV id;fecha;importe;TIPO_PAGO;CONCEPTO;id_poliza;id_compania;NRO_RECIBO;fechaVencimiento

/* Table Pagos

   ID                   INTEGER unsigned not null auto_increment,
   ID_POLIZA            INTEGER unsigned,
   ID_COMPANIA          INTEGER unsigned,
   FECHA                DATETIME,
   IMPORTE              DOUBLE,
   TIPO_PAGO            VARCHAR(1),
   CONCEPTO             VARCHAR(100),
   NRO_RECIBO           INT,
   FECHA_VENCIMIENTO    DATETIME,
*/
LOAD DATA INFILE 'pagos.csv' IGNORE
INTO TABLE PAGOS (ID,FECHA, IMPORTE, TIPO_PAGO, CONCEPTO, ID_POLIZA,ID_COMPANIA,NRO_RECIBO,FECHA_VENCIMIENTO)