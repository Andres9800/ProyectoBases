-- Proyecto Administracion de Bases de Datos
-- II Ciclo - 2022
-- Autores:
-- Andres Rojas Rojas
-- Joaquin Barrientos
-- Wendy Largaespada
-- Andres Cordero

alter session set "_ORACLE_SCRIPT"=true;

/**************************** SECCION DE DROPS *******************************/
PROMPT === DROPS DE USUARIOS ===
drop user "cajero" CASCADE;
drop user "gerentefrescos" CASCADE;
drop user "gerenteabarrotes" CASCADE;
drop user "gerentepersonal" CASCADE;
drop user "gerentemercancia" CASCADE;
drop user "gerentegeneral" CASCADE;
drop user "sistemas" CASCADE;

PROMPT === DROPS DE TABLAS ===
DROP TABLE usuario CASCADE CONSTRAINTS;
DROP TABLE producto CASCADE CONSTRAINTS;
DROP TABLE factura CASCADE CONSTRAINTS;
DROP TABLE detalle CASCADE CONSTRAINTS;

DROP TABLE tabla_maestra_auditoria CASCADE CONSTRAINTS;

DROP TABLE auditoria_mov CASCADE CONSTRAINTS;
DROP TABLE auditoria_cajeros CASCADE CONSTRAINTS;
DROP TABLE registroUsuario CASCADE CONSTRAINTS;
DROP TABLE movimientoProducto CASCADE CONSTRAINTS;

PROMPT === DROPS DE ROLES ===
drop role "cajeros";
drop role "fresco";
drop role "mercancia";
drop role "personal";
drop role "abarrote";
drop role "general";
drop role "sistema";


/******************  SECCION DE CREACION DE TABLAS ************************/
PROMPT === CREAICON DE TABLAS DE NEGOCIO ===
create table usuario (
cedula int not NULL,
username varchar(45) not null,
areaAsignada varchar(45) not null,
rol varchar(20),
pass varchar(20),
constraint PK_cedula primary key (cedula)
);

create table producto (
codigo varchar(30) not null,
plu int,
ean float,
descripcion varchar(40) not null,
precio float not null,
peso float,
cantidad int not null,
area varchar(15) not null,
constraint PK_Codigo primary key (codigo)
);

create table factura (
idfactura NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
num_caja int not null,
nombre_cajero varchar(45) not null,
fecha date not null,
hora varchar(5) not null,
constraint PK_idfactura primary key (idfactura)
);

create table detalle (
idDetalle NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
idfacturaF int not null,
cantidadProducto int not null,
pesoProducto float not null,
subTotal float not null,
total float not null,
codigo varchar(30),
constraint PK_idDetalle primary key (idDetalle),
constraint FK_factura foreign key (idfacturaF) references factura(idfactura),
constraint FK_codigo foreign key (codigo) references producto(codigo)
);

PROMPT == CREACION DE TABLAS DE AUDITORIA ==

create table tabla_maestra_auditoria(
    codigo varchar(30) not null,
    accion varchar(30)not null,
    fecha timestamp,
    usuario varchar(30),
    tabla_afectada varchar(30)
);

/***************** SECCION DE USUARIOS Y ROLES **************************/
PROMPT === CREACION DE USUARIOS ===
create user "cajero" identified by "cajero"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users;

create user "gerentefrescos" identified by "gerentefrescos"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users;

create user "gerenteabarrotes" identified by "gerenteabarrotes"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users;

create user "gerentepersonal" identified by "gerentepersonal"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users;

create user "gerentemercancia" identified by "gerentemercancia"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users;

create user "gerentegeneral" identified by "gerentegeneral"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users;

create user "sistemas" identified by "sistemas"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users;

PROMPT === CREAICION DE ROLES ===
create role "cajeros";
create role "fresco";
create role "mercancia";
create role "personal";
create role "abarrote";
create role "general";
create role "sistema";

