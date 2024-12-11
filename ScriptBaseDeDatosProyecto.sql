create database BaseDeDatos;
use BaseDeDatos;

create table Cajas (
nombre varchar(30) not null,
apellidos varchar(50) not null,
monto decimal not null,
fecha varchar (10));

select * from Cajas;
delete from Cajas;