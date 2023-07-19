CREATE PROCEDURE ProductosConMismaCantidad
    @cantidad INT
AS
BEGIN
    SELECT IDproducto, PRECIO, NOMBRE, DESCRIPCION, MARCA
    FROM Producto
    WHERE STOCK = @cantidad;
END