grant update (descripcion, peso) on producto to "fresco";
grant update (descripcion, cantidad) on producto to "abarrote";
grant update (descripcion, cantidad) on producto to "mercancia";
grant update (descripcion, cantidad) on producto to "personal";
grant select on producto to "fresco";
grant select on producto to "abarrote";
grant select on producto to "mercancia";
grant select on producto to "personal";
grant update (peso) on producto to "cajeros";
grant update (cantidad) on producto to "cajeros";
grant select on producto to "cajeros";
grant select,update,insert,delete on producto to "general";
grant select,update,insert,delete on producto to "sistema";
grant insert on factura to "cajeros";
grant insert on detalle to "cajeros";
grant update, select on factura to "general";
grant update, select on detalle to "general";

PROMPT === GRANT A USUARIOS ===
grant connect, resource to "cajero";
grant connect, resource to "gerentefrescos";
grant connect, resource to "gerenteabarrotes";
grant connect, resource to "gerentepersonal";
grant connect, resource to "gerentemercancia";
grant connect, resource to "gerentegeneral";
grant connect, resource to "sistemas";
grant create session to "cajero";
grant create session to "gerentefrescos";
grant create session to "gerenteabarrotes";
grant create session to "gerentepersonal";
grant create session to "gerentemercancia";
grant create session to "gerentegeneral";
grant create session to "sistemas";

PROMPT === ASIGNAR PRIVILEGIOS A ROLES ===
grant update (descripcion, peso) on producto to "fresco";
grant update (descripcion, cantidad) on producto to "abarrote";
grant update (descripcion, cantidad) on producto to "mercancia";
grant update (descripcion, cantidad) on producto to "personal";
grant select on producto to "fresco";
grant select on producto to "abarrote";
grant select on producto to "mercancia";
grant select on producto to "personal";
grant update (peso) on producto to "cajeros";
grant update (cantidad) on producto to "cajeros";
grant select on producto to "cajeros";
grant select,update,insert,delete on producto to "general";
grant select,update,insert,delete on producto to "sistema";
grant insert on factura to "cajeros";
grant insert on detalle to "cajeros";
grant update, select on factura to "general";
grant update, select on detalle to "general";

PROMPT === ASIGNAR ROLES A USUARIOS ===
grant "cajeros" to "cajero";
grant "fresco" to "gerentefrescos";
grant "mercancia" to "gerentemercancia";
grant "personal" to "gerentepersonal";
grant "abarrote" to "gerenteabarrotes";
grant "general" to "gerentegeneral";
grant "sistema" to "sistemas";

/****** SECCION DE CREACION DE TRIGGERS ****/
PROMPT == CREACION DE TRIGGERS ==
create or replace trigger audita_dml_producto
    after insert or update or delete
    on producto
    for each row
begin
if inserting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:new.codigo,'producto insertado',sysdate,user, 'producto');
end if;
if updating then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.codigo,'producto modificado',sysdate,user, 'producto');
end if;
if deleting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.codigo,'producto borrado',sysdate,user, 'producto');
end if;
end audita_dml_producto;
/

create or replace trigger audita_dml_factura
    after insert or update or delete
    on factura
    for each row
begin
if inserting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:new.idfactura,'factura insertada',sysdate,user, 'factura');
end if;
if updating then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idfactura,'facutra modificada',sysdate,user, 'factura');
end if;
if deleting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idfactura,'factura borrada',sysdate,user, 'factura');
end if;
end audita_dml_factura;
/

create or replace trigger audita_dml_detalle
    after insert or update or delete
    on detalle
    for each row
begin
if inserting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:new.idDetalle,'detalle de venta insertado',sysdate,user, 'detalle');
end if;
if updating then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idDetalle,'detalle de venta modificado',sysdate,user, 'detalle');
end if;
if deleting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idDetalle,'detalle de venta borrado',sysdate,user, 'detalle');
end if;
end audita_dml_detalle;
/

/*Registra las ventas de los cajeros*/
create table auditoria_cajeros(
id_cajero NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
usuario varchar(30) not null,
num_caja int not null,
num_fact int not null,
monto_total float not null,
fecha date not null,
hora varchar(5) not null 
);
create table registroUsuario(
cedula int not null,
username varchar(45) not null,
constraint FK_cedula_RU foreign key (cedula) references usuario (cedula)
);
create table movimientoProducto(
movimiento NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
codigo varchar(15) not null,
descripcion varchar(30) not null,
constraint PK_movimiento primary key (movimiento)
);

