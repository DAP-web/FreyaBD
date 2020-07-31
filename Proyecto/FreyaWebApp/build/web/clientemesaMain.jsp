<%-- 
    Document   : clientemesaMain
    Created on : Jul 30, 2020, 2:16:58 PM
    Author     : Diego Portillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
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
        <h1>Reservas</h1>
        <h3>Cliente, mesa y hora de reserva</h3>
        <p>Aquí irá una view que permita ver y modificar las reservas de las mesas 
        que los clientes han hecho.</p>
        <br><br>
        <a href="RestauranteServlet?formid=3" style="font-size: 1.25em">Volver</a>
    </body>
</html>
