<%-- 
    Document   : MesasRestaurante
    Created on : 07-28-2020, 11:24:33 PM
    Author     : accom
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.MesaObjects"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Registro de mesas </title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            
        </style>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"

    </head>
    <%
    int rows = (int)request.getSession().getAttribute("rows");
    ArrayList<MesaObjects> array = (ArrayList<MesaObjects>)
                request.getSession().getAttribute("mesasArray"); 
    %>
    <body bgcolor="#FFDAB9">
                <h1>New Mesas</h1>
        <br><br>
        
        <a href="Mesas.html" style="font-size: 1.5em">New Mesas</a>
        <br><br>
        <%
        if (rows>0){
            
        %>
        <p style="color:red;"><%= rows %> affected</p>
            <br>
        <%
            }
        %>
            <table style="width:40%" border="1">
                <tr>
                    <th style="text-align: center">Número de mesa</th>
                    <th>Tipo</th>
                    <th>Estado</th>
                    <th>Cantidad</th>
                    <th colspan="2">Acciones</th>
                </tr>
                <%
                    Iterator<MesaObjects> iteArray = null;
                    if(array!=null){
                        iteArray = array.iterator();
                        MesaObjects temp = null;
                        while (iteArray.hasNext()){
                            temp = iteArray.next();
                %>
                <tr>
                    <td style="text-align: center"><%= temp.getId() %></td>
                    <td><%= temp.getEstado() %></td>
                    <td><%= temp.getTipo() %></td>
                    <td style="text-align: center"><%= temp.getCantidad() %></td>
                    <td><a href="MesasServlet?formid=4&id=<%= temp.getId() %>">Update</a></td>
                    <td><a href="MesasServlet?formid=2&id=<%= temp.getId() %>">Delete</a></td>
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
