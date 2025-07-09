use floresteria_encanto;
create table usuarios(
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,-- ID de la categoría (clave primaria)
  nombre_usuario VARCHAR(255) NOT NULL,
  apellido_usuario VARCHAR(50),
  correo VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL, -- aquí va el hash de la contraseña
  tipo_usuario ENUM('admin', 'cliente') DEFAULT 'cliente',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- Fecha de creación
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Fecha de actualización,
);

create table categoria_articulos(
  id_categoria_producto int primary key,
  nombre_categoria varchar(100) not null
);
show databases;

create table productos(
  id_producto int auto_increment primary key,
  nombre_producto varchar(255) not null,
  descripcion text,
  precio decimal(10,2) not null,
  stock int not null,
  categoria_producto int,
  foreign key (categoria_producto) references categoria_articulos(id_categoria_producto)
);

create table imagenes(
  id_imagen int auto_increment primary key,
  url varchar(255),
  id_producto int,
  foreign key (id_producto) references productos(id_producto)
);

create table carrito(
  id_carrito int auto_increment primary key,
  cantidad int not null,
  subtotal decimal(10,2) not null,
  fecha_creacion timestamp default current_timestamp,
  id_producto int,
  foreign key (id_producto) references productos(id_producto)
);

create table detalle_carrito(
  id_detalle_carrito int auto_increment primary key,
  cantidad int,
  subtotal decimal(10,2),
  id_carrito int,
  id_producto int,
  foreign key (id_carrito) references carrito(id_carrito),
  foreign key (id_producto) references productos(id_producto)
);

create table facturacion(
  numero_factura int auto_increment primary key,
  fecha_de_factura_hora timestamp default current_timestamp,
  subtotal decimal(10,2),
  iva decimal(10,2),
  total decimal(10,2),
  id_carrito int,
  id_usuario int,
  foreign key (id_carrito) references carrito(id_carrito),
  foreign key (id_usuario) references usuarios(id_usuario)
);
create table entrega_pedido(
  id_entrega int auto_increment primary key,
  fk_numero_factura int,
  direccion varchar(255),
  ciudad varchar(100),
  departamento varchar(100),
  numero_factura int,
  foreign key (numero_factura) references facturacion(numero_factura)
);

create table comentarios_articulo(
  id_comentario int auto_increment primary key,
  comentario text,
  fecha_comentario timestamp default current_timestamp,
  calificacion int, -- opcional
  numero_factura int,
  id_usuario int,
  foreign key (numero_factura) references facturacion(numero_factura),
  foreign key (id_usuario) references usuarios(id_usuario)
);



insert into usuarios(id_usuario,nombre_usuario,apellido_usuario,correo,password,tipo_usuario) values ('1','Wilson','Delgado','wilsondelgadomoreno@gmail.com',1102717619,'cliente');

select * from usuarios where correo = 'wilsondelgadomoreno@gmail.com' and password = 1102717619;


