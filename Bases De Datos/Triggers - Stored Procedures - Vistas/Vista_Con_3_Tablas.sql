USE  TP_BD2

CREATE VIEW Clientes_Con_Ventas AS

SELECT
	c.DNI,
	c.NOMBRE,
	c.APELLIDO,
	c.DIRECCION,
	c.TELEFONO,
	v.NROfactura,
	v.CANTIDAD,
	v.PRECIO,
	p.PRODUCTO,
	p.DESCRIPCION
FROM Cliente c
INNER JOIN Venta v ON
c.DNI = v.DNIcliente
INNER JOIN Producto p ON
v.IDproducto = p.IDproducto


SELECT * FROM Clientes_Con_Ventas