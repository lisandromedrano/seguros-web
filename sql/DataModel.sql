/*==============================================================*/
/* Database name:  seguros                                      */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     16/06/2014 12:10:10                          */
/*==============================================================*/


drop database if exists seguros;

/*==============================================================*/
/* Database: seguros                                            */
/*==============================================================*/
create database seguros;

use seguros;

/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES
(
   ID                   INTEGER unsigned not null auto_increment,
   NOMBRE               VARCHAR(30),
   APELLIDO             VARCHAR(30),
   DIRECCION            VARCHAR(100),
   TELEFONO             VARCHAR(30),
   EMAIL                VARCHAR(30),
   OBSERVACIONES        VARCHAR(100),
   F_NACIMIENTO         DATETIME,
   DNICUIT              VARCHAR(30),
   primary key (ID)
);

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
/* Table: POLIZAS                                               */
/*==============================================================*/
create table POLIZAS
(
   ID                   INTEGER unsigned not null auto_increment,
   ID_CLIENTE           INTEGER unsigned,
   ID_COMPANIA          INTEGER unsigned,
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
   F_REGISTRACION       DATETIME,
   ORDEN                INTEGER,
   PATENTE              VARCHAR(7),
   primary key (ID)
);

/*==============================================================*/
/* Table: SECCIONES                                             */
/*==============================================================*/
create table SECCIONES
(
   ID                   INTEGER unsigned not null auto_increment,
   ID_COMPANIA          INTEGER,
   NOMBRE               VARCHAR(50),
   CODIGO               VARCHAR(5),
   primary key (ID)
);

alter table PAGOS add constraint FK_PAGO_COMPANIA foreign key (ID_COMPANIA)
      references COMPANIAS (ID) on delete cascade;

alter table PAGOS add constraint FK_PAGO_POLIZA foreign key (ID_POLIZA)
      references POLIZAS (ID) on delete cascade;

alter table POLIZAS add constraint FK_POLIZA_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTES (ID) on delete cascade;

alter table POLIZAS add constraint FK_POLIZA_COMPANIA foreign key (ID_COMPANIA)
      references COMPANIAS (ID) on delete cascade;

alter table POLIZAS add constraint FK_POLIZA_SECCION foreign key (SECCION_ID)
      references SECCIONES (ID) on delete cascade;