/*************** SECCION DE CREACION DE VISTAS *********************/
CREATE OR REPLACE VIEW auditoria_producto as
    SELECT * FROM tabla_maestra_auditoria
    where tabla_afectada = 'producto';

CREATE OR REPLACE VIEW auditoria_factura as
    SELECT * FROM tabla_maestra_auditoria
    where tabla_afectada = 'factura';
    
CREATE OR REPLACE VIEW auditoria_datalle as
    SELECT * FROM tabla_maestra_auditoria
    where tabla_afectada = 'detalle';
    

    
/*************** SECCION DE PROCEDIMIENTOS ALMACENADOS *********************/
CREATE OR REPLACE NONEDITIONABLE PROCEDURE inserta_producto (
    p_codigo in varchar,
    p_plu in int,
    p_ean in float,
    p_desc in varchar,
    p_precio in float,
    p_peso in float,
    p_cantidad in int,
    p_area in varchar
)
IS
BEGIN
    INSERT INTO producto(codigo, plu, ean, descripcion, precio, peso, cantidad, area)
        values (p_codigo, p_plu, p_ean, p_desc, p_precio, p_peso, p_cantidad, p_area);
        commit;
EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR de insercion: datos incorrectos en producto');
END;
/
show error


CREATE OR REPLACE PROCEDURE updateProducto (
    descrip producto.descripcion%type,
    cant producto.cantidad%type,
    prec producto.precio%type, 
    a producto.area%type, 
    p producto.peso%type, 
    cod producto.codigo%type
)
AS
BEGIN
    UPDATE producto SET descripcion = descrip, cantidad = cantidad + cant, precio = prec, area = a, peso = p
    where codigo = cod;
EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR datos de actualizacion incorrectos en producto');
END;
/

/**************************************************** Eliminar producto **************************************************/
CREATE OR REPLACE PROCEDURE deleteProducto (cod producto.codigo%type)
AS
BEGIN
    delete from producto where codigo = cod;
EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR al eliminar datos en producto');
END;
/



/************************************************** Creacion de cursor **************************************************************/

/*CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;
/ */

/************************************************** Lista de productos ***********************************************************/

create or replace function listarProductos
return Types.ref_cursor
as
    solicitud_cursor Types.ref_cursor;
begin
    open solicitud_cursor for
    select * from producto;
    return solicitud_cursor;
end;
/

/************************************************** Lista de usuarios ***********************************************************/

create or replace function listarUsuarios
return Types.ref_cursor
as
    solicitud_cursor_usua Types.ref_cursor;
begin
    open solicitud_cursor_usua for
    select * from usuario;
    return solicitud_cursor_usua;
end;
/


/********* Lista de movimientos DETALLES ******************/

create or replace function listarMovimientosDet
return Types.ref_cursor
as
    solicitud_cursor_mov Types.ref_cursor;
begin
    open solicitud_cursor_mov for
    select * from auditoria_cajeros;
    return solicitud_cursor_mov;
end;
/


/********************* Insertar Factura ****************/
CREATE OR REPLACE NONEDITIONABLE PROCEDURE inserta_factura (caj factura.num_caja%type) 
AS
    v_fecha date;
    v_hora varchar(5);
    v_usuario varchar(30);
BEGIN
    select sysdate into v_fecha from dual;
    SELECT TO_CHAR(SYSDATE,'HH24:MI') into v_hora FROM DUAL;
    select max(username) into v_usuario from registroUsuario where rowid = (select max(rowid) from registroUsuario);
    INSERT into factura(num_caja,nombre_cajero,fecha,hora) values(caj,v_usuario,v_fecha,v_hora);

EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR datos de inserciÃƒÂ³n incorrectos');
END;
/

CREATE OR REPLACE NONEDITIONABLE PROCEDURE dameMaxFact (maxi out int)
AS
BEGIN
    select max(idfactura) into maxi from factura;

EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR datos de inserciÃƒÂ³n incorrectos');
END;
/


/**************** modificadores de peso y cant ***************/

CREATE OR REPLACE PROCEDURE modifica_peso_fresco_dif (prod producto.codigo%type, cant producto.peso%type) 
AS
    v_old_cant float;
    err1 exception;
