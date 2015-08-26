/*==============================================================*/
/* Database name:  master                                       */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     09/04/2015 20:23:08                          */
/*==============================================================*/


drop database if exists master;

/*==============================================================*/
/* Database: master                                             */
/*==============================================================*/
create database master;

use master;

/*==============================================================*/
/* Table: companias_ref                                         */
/*==============================================================*/
create table companias_ref
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(30),
   primary key (ID)
);

/*==============================================================*/
/* Table: monedas                                               */
/*==============================================================*/
create table monedas
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: operaciones                                           */
/*==============================================================*/
create table operaciones
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: origenes                                              */
/*==============================================================*/
create table origenes
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: ramos                                                 */
/*==============================================================*/
create table ramos
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: tipos_documento                                       */
/*==============================================================*/
create table tipos_documento
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: tipos_envio                                           */
/*==============================================================*/
create table tipos_envio
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: tipos_persona                                         */
/*==============================================================*/
create table tipos_persona
(
   ID                   INTEGER unsigned not null auto_increment,
   DESCRIPCION          VARCHAR(100),
   CODIGO               VARCHAR(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: user_roles                                            */
/*==============================================================*/
create table user_roles
(
   user_role_id         int(11) not null auto_increment,
   username             varchar(30) not null,
   ROLE                 varchar(30) not null,
   primary key (user_role_id),
   unique key uni_username_role (ROLE, username),
   key fk_username_idx (username)
);

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   ID                   int(10) unsigned not null auto_increment,
   USERNAME             varchar(30) default NULL,
   PASSWORD             varchar(30) default NULL,
   ENABLED              tinyint(1) default NULL,
   primary key (ID),
   unique key AK_UK_USERS (USERNAME)
);

/*==============================================================*/
/* Table: usuarios_productores                                  */
/*==============================================================*/
create table usuarios_productores
(
   ID                   int(11) not null,
   USER_ID              int(11) default NULL,
   PRODUCTOR_ID         int(11) default NULL,
   primary key (ID),
   key FK_UP_PRODUCTORES (PRODUCTOR_ID)
);

alter table usuarios_productores add constraint FK_UP_PRODUCTORES foreign key (PRODUCTOR_ID)
      references productores (ID);

alter table usuarios_productores add constraint FK_UP_USERS foreign key (USER_ID)
      references users (ID);

