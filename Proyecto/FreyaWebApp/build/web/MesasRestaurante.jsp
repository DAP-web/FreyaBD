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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de mesas </title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            
        </style>
    </head>
    <%
    int rows = (int)request.getSession().getAttribute("rows");
    ArrayList<MesaObjects> array = (ArrayList<MesaObjects>)
                request.getSession().getAttribute("mesasArray"); 
    %>
    <body bgcolor="#FFDAB9">
                <h1>New Mesas </h1>
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
                    <th>Tipo</th>
                    <th>Estado</th>
                    <th>Cantidad</th>
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
                    <td><%= temp.getEstado() %></td>
                    <td><%= temp.getTipo() %></td>
                    <td><%= temp.getCantidad() %></td>
                    <td><a href="MesasServlet?formid=2&id=<%= temp.getId() %>">Update</a></td>
                    <td><a href="MesasServlet?formid=2&id=<%= temp.getId() %>">Delete</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>

    </body>
</html>
