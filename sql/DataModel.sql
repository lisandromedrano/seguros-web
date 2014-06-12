/*==============================================================*/
/* Database name:  seguros                                      */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/11/2013 13:07:38                          */
/*==============================================================*/


drop database if exists seguros;

/*==============================================================*/
/* Database: seguros                                            */
/*==============================================================*/
create database seguros;

use seguros;

/*==============================================================*/
/* Table: COMPANIAS                                             */
/*==============================================================*/
create table COMPANIAS
(
   ID                   INTEGER unsigned not null auto_increment,
   NOMBRE               VARCHAR(30),
   primary key (ID)
);

/*==============================================================*/
/* Table: PAGOS                                                 */
/*==============================================================*/
create table PAGOS
(
   ID                   INTEGER unsigned not null auto_increment,
   ID_POLIZA            INTEGER unsigned,
   ID_COMPANIA          INTEGER unsigned,
   FECHA                DATETIME,
   IMPORTE              DOUBLE,
   TIPO_PAGO            VARCHAR(1),
   CONCEPTO             VARCHAR(100),
   NRO_RECIBO           INT,
   FECHA_VENCIMIENTO    DATETIME,
   primary key (ID)
);

/*==============================================================*/
/* Table: clientes                                              */
/*==============================================================*/
create table clientes
(
   id                   INTEGER unsigned not null auto_increment,
   nombre               VARCHAR(30),
   apellido             VARCHAR(30),
   direccion            VARCHAR(100),
   telefono             VARCHAR(30),
   email                VARCHAR(30),
   observaciones        VARCHAR(100),
   f_nacimiento         DATETIME,
   DNICUIT              VARCHAR(30),
   primary key (id)
);

/*==============================================================*/
/* Table: polizas                                               */
/*==============================================================*/
create table polizas
(
   ID                   INTEGER unsigned not null,
   id_cliente           INTEGER unsigned,
   id_compania          INTEGER unsigned,
   SECCION_ID           INT unsigned,
   NRO_POLIZA           VARCHAR(20),
   ENDOSO               VARCHAR(20),
   OBSERVACIONES        VARCHAR(100),
   F_VIG_DESDE          DATETIME,
   F_VIG_HASTA          DATETIME,
   CANT_CUOTAS          INTEGER,
   PRIMA                DOUBLE,
   SUMA                 DOUBLE,
   PREMIO               DOUBLE,
   TIPO_POLIZA          VARCHAR(5),
   BIEN_A_CUBRIR        VARCHAR(40),
   MONEDA               VARCHAR(3),
   RIESGO_A_CUBRIR      VARCHAR(50),
   CLASE_POLIZA         VARCHAR(1),
   UBICACION            VARCHAR(100),
   NRO_CHASIS           VARCHAR(50),
   NRO_MOTOR            VARCHAR(50),
   TIPO_COBERTURA       VARCHAR(50),
   f_registracion       DATETIME,
   ORDEN                INTEGER,
   PATENTE              VARCHAR(7),
   primary key (ID)
);

/*==============================================================*/
/* Table: secciones                                             */
/*==============================================================*/
create table secciones
(
   ID                   INTEGER unsigned not null auto_increment,
   ID_COMPANIA          INTEGER,
   NOMBRE               VARCHAR(50),
   codigo               VARCHAR(5),
   primary key (ID)
);

alter table PAGOS add constraint FK_PAGO_COMPANIA foreign key (ID_COMPANIA)
      references COMPANIAS (ID) on delete restrict on update restrict;

alter table PAGOS add constraint FK_PAGO_POLIZA foreign key (ID_POLIZA)
      references polizas (ID) on delete restrict on update restrict;

alter table polizas add constraint FK_POLIZA_CLIENTE foreign key (id_cliente)
      references clientes (id) on delete restrict on update restrict;

alter table polizas add constraint FK_POLIZA_COMPANIA foreign key (id_compania)
      references COMPANIAS (ID) on delete restrict on update restrict;

alter table polizas add constraint FK_POLIZA_SECCION foreign key (SECCION_ID)
      references secciones (ID) on delete restrict on update restrict;

