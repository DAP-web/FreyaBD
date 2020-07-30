<%-- 
    Document   : updateDR
    Created on : 07-29-2020, 03:49:30 AM
    Author     : VictoriaZepeda
--%>

<%@page import="freyawebapp.objects.DRObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Direccion Restaurante</title>
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
    DRObject drobject = (DRObject) 
            request.getSession().getAttribute("dRobject");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Update Direccion Restaurante</h1>
        <br><br>
        
        <form action="DRServlet" method="post" style="color:#000000">
            Localización:<br>
            <input type="text" id="localizacion" name="localizacion" value="<%= drobject.getLocalizacion() %>"/>
            <br><br>
            Codigo Postal:<br>
            <input type="text" id="codigoPostal" name="codigoPostal" value="<%= drobject.getCodigoPostal() %>"/>
            <br><br>
            Numero de Telefono:<br>
            <input type="text" id="numeroTelefono" name="numeroTelefono" value="<%= drobject.getNumeroTelefono() %>"/>
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="iddireccion" value="<%= drobject.getIdDireccion() %>" />
        </form>
    </body>
</html>
