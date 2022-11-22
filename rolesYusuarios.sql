-- Autores
-- Andres Rojas Rojas
-- Joaquin Barrientos
-- Wendy Largaespada
-- Andres Cordero
alter session set "_ORACLE_SCRIPT"=true;


PROMPT BORRAMOS USUARIOS

drop user cajero1 cascade;
drop user cajero2 cascade;
drop user cajero3 cascade;
drop user gerenteAbarrotes cascade;
drop user gerenteCuidadoPersonal cascade;
drop user gerenteMercancias cascade;
drop user gerenteFrescos cascade;
drop user gerenteGeneral1 cascade;
drop user gerenteGeneral2 cascade;
drop user ingeniero1 cascade;
drop user ingeniero2 cascade;

PROMPT BORRAMOS ROLES
drop role cajeros;
drop role gerentes;
drop role gerentesGenerales;
drop role ingenieros;

PROMPT CREAMOS ROLES

CREATE ROLE cajeros;
CREATE ROLE gerentes;
CREATE ROLE gerentesGenerales;
CREATE ROLE ingenieros;


PROMPT DAMOS PRIVILEGIOS A LOS  ROLES


PROMPT PRIVILEGIOS PARA CAJERO
grant insert on ventas to cajeros;
grant insert on facturas to cajeros;
grant update(cantidad) on productos to cajeros;

PROMPT PRIVILEGIOS PARA gerentes
GRANT SELECT on productos to gerentes;

PROMPT PRIVILEGIOS PARA gerentesGenerales
GRANT SELECT, UPDATE, INSERT, DELETE on productos to gerentesGenerales;

PROMPT PRIVILEGIOS PARA ingenieros
GRANT dba to ingenieros;


PROMPT CREAMOS USUARIOS
create user cajero1 identified by cajeros;
create user cajero2 identified by cajeros;
create user cajero3 identified by cajeros;

create user gerenteAbarrotes identified by gerentes;
create user gerenteCuidadoPersonal identified by gerentes;
create user gerenteMercancias identified by gerentes;
create user gerenteFrescos identified by gerentes;

create user gerenteGeneral1 identified by gerentesG;
create user gerenteGeneral2 identified by gerentesG;

create user ingeniero1 identified by ingenieros;
create user ingeniero2 identified by ingenieros;

PROMPT ASIGNAMOS QUOTAS A USUARIOS
ALTER USER cajero1 QUOTA 10m ON users;
ALTER USER cajero2 QUOTA 10m ON users;
ALTER USER cajero3 QUOTA 10m ON users;
ALTER USER gerenteAbarrotes QUOTA 10m ON users;
ALTER USER gerenteCuidadoPersonal QUOTA 10m ON users;
ALTER USER gerenteMercancias QUOTA 10m ON users;
ALTER USER gerenteFrescos QUOTA 10m ON users;
ALTER USER gerenteGeneral1 QUOTA 10m ON users;
ALTER USER gerenteGeneral2 QUOTA 10m ON users;
ALTER USER ingeniero1 QUOTA 10m ON users;
ALTER USER ingeniero2 QUOTA 10m ON users;

PROMPT ASIGNAMOS PERMISOS DE CONECCION A USUARIOS

grant connect to cajero1;
grant connect to cajero2;
grant connect to cajero3;
grant connect to gerenteAbarrotes;
grant connect to gerenteCuidadoPersonal;
grant connect to gerenteMercancias;
grant connect to gerenteFrescos;
grant connect to gerenteGeneral1;
grant connect to gerenteGeneral2;
grant connect to ingeniero1;
grant connect to ingeniero2;



PROMPT ASIGNAMOS ROLES A USUARIOS

GRANT cajeros TO cajero1;
GRANT cajeros TO cajero2;
GRANT cajeros TO cajero3;
GRANT gerentes TO gerenteAbarrotes;
GRANT gerentes TO gerenteCuidadoPersonal;
GRANT gerentes TO gerenteMercancias;
GRANT gerentes TO gerenteFrescos;
GRANT gerentesGenerales TO gerenteGeneral1;
GRANT gerentesGenerales TO gerenteGeneral2;
GRANT ingenieros TO ingeniero1;
GRANT ingenieros TO ingeniero2;