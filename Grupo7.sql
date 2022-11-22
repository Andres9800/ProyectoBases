-- Proyecto Administracion de Bases de Datos
-- II Ciclo - 2022
-- Autores:
-- Andres Rojas Rojas
-- Joaquin Barrientos
-- Wendy Largaespada
-- Andres Cordero

alter session set "_ORACLE_SCRIPT"=true;

/**************************** SECCION DE DROPS *******************************/
PROMPT === DROPS DE TABLAS ===
DROP TABLE usuario CASCADE CONSTRAINTS;
DROP TABLE producto CASCADE CONSTRAINTS;
DROP TABLE factura CASCADE CONSTRAINTS;
DROP TABLE detalle CASCADE CONSTRAINTS;


DROP TABLE tabla_maestra_auditoria CASCADE CONSTRAINTS;
DROP TABLE registroUsuario CASCADE CONSTRAINTS;

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

create table registroUsuario(
cedula int not null,
username varchar(45) not null,
constraint FK_cedula_RU foreign key (cedula) references usuario (cedula)
);

/****** SECCION DE CREACION DE TRIGGERS ****/
PROMPT == CREACION DE TRIGGERS ==
create or replace trigger audita_dml_producto
    after insert or update or delete
    on producto
    for each row
declare
vuser varchar(30);
begin
select max(username) into vuser from registroUsuario where rowid = (select max(rowid) from registroUsuario);
if inserting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:new.codigo,'producto insertado',sysdate,vuser, 'producto');
end if;
if updating then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.codigo,'producto modificado',sysdate,vuser, 'producto');
end if;
if deleting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.codigo,'producto borrado',sysdate,vuser, 'producto');
end if;
end audita_dml_producto;
/



create or replace trigger audita_dml_factura
    after insert or update or delete
    on factura
    for each row
declare
vuser varchar(30);
begin
select max(username) into vuser from registroUsuario where rowid = (select max(rowid) from registroUsuario);
if inserting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:new.idfactura,'factura insertada',sysdate,vuser, 'factura');
end if;
if updating then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idfactura,'facutra modificada',sysdate,vuser, 'factura');
end if;
if deleting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idfactura,'factura borrada',sysdate,vuser, 'factura');
end if;
end audita_dml_factura;
/

create or replace trigger audita_dml_detalle
    after insert or update or delete
    on detalle
    for each row
declare
vuser varchar(30);
begin
select max(username) into vuser from registroUsuario where rowid = (select max(rowid) from registroUsuario);
if inserting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:new.idDetalle,'detalle de venta insertado',sysdate,vuser, 'detalle');
end if;
if updating then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idDetalle,'detalle de venta modificado',sysdate,vuser, 'detalle');
end if;
if deleting then
    insert into tabla_maestra_auditoria(codigo,accion,fecha,usuario, tabla_afectada)
    values (:old.idDetalle,'detalle de venta borrado',sysdate,vuser, 'detalle');
end if;
end audita_dml_detalle;
/






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
show error

call updateProducto('hola',10,10,'Personal',10,'1234');

commit;

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


/********* Lista de movimientos DETALLES ******************/-----------------------------------------------------------------------------------------------------------USAR PERO PARA LAS VISTAS

create or replace function listarAuditProductos
return Types.ref_cursor
as
    solicitud_cursor_mov Types.ref_cursor;
begin
    open solicitud_cursor_mov for
    select * from auditoria_producto;
    return solicitud_cursor_mov;
end;
/

create or replace function listarAuditFacturas
return Types.ref_cursor
as
    solicitud_cursor_mov Types.ref_cursor;
begin
    open solicitud_cursor_mov for
    select * from auditoria_factura;
    return solicitud_cursor_mov;
end;
/

create or replace function listarAuditDetalles
return Types.ref_cursor
as
    solicitud_cursor_mov Types.ref_cursor;
begin
    open solicitud_cursor_mov for
    select * from auditoria_datalle;
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






CREATE OR REPLACE PROCEDURE producto_resta_cantidad (prod producto.codigo%type, cant producto.cantidad%type) 
AS
    v_old_cant int;
    err1 exception;
BEGIN
    select cantidad into v_old_cant from producto where codigo=prod;
    if((v_old_cant - cant)>-1) then
        UPDATE producto set cantidad=(v_old_cant - cant) where codigo=prod;
        commit;
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
show error
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
            insert into detalle(idfacturaF,cantidadProducto,pesoProducto,subTotal,total,codigo) values (IDf,cant,pess,(pess*v_valor),(pess*v_valor),prod);
            commit;
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
show error



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



Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1234',8912,378424715,'lechuga',750.6,400.2,15,'Fresco');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1235',1094,378424715,'Arroz',100,325.2,60,'Abarrote');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1236',4141,378424715,'Frijojes',100,325.2,55,'Abarrote');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('1237',4165,154848115,'leche',7050,0,30,'Fresco');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('6060',5478,514884544,'Atun',10,0,10,'Abarrote');
Insert into SYSTEM.PRODUCTO (CODIGO,PLU,EAN,DESCRIPCION,PRECIO,PESO,CANTIDAD,AREA) values ('8080',4110,216451874,'TioPelon',110,1,20,'Mercancia');


commit;


