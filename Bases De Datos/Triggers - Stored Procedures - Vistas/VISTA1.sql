create view stock_menor_limite AS

SELECT dbo.Producto.IDproducto, dbo.Producto.PRECIO, dbo.Producto.NOMBRE, dbo.Producto.DESCRIPCION, dbo.Producto.MARCA, dbo.Producto.STOCK
FROM dbo.Producto
WHERE dbo.Producto.STOCK <= 2