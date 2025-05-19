CREATE TABLE Cliente(nombre varchar(255),telefono varchar(10),correo varchar(255),
					 documentoEntidad INT PRIMARY KEY);

CREATE TABLE Cajero(nombre varchar(255),telefono varchar(10),correo varchar(255),
					documentoEntidad INT PRIMARY KEY,
					salario FLOAT,contrasena varchar(255));


CREATE TABLE Factura(fechaPago SmallDateTime,codigo INT PRIMARY KEY,total FLOAT,documentoEntidadCajero INT,documentoEntidadCliente INT,
					  FOREIGN KEY (documentoEntidadCajero) REFERENCES Cajero(documentoEntidad),
					  FOREIGN KEY (documentoEntidadCliente) REFERENCES Cliente(documentoEntidad),
					  tipo varchar(10));

CREATE TABLE CategoriaProducto(iva FLOAT,utilidad FLOAT,nombre varchar(255) PRIMARY KEY);


CREATE TABLE Producto(categoria varchar(255) FOREIGN KEY (categoria) REFERENCES CategoriaProducto(nombre),
					  nombre varchar(255),codigo INT PRIMARY KEY,undidadesDisponibles INT);

CREATE TABLE Inventario(codigo int primary key,codigoProducto int foreign key (codigoProducto) references Producto(codigo),
                        unidadesAdquiridas int,unidadesvendidas int);

CREATE TABLE Administrador(nombre varchar(255),telefono varchar(255),correo varchar(255),documentoEntidad int primary key,
							salario float,
						    contrasena varchar(255));

CREATE TABLE Proveedor(nombre varchar(255),telefono varchar(255),
					   codigo int primary key,direccion varchar(255));

CREATE TABLE Pedido(codigo int PRIMARY KEY,
			  codigoAdministrador int foreign key (codigoAdministrador) references Administrador(documentoEntidad));

CREATE TABLE Modificacion(codigoAdmin int foreign key(codigoAdmin) references Administrador(documentoEntidad),
						codigoInventario int foreign key (codigoInventario) references Inventario(codigo),
						fechaModificacion SmallDateTime,codigoInstancia int PRIMARY KEY);

CREATE TABLE Factura_Producto(codigoFactura int,
							codigoProducto int,
							cantidadProducto int,
							primary key(codigoFactura,codigoProducto),
							foreign key (codigoFactura) references Factura(codigo),
							foreign key (codigoProducto) references Producto(codigo));

CREATE TABLE Proveedor_Producto(codigoProveedor int,codigoProducto int,primary key(codigoProveedor,codigoProducto),
								foreign key (codigoProveedor) references Proveedor(codigo),
								foreign key (codigoProducto) references Producto(codigo));

CREATE TABLE Inventario_Proveedor(codigoProveedor int,
								  codigoInventario int,
								  primary key(codigoProveedor,codigoInventario),
								  foreign key (codigoProveedor) references Proveedor(codigo),
								  foreign key (codigoInventario) references Inventario(codigo));

CREATE TABLE Pedido_Producto(codigoPedido int,codigoProducto int,
							cantidadAdquirida int,primary key(codigoPedido,codigoProducto),
							foreign key (codigoPedido) references Pedido(codigo),
							foreign key (codigoProducto) references Producto(codigo));

