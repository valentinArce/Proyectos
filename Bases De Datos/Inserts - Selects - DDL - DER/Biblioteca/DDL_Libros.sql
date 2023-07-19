/* DDL de Creacion de Tablas */
CREATE DATABASE Libros

USE Libros
GO

CREATE TABLE LIBRO (NRO_LIBRO int not null, 
                     TITULO char(40),
                     AUTOR char(30),
                     TIPO char(2),
                     PRECIO_ORI smallmoney,
                     PRECIO_ACT smallmoney, 
                     EDICION smallint,
					 ESTADO char(1))
--
CREATE TABLE TIPOLIBRO (TIPO char(2) not null,
			DESCTIPO char(40))
--
CREATE TABLE LECTOR (NRO_LECTOR int,
                     NOMBRE char(22),
                     DIRECCION char(30),
                     TRABAJO char(10),
                     SALARIO smallmoney,
					 ESTADO char(1))
--
CREATE TABLE COPIAS (NRO_LIBRO int,
                       NRO_COPIA smallint,
					   ESTADO char(1)
                       )
--
CREATE TABLE PRESTAMO (NRO_LECTOR int,
                       NRO_LIBRO int,
                       NRO_COPIA smallint,
                       F_PREST datetime,
                       F_DEVOL datetime)

