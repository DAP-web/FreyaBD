<%-- 
    Document   : UpdateMesasRestaurante
    Created on : 07-30-2020, 06:39:35 PM
    Author     : accom
--%>

<%@page import="freyawebapp.objects.MesaObjects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Mesas</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            a{
                color:white;
                font-weight: bold;
                font-size: 25px;
            }
        </style>
    </head>
    <%
    MesaObjects mesaobjects = (MesaObjects) 
            request.getSession().getAttribute("mesaObjects");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Update Mesas</h1>
        <br><br>
        
        <form action="MesasServlet" method="post" style="color:#000000">
            Tipo:<br>
            <input type="text" id="tipo" name="tipo" value="<%= mesaobjects.getTipo() %>"/>
            <br><br>
            Estado:<br>
            <input type="text" id="estado" name="estado" value="<%= mesaobjects.getEstado() %>"/>
            <br><br>
            Cantidad:<br>
            <input type="text" id="cantidad" name="cantidad" value="<%= mesaobjects.getCantidad() %>"/>
            <br><br>
            
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= mesaobjects.getId() %>" />
        </form>
    </body>
</html>