BEGIN
    select peso into v_old_cant from producto where codigo=prod;
    if((v_old_cant - cant)>-1) then
        UPDATE producto set peso=(v_old_cant - cant) where codigo=prod;
    else
        raise err1;
    end if;

EXCEPTION
    WHEN err1 THEN
        RAISE_APPLICATION_ERROR(NUM=> -20012, MSG=> 'SUPERA PESO');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR usuario no logeado');
END;
/


CREATE OR REPLACE PROCEDURE modifica_cant_dif (prod producto.codigo%type, cant producto.cantidad%type) 
AS
    v_old_cant int;
    err1 exception;
BEGIN
    select cantidad into v_old_cant from producto where codigo=prod;
    if((v_old_cant - cant)>-1) then
        UPDATE producto set cantidad=(v_old_cant - cant) where codigo=prod;
    else
        raise err1;
    end if;
EXCEPTION
    WHEN err1 THEN
        RAISE_APPLICATION_ERROR(NUM=> -20012, MSG=> 'SUPERA CANTIDAD');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR usuario no logeado');
END;
/



/*********************************************************************************************************************/
/**********************************************Insertar Detalle*******************************************************/
/*********************************************************************************************************************/

CREATE OR REPLACE PROCEDURE producto_resta_cantidad (prod producto.codigo%type, cant producto.cantidad%type) 
AS
    v_old_cant int;
    err1 exception;
BEGIN
    select cantidad into v_old_cant from producto where codigo=prod;
    if((v_old_cant - cant)>-1) then
        UPDATE producto set cantidad=(v_old_cant - cant) where codigo=prod;
    else
        raise err1;
    end if;
EXCEPTION
    WHEN err1 THEN
        RAISE_APPLICATION_ERROR(NUM=> -20012, MSG=> 'SUPERA CANTIDAD');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR usuario no logeado');
END;
/
CREATE OR REPLACE PROCEDURE insertar_detalle (IDf factura.idfactura%type, cant detalle.cantidadProducto%type,pess detalle.pesoProducto%type, prod detalle.codigo%type, tipo int) 
AS
    v_idprod int;
    v_valor float;
    err1 exception;
BEGIN
    select count(codigo) into v_idprod from producto where codigo=prod;
    if(v_idprod!=0) then
            producto_resta_cantidad(prod,cant);
            select precio into v_valor from producto where codigo=prod;
            insert into detalle(idfacturaF,cantidadProducto,pesoProducto,subTotal,total,codigo) values (IDf,0,pess,(pessv_valor),(pessv_valor),prod);
    else 
        raise err1;
    end if;
EXCEPTION
    WHEN err1 THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20012, MSG=> 'ERROR-PRODUCTO NO ENCONTRADO');
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR error al insertar-contacte al admin');
END;
/

/*------------------------------------------------------------------------------------------------Inserts*/


Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (111,'cajero1','cajeros','cajeros','cajeros');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (222,'cajero2','cajeros','cajeros','cajeros');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (333,'cajero3','cajeros','cajeros','cajeros');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (444,'gerenteAbarrotes','Abarrote','gerentes','gerentes');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (555,'gerenteCuidadoPersonal','Personal','gerentes','gerentes');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (666,'gerenteMercancias','Mercancia','gerentes','gerentes');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (777,'gerenteFrescos','Fresco','gerentes','gerentes');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (888,'gerenteGeneral1','general','gerentesGenerales','gerentesG');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (999,'gerenteGeneral2','general','gerentesGenerales','gerentesG');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (1010,'ingeniero1','Sistemas','ingenieros','ingenieros');
Insert into SYSTEM.USUARIO (CEDULA,USERNAME,AREAASIGNADA,ROL,PASS) values (1111,'ingeniero2','Sistemas','ingenieros','ingenieros');

--select *from usuario;

commit;
--quitar nombre y apellido
--nombre se pasa a username
select * from producto;
delete from producto ;

call inserta_producto (
    '122344S',
    8912,
    378424715000000,
    'repollo',
    750.6,
    400.2,
    15,
    'Fresco'
);


select * from tabla_maestra_auditoria;
delete from tabla_maestra_auditoria;

update producto set descripcion = 'repollo morado' where codigo = '122344S';
