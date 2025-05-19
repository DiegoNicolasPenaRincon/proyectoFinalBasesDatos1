INSERT INTO Cajero (nombre, telefono, correo, documentoEntidad, salario, contrasena)
VALUES 
('Laura Gómez', '3134567890', 'laura.gomez@email.com', 2001, 2500000, 'clave123'),
('David Mejía', '3148765432', 'david.mejia@email.com', 2002, 2600000, 'segura456');

INSERT INTO Cliente (nombre, telefono, correo, documentoEntidad)
VALUES 
('Ana Torres', '3111234567', 'ana.torres@email.com', 1001),
('Carlos Ruiz', '3129876543', 'carlos.ruiz@email.com', 1002);

INSERT INTO Factura (fechaPago, codigo, total, documentoEntidadCajero, documentoEntidadCliente, tipo)
VALUES 
('2025-05-01 10:00:00', 3001, 50000.0, 2001, 1001, 'venta'),
('2025-05-05 14:30:00', 3002, 75000.0, 2002, 1002, 'venta');

INSERT INTO CategoriaProducto (iva, utilidad, nombre)
VALUES 
(0.19, 0.3, 'Aseo'),
(0.05, 0.2, 'Alimentos');

INSERT INTO Producto (categoria, nombre, codigo, undidadesDisponibles)
VALUES 
('Aseo', 'Jabón Líquido', 4001, 100),
('Alimentos', 'Arroz 1kg', 4002, 50);

INSERT INTO Inventario (codigo, codigoProducto, unidadesAdquiridas, unidadesvendidas)
VALUES 
(5001, 4001, 150, 50),
(5002, 4002, 100, 50);

INSERT INTO Administrador (nombre, telefono, correo, documentoEntidad, salario, contrasena)
VALUES 
('Marcela Pérez', '3150001122', 'marcela.perez@email.com', 6001, 3500000, 'adminpass'),
('José Castillo', '3161112233', 'jose.castillo@email.com', 6002, 3600000, 'claveadmin');

INSERT INTO Proveedor (nombre, telefono, codigo, direccion)
VALUES 
('Distribuciones ABC', '3172223344', 7001, 'Calle 10 #45-20'),
('Comercializadora XYZ', '3183334455', 7002, 'Carrera 7 #80-15');

INSERT INTO Pedido (codigo, codigoAdministrador)
VALUES 
(8001, 6001),
(8002, 6002);

INSERT INTO Modificacion (codigoAdmin, codigoInventario, fechaModificacion, codigoInstancia)
VALUES 
(6001, 5001, '2025-05-10 09:00:00', 9001),
(6002, 5002, '2025-05-12 11:30:00', 9002);

INSERT INTO Factura_Producto (codigoFactura, codigoProducto, cantidadProducto)
VALUES 
(3001, 4001, 2),
(3002, 4002, 3);

INSERT INTO Proveedor_Producto (codigoProveedor, codigoProducto)
VALUES 
(7001, 4001),
(7002, 4002);

INSERT INTO Inventario_Proveedor (codigoProveedor, codigoInventario)
VALUES 
(7001, 5001),
(7002, 5002);

INSERT INTO Pedido_Producto (codigoPedido, codigoProducto, cantidadAdquirida)
VALUES 
(8001, 4001, 30),
(8002, 4002, 40);
