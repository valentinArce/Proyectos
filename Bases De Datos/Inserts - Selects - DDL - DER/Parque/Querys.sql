--PARTE 2
USE TP1_DB1
GO

--1)
SELECT Nombre,Direccion from Parque

--2)
SELECT * from Arbol WHERE CostoMantenimiento < 10000

--3)
SELECT * FROM Arbol WHERE CodEstacionPoda = 'OTO'

--4)
SELECT * FROM Arbol WHERE CodEstacionFlora = 'VER'

--5)
SELECT * FROM Arbol WHERE Nombre LIKE '%o%'

--6)
SELECT * FROM Arbol WHERE CodEstacionFlora = 'PRI' AND CodEstacionPoda = 'OTO'

--PARTE 3
USE TP1_DB1

--1)
SELECT
	P.Nombre,P.Direccion,C.Apellido
FROM 
	Parque P JOIN Cuidador C
	ON P.DniCuidador=C.DniCuidador

--2)
SELECT 
	P.Nombre,P.Direccion,SUM(A.Cantidad) Cantidad
FROM
	Parque P JOIN ArbolParque A
	ON P.NroParque=A.NroParque
	GROUP BY P.Nombre,P.Direccion

--3)
SELECT
	P.nombre,A.Nombre,SUM(AP.Cantidad) Cantidad
FROM
	Arbol A JOIN ArbolParque AP
	ON A.CodArbol=AP.CodArbol
	JOIN Parque P
	ON AP.NroParque=P.NroParque
	GROUP BY P.Nombre,A.Nombre

--4)
SELECT
	P.Nombre,SUM(AP.Cantidad*A.CostoMantenimiento) Costo
FROM
	Parque P JOIN ArbolParque AP
	ON P.NroParque=AP.NroParque
	JOIN Arbol A
	ON AP.CodArbol=A.CodArbol
	WHERE P.Nombre LIKE '%NORTE%'
	GROUP BY P.Nombre

--5)
SELECT
	P.Nombre,SUM(AP.Cantidad*A.CostoMantenimiento) Costo
FROM
	Parque P JOIN ArbolParque AP
	ON P.NroParque=AP.NroParque
	JOIN Arbol A
	ON AP.CodArbol=A.CodArbol
	GROUP BY P.Nombre
	ORDER BY Costo