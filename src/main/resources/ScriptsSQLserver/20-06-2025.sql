/*SELECT * FROM Inventario;
SELECT * FROM Factura_Producto;
SELECT * FROM Inventario_Proveedor;
SELECT * FROM Producto;
SELECT * FROM Pedido_Producto;
SELECT * FROM Proveedor_Producto;
*/

SELECT * FROM Inventario;

SELECT * FROM Modificacion;

/*ALTER TABLE Producto
DD descatalogado BIT;

UPDATE Producto
	SET descatalogado=0;


UPDATE Producto
	SET descatalogado=0 WHERE codigo=?;

UPDATE Inventario 
	SET unidadesDisponibles=0, WHERE codigoProducto=?;


INSERT INTO Modificacion(codigoAdmin,codigoInventario,fechaModificacion,codigoInstancia,Descripcion)
		VALUES(?,?,?,?,?);

ALTER TABLE Producto DROP COLUMN descatalogado;
GO
		*/

