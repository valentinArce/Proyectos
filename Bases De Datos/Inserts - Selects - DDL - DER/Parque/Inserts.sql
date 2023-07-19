--Inserts
INSERT INTO Cuidador  (DniCuidador,Apellido,Nombre)
VALUES
('20000000','Miño', 'Guillermo'),
('25000000','Peretti','Ignacio')

--INSERT INTO Parque (NroParque,Nombre,Direccion,DniCuidador)
--VALUES
--(1,'SUR','Calle 1 entre 2 y 4','22222222')
INSERT INTO Parque (NroParque,Nombre,Direccion,DniCuidador)
VALUES
(1,'SUR','Calle 1 entre 2 y 4','20000000')
INSERT INTO Parque (NroParque,Nombre,Direccion,DniCuidador)
VALUES
(2,'ESTE','Calle 2 entre 7 y 9','20000000')
INSERT INTO Parque (NroParque,Nombre,Direccion,DniCuidador)
VALUES
(3,'OESTE','Calle 8 entre 2 y 4','25000000')
INSERT INTO Parque (NroParque,Nombre,Direccion,DniCuidador)
VALUES
(4,'NORTE','Calle 9  entre 8 y 10','25000000')
INSERT INTO Parque (NroParque,Nombre,Direccion,DniCuidador)
VALUES
(5,'CENTRAL','Calle 6 entre 5 y 7','20000000')

INSERT INTO Estacion (CodEstacion,Nombre,MesDesde,MesHasta) 
VALUES
('PRI','Primavera',10,12),
('VER','Verano',1,3),
('OTO','Otoño',4,6),
('INV','Invierno',7,9)

INSERT INTO TelefonoCuidador (DniCuidador,Telefono)
VALUES
('20000000',115666999),
('20000000',48898871),
('25000000',69998771)

INSERT INTO ARBOL (CodArbol,Nombre,CodEstacionFlora,CodEstacionPoda,CostoMantenimiento)
values('LAR','Lapacho Rojo','PRI','INV',12000),
('PAL','Palo Borracho','VER','INV',5000),
('JAC','Jacaranda','PRI','OTO',8500),
('CIP','Cipres','OTO','PRI',20000)

INSERT INTO ArbolParque (NroParque,CodArbol,Cantidad)
VALUES 
(1,'LAR',3),
(1,'PAL',5),
(1,'CIP',1),
(1,'JAC',4),
(2,'LAR',4),
(2,'PAL',2),
(2,'JAC',1),
(3,'LAR',6),
(3,'CIP',3),
(3,'JAC',1),
(4,'LAR',4),
(4,'PAL',4),
(4,'CIP',2),
(4,'JAC',4),
(5,'LAR',8),
(5,'PAL',6),
(5,'CIP',1),
(5,'JAC',5)








