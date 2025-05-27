SELECT f.FechaPago,f.codigo,f.documentoEntidadCliente,c.nombre,c.telefono,f.total FROM Factura f
	   JOIN Cliente c ON c.documentoEntidad=f.documentoEntidadCliente
	   WHERE f.documentoEntidadCliente=1001
	   GROUP BY 
	    f.FechaPago,
		f.codigo,
		f.documentoEntidadCliente,
		c.nombre,
		c.telefono,
		f.total;

