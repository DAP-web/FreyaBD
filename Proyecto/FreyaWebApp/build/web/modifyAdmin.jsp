<%-- 
    Document   : modifyAdmin
    Created on : 08-25-2020, 09:42:53 PM
    Author     : VictoriaZepeda
--%>

<%@page import="freyawebapp.objects.AdminObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador Main</title>
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
        ArrayList<AdminObject> array = (ArrayList<AdminObject>)
                request.getSession().getAttribute("AdminArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Administrador Main</h1>
        <br><br>
        
        <a href="newAdmin.html" style="font-size: 1.5em">New Administrador</a>
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
                    Iterator<AdminObject> iteArray = null;
                    if(array!=null){
                        iteArray = array.iterator();
                        AdminObject temp = null;
                        while (iteArray.hasNext()){
                            temp = iteArray.next();
                %>
                <tr>
                    <td><%= temp.getName() %></td>
                    <td><%= temp.getLastname() %></td>
                    <td><%= temp.getEmail() %></td>
                    <td><a href="AdminServlet?formid=4&id=<%= temp.getId() %>">Update</a></td>
                    <td><a href="AdminServlet?formid=2&id=<%= temp.getId() %>">Delete</a></td>
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
