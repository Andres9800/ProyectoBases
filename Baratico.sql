alter session set "_ORACLE_SCRIPT"=true;

/**************************************  Drops *****************************************************/
--Drop de usuarios
drop user "cajero" CASCADE;
drop user "gerentefrescos" CASCADE;
drop user "gerenteabarrotes" CASCADE;
drop user "gerentepersonal" CASCADE;
drop user "gerentemercancia" CASCADE;
drop user "gerentegeneral" CASCADE;
drop user "sistemas" CASCADE;
--Drop de tablas
DROP TABLE usuario CASCADE CONSTRAINTS;
DROP TABLE producto CASCADE CONSTRAINTS;
DROP TABLE factura CASCADE CONSTRAINTS;
DROP TABLE detalle CASCADE CONSTRAINTS;
DROP TABLE auditoria_mov CASCADE CONSTRAINTS;
DROP TABLE auditoria_cajeros CASCADE CONSTRAINTS;
DROP TABLE registroUsuario CASCADE CONSTRAINTS;
DROP TABLE movimientoProducto CASCADE CONSTRAINTS;
--Drop de roles
drop role "cajeros";
drop role "fresco";
drop role "mercancia";
drop role "personal";
drop role "abarrote";
drop role "general";
drop role "sistema";
/**************************************  Creacion de usuarios y roles *****************************************************/

create user "cajero" identified by "cajero"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users
;

create user "gerentefrescos" identified by "gerentefrescos"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users
;

create user "gerenteabarrotes" identified by "gerenteabarrotes"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users
;

create user "gerentepersonal" identified by "gerentepersonal"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users
;

create user "gerentemercancia" identified by "gerentemercancia"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users
;

create user "gerentegeneral" identified by "gerentegeneral"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users
;

create user "sistemas" identified by "sistemas"
default tablespace users
temporary TABLESPACE temp
quota unlimited on users
;

/***********************************************  Creacion de tablas ********************************************************/

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

/*********************************************** Creacion de privilegios ***************************************************/

grant connect, resource to "cajero";
grant connect, resource to "gerentefrescos";
grant connect, resource to "gerenteabarrotes";
grant connect, resource to "gerentepersonal";
grant connect, resource to "gerentemercancia";
grant connect, resource to "gerentegeneral";
grant connect, resource to "sistemas";

/*********************************************** Creacion de sesion *********************************************************/

grant create session to "cajero";
grant create session to "gerentefrescos";
grant create session to "gerenteabarrotes";
grant create session to "gerentepersonal";
grant create session to "gerentemercancia";
grant create session to "gerentegeneral";
grant create session to "sistemas";

/*********************************************** Creacion de roles **********************************************************/

create role "cajeros";
create role "fresco";
create role "mercancia";
create role "personal";
create role "abarrote";
create role "general";
create role "sistema";

/*********************************************** Asignacion de funciones ****************************************************/

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

/*********************************************** Asignacion de rol a cada usuario *******************************************/

grant "cajeros" to "cajero";
grant "fresco" to "gerentefrescos";
grant "mercancia" to "gerentemercancia";
grant "personal" to "gerentepersonal";
grant "abarrote" to "gerenteabarrotes";
grant "general" to "gerentegeneral";
grant "sistema" to "sistemas";

/*********************************************** Creacion de tablas de auditoria ********************************************/
/*Insertar, modificar y eliminar productos*/
create table auditoria_mov(
id_venta NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
descripcion varchar(40) not null,
accion varchar(30) not null,
fecha date not null,
hora varchar(5) not null,
usuario varchar(30) not null,
tabla_afec varchar(30) not null
);
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

/***************************************** Creacion de TRIGGERS ************************************************************/
/**************************************** Insercion de productos ***********************************************************/



create or replace NONEDITIONABLE trigger audita_insertar_producto
after insert on producto
declare
v_fecha date;
v_hora varchar(5);
v_usuario varchar(30);
v_descripcion varchar(40);
begin
select max(username) into v_usuario from registroUsuario where rowid = (select max(rowid) from registroUsuario);
select sysdate into v_fecha from dual;
SELECT TO_CHAR(SYSDATE,'HH24:MI') into v_hora FROM DUAL;
select max(descripcion) into v_descripcion from movimientoProducto where rowid = (select max(rowid) from movimientoProducto);
insert into auditoria_mov (descripcion,accion,fecha,hora,usuario,tabla_afec) values('Inserta Producto', v_descripcion, v_fecha, 
v_hora, v_usuario,'producto');
end;
/

/**************************************** Actualizacion de productos ***********************************************************/

create or replace NONEDITIONABLE trigger audita_actualizar_producto
after update on producto
declare
v_fecha date;
v_hora varchar(5);
v_usuario varchar(30);
v_descripcion varchar(40);
begin
select max(username) into v_usuario from registroUsuario where rowid = (select max(rowid) from registroUsuario);
select sysdate into v_fecha from dual;
SELECT TO_CHAR(SYSDATE,'HH24:MI') into v_hora FROM DUAL;
select max(descripcion) into v_descripcion from movimientoProducto where rowid = (select max(rowid) from movimientoProducto);
insert into auditoria_mov(descripcion,accion,fecha,hora,usuario,tabla_afec)values('Actualizar Producto',v_descripcion,v_fecha,
v_hora, v_usuario,'producto');
end;
/

/********************************************** Borrado de productos ***********************************************************/

