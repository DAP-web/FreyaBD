<%-- 
    Document   : facturacomplete
    Created on : Jul 31, 2020, 1:41:20 AM
    Author     : Diego Portillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Facturas</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            p{
                color: #000000;
                font-size: 20px;
            }
            h3{
                color: #000080;
                text-align:center;
                font-size: 20px;
            }
        </style>
    </head>
    <body bgcolor="#FFDAB9">
        <h1>Registro de Facturas</h1>
        <h3>Facturas de todos los clientes y pedidos</h3>
        <p>Aquí irá una view que permita ver y modificar 
            las facturas de cada cliente que ordene</p>
        <br><br>
        <a href="RestauranteServlet?formid=3" style="font-size: 1.25em">Volver</a>
    </body>
</html>