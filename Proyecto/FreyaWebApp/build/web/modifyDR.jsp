<%-- 
    Document   : modifyDR
    Created on : 07-29-2020, 04:23:25 PM
    Author     : VictoriaZepeda
--%>

<%@page import="freyawebapp.objects.DRObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Direcciones Restaurante Main</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            p{
                color: #000000;
            }
        </style>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<DRObject> array = (ArrayList<DRObject>)
                request.getSession().getAttribute("dRArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Direcciones Restaurante Main</h1>
        <br><br>
        
        <a href="newDR.html" style="font-size: 1.5em">New Direccion Restaurante</a>
        <br><br>
    <%
    if (rows>0){
        
    %>
    <p><%= rows %> affected</p>
    <%
    }
    %>
        
            <table style="width:45%" border="1">
                <tr>
                    <th>Localizacion</th>
                    <th>Codigo Postal</th>
                    <th>Numero de Telefono</th>
                    <th colspan="2">Acciones</th>
                </tr>
                <%
                    Iterator<DRObject> iteArray = null;
                    if(array!=null){
                        iteArray = array.iterator();
                        DRObject temp = null;
                        while (iteArray.hasNext()){
                            temp = iteArray.next();
                %>
                <tr>
                    <td><%= temp.getLocalizacion() %></td>
                    <td><%= temp.getCodigoPostal() %></td>
                    <td><%= temp.getNumeroTelefono() %></td>
                    <td><a href="DRServlet?formid=4&id=<%= temp.getIdDireccion() %>">Update</a></td>
                    <td><a href="DRServlet?formid=2&id=<%= temp.getIdDireccion() %>">Delete</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            <br>
            <a href="RestauranteServlet?formid=3" style="font-size: 1.25em">Volver</a>
            
    </body>
</html>