create or replace NONEDITIONABLE trigger audita_elimina_producto
before delete on producto
declare
v_fecha date;
v_hora varchar(5);
v_usuario varchar(30);
v_descripcion varchar(40);
begin
select max(username) into v_usuario from registroUsuario where rowid = (select max(rowid) from registroUsuario);
select sysdate into v_fecha from dual;
SELECT TO_CHAR(SYSDATE,'HH24:MI') into v_hora FROM DUAL;
select max(descripcion) into v_descripcion from movimientoProducto where rowid = (select max(rowid) from movimientoProducto);
insert into auditoria_mov(descripcion,accion,fecha,hora,usuario,tabla_afec)values('Borra Producto',v_descripcion,v_fecha,v_hora, 
v_usuario,'producto');
end;
/

/********************************************** Insertar Detalle ***********************************************************/
/******************************************** Revisar mas adelante *********************************************************/

create or replace NONEDITIONABLE trigger audita_inserta_detalle
after insert on detalle
declare
v_fecha date;
v_hora varchar(5);
v_usuario varchar(30);
v_numCaja int;
v_numFact int;
v_montoTot float;
begin
select max(username) into v_usuario from registroUsuario where rowid = (select max(rowid) from registroUsuario);
select sysdate into v_fecha from dual;
SELECT TO_CHAR(SYSDATE,'HH24:MI') into v_hora FROM DUAL;
select max(num_caja) into v_numCaja from factura where rowid = (select max(rowid) from factura);
select max(idfactura) into v_numFact from factura where rowid = (select max(rowid) from factura);
select max(total) into v_montoTot from detalle where rowid = (select max(rowid) from detalle);
insert into auditoria_cajeros(usuario,num_caja,num_fact,monto_total,fecha,hora) values(v_usuario,v_numCaja,v_numFact,v_montoTot,v_fecha,
v_hora);
end;
/

/************************************* Creacion de PROCEDIMIENTOS ALMACENADOS ***************************************************/

/**************************************************** Inserta Producto ************************************************************/


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
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR datos de insercion incorrectos en producto');
END;
/
show error





/**************************************************** Inserta usuario *********************************************************/

CREATE OR REPLACE NONEDITIONABLE PROCEDURE inserta_usuario (ced usuario.cedula%type, username usuario.username%type, areaAsig usuario.areaAsignada%type, rol usuario.rol%type, pas usuario.pass%type)
AS
BEGIN
    INSERT INTO usuario values (ced,username,areaAsig,rol,pas);
EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR datos de inserciÃƒÂ³n incorrectos en usuario');
END;
/



/**************************************************** Actualizar producto **************************************************/

create or replace procedure updateProducto (
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

create or replace procedure deleteProducto (cod producto.codigo%type)
AS
BEGIN
    delete from producto where codigo = cod;
EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR al eliminar datos en producto');
END;
/



/************************************************** Creacion de cursor **************************************************************/

CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;
/ 

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

/************************************************** Registrar usuario ***********************************************************/

create or replace procedure registrarUsuario (ced registroUsuario.cedula%type, nom registroUsuario.username%type)
AS
BEGIN
    insert into registroUsuario values(ced,nom);
EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR al registrar datos en registroUsuario');
END;
/

/************************************************** Movimiento de productos *****************************************************/

create or replace procedure movimientosProductos (cod movimientoProducto.codigo%type, descrip movimientoProducto.descripcion%type)
AS
BEGIN
    insert into movimientoProducto(codigo,descripcion) values(cod,descrip);
EXCEPTION
    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(NUM=> -20011, MSG=> 'ERROR al registrar datos en movimientoProducto');
END;
/

/************************************************** Lista de movimientos ********************************************************/

create or replace function listarMovimientos
return Types.ref_cursor
as
    solicitud_cursor_mov Types.ref_cursor;
begin
    open solicitud_cursor_mov for
    select * from auditoria_mov;
    return solicitud_cursor_mov;
end;
/

/************************************************** Lista de movimientos DETALLES ********************************************************/

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



/*********************************************************************************************************************/
/**********************************************Insertar Factura*******************************************************/
/*********************************************************************************************************************/
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




/*********************************************************************************************************************/
/*modificadores de peso y cant*/

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

CREATE OR REPLACE PROCEDURE insertar_detalle (IDf factura.idfactura%type, cant detalle.cantidadProducto%type,pess detalle.pesoProducto%type, prod detalle.codigo%type, tipo int) 
AS
    v_idprod int;
    v_valor float;
    err1 exception;
BEGIN
    select count(codigo) into v_idprod from producto where codigo=prod;
    if(v_idprod!=0) then
        if(tipo!=0) then
            modifica_peso_fresco_dif(prod,pess);
            select precio into v_valor from producto where codigo=prod;
            insert into detalle(idfacturaF,cantidadProducto,pesoProducto,subTotal,total,codigo) values (IDf,0,pess,(pess*v_valor),(pess*v_valor),prod);
        else
            modifica_cant_dif(prod,cant);
            select precio into v_valor from producto where codigo=prod;
            insert into detalle(idfacturaF,cantidadProducto,pesoProducto,subTotal,total,codigo) values (IDf,cant,0.0f,(cant*v_valor),(cant*v_valor),prod);
        end if;
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


drop trigger audita_insertar_producto;

Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1234',8912,378424715,'lechuga',750.6,400.2,15,'Fresco');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1235',1094,378424715,'Arroz',100,325.2,60,'Abarrote');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1236',4141,378424715,'Frijojes',100,325.2,55,'Abarrote');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1237',4165,154848115,'leche',7050,0,30,'Fresco');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('6060',5478,514884544,'Atun',10,0,10,'Abarrote');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('8080',4110,216451874,'TioPelon',110,1,20,'Mercancia');



--select *from usuario;
--holaaaaaaaaaaaaaaaaaaaaaaa

commit;
--quitar nombre y apellido
--nombre se pasa a username
