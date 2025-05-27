SELECT * FROM Producto;

SELECT p.codigo AS codigoProducto,p.nombre AS nombreProducto,p.categoria AS Categoria,p.valor AS ValorProducto, FROM Producto p
	   JOIN CategoriaProducto c ON p.categoria=c.nombre


