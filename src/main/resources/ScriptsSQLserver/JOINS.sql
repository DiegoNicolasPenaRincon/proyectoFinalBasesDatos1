/*SELECT f.FechaPago,f.codigo,f.documentoEntidadCliente,c.nombre,c.telefono,f.total FROM Factura f
	   JOIN Cliente c ON c.documentoEntidad=f.documentoEntidadCliente
	   WHERE f.documentoEntidadCajero=2001
	   GROUP BY 
	    f.FechaPago,
		f.codigo,
		f.documentoEntidadCliente,
		c.nombre,
		c.telefono,
		f.total;

SELECT p.nombre,p.codigo,p.categoria,prove.nombre,prove.codigo, prove.direccion,fo.cantidadProducto FROM Producto p
	   JOIN Proveedor_Producto pro ON pro.codigoProducto=p.codigo
	   JOIN Proveedor prove ON prove.codigo=pro.codigoProveedor
	   JOIN Factura_Producto fo ON fo.codigoProducto=p.codigo
	   JOIN Factura f ON f.codigo=fo.codigoFactura
	   WHERE f.codigo=3001

SELECT p.codigo AS codigoPedido, ad.documeFOntoEntidad AS codigoAdministrador,ad.nombre AS nombreAdmin,prove.codigo AS codigoProveedor,prove.nombre AS nombreProveedor,p.fechaPedido,
	   PP.codigoProducto
	   FROM Pedido p
	   JOIN Administrador ad ON ad.documentoEntidad=p.codigoAdministrador
	   JOIN Proveedor prove ON prove.codigo=p.codigoProveedor
	   JOIN Pedido_Producto PP ON PP.codigoPedido=p.codigo
	   WHERE PP.codigoProducto=?;


SELECT ad.nombre AS nombreAdmin,ad.documentoEntidad AS documentoIdentidadAdmin,modi.fechaModificacion,modi.codigoInstancia FROM Administrador ad
	   JOIN Modificacion modi ON modi.codigoAdmin=ad.documentoEntidad
	   WHERE modi.codigoInventario=6001



SELECT p.nombre AS nombreProducto, p.codigo AS codigoProducto, prov.nombre AS nombreProveedor,prov.codigo AS codigoProveedor,cate.nombre AS categoria,cate.iva,cate.utilidad 
	   FROM Producto p
	   JOIN CategoriaProducto cate ON cate.nombre=p.categoria
	   JOIN Proveedor_Producto prop ON prop.codigoProducto=p.codigo
	   JOIN Proveedor prov ON prov.codigo=prop.codigoProveedor
	
*/




