<%-- 
    Document   : clientMain
    Created on : Jul 26, 2020, 5:14:31 PM
    Author     : Diego Portillo
--%>

<%@page import="freyawebapp.objects.RestaurantObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurante Main</title>
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
        ArrayList<RestaurantObject> array = (ArrayList<RestaurantObject>)
                request.getSession().getAttribute("restaurantArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Restaurant Main</h1>
        <br><br>
        
        <a href="newRestaurant.html" style="font-size: 1.5em">New Restaurante</a>
        <br><br>
        <a href="DRServlet?formid=6" style="font-size: 1.5em">Modificar Direcciones Restaurante</a>
        <br><br>
        <a href="MesasServlet?formid=6" style="font-size: 1.5em">Modificar Mesas</a>
        <br><br>
        <a href="PlatilloServlet?formid=6" style="font-size: 1.5em">Modificar Platillos</a>
        <br><br>
        <a href="ReservaServlet?formid=3" style="font-size: 1.5em">Ver reservas</a>
        <br><br>
        <a href="clienteplatilloMain.jsp" style="font-size: 1.5em">Ver pedidos</a>
        <br><br>
        <a href="facturacomplete.jsp" style="font-size: 1.5em">Ver Facturas</a>
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
                    <th>Name</th>
                    <th>Opens at</th>
                    <th>Closes at</th>
                    <th>Email Address</th>
                    <th colspan="2">Acciones</th>
                </tr>
                <%
                    Iterator<RestaurantObject> iteArray = null;
                    if(array!=null){
                        iteArray = array.iterator();
                        RestaurantObject temp = null;
                        while (iteArray.hasNext()){
                            temp = iteArray.next();
                %>
                <tr>
                    <td><%= temp.getName() %></td>
                    <td style="text-align: center"><%= temp.getOpens() %></td>
                    <td style="text-align: center"><%= temp.getCloses() %></td>
                    <td><%= temp.getEmail() %></td>
                    <td><a href="RestauranteServlet?formid=4&id=<%= temp.getId() %>">Update</a></td>
                    <td><a href="RestauranteServlet?formid=2&id=<%= temp.getId() %>">Delete</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            <br><Br>
            <a href="index_admin.html" style="font-size: 1.25em">Volver al inicio</a>
    </body>
</html>
