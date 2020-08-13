/*Views para freya2*/
USE freya2;
-----------------------------
/*		View 1				*/
-----------------------------
CREATE VIEW `reservas_view` as
select d.idreserva, a.apellido as lastname,
	   a.nombre as name, a.numeroTelefono as phoneNumber, 
	   b.idmesas as tableID, d.horaReserva
from cliente a, mesas b, reservas d
where d.idCliente = a.idcliente and
	  d.idMesa = b.idmesas;

-----------------------------
/*		View 2				*/
-----------------------------
CREATE VIEW `pedidos_view` as
select c.idpedido as pedidoID, a.apellido as lastname, 
	   a.nombre as name, b.nombrePlatillo as nombrePlatillo
from cliente a, platillos b, pedidos c
where c.idCliente = a.idcliente and
	  c.idPlato = b.idplatillos;

-----------------------------
/*		View 3				*/
-----------------------------
/*
CREATE VIEW `facturacomplete` as
select d.idfactura as idFactura, b.nombre as Restaurante, 
	   c.localizacion as Ubicacion, a.nombre as name, a.apellido as lastName,
       d.fecha as Date, d.hora as Time, d.IVA as IVA, d.fastpass as fastPass,
       d.total as Total
from cliente a, restaurante b, direccionesrestaurante c, factura d
where d.idCliente = a.idcliente and
	  d.idRestaurante = b.idRestaurante and
      d.idDireccion = c.idDireccion;
*/
/*
use freya1;

CREATE VIEW `detalleFactura` as
select e.iddetalle_factura as reference, d.idFactura, d.Restaurante, 
	   d.Ubicacion, d.name, d.lastName,d.Date, d.Time, d.IVA, d.fastPass,
       c.nombrePlatillo, d.total as Total
from platillos c, facturacomplete d, detalle_factura e, cliente_platillo f, platillos g
where e.idFactura = d.idFactura and
	  e.idClientePlatillo = f.idcliente_platillo and
      f.idPlato = g.idPlatillos;
*/