<%-- 
    Document   : updateClient
    Created on : Jul 27, 2020, 3:03:32 PM
    Author     : Diego Portillo
--%>

<%@page import="freyawebapp.objects.RestaurantObject"%>
<%@page import="freyawebapp.objects.ClientObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Client</title>
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
    RestaurantObject restaurantObject = (RestaurantObject) 
            request.getSession().getAttribute("restaurantObject");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Update Client</h1>
        <br><br>
        
        <form action="RestauranteServlet" method="post" style="color:#000000">
            Nombre restaurante:<br>
            <input type="text" id="name" name="name" value="<%= restaurantObject.getName() %>"/>
            <br><br>
            Hora de apertura:<br>
            <input type="time" id="horaapertura" name="horaapertura" value="<%= restaurantObject.getOpens() %>"/>
            <br><br>
            Hora de cierre:<br>
            <input type="time" id="horacierre" name="horacierre" value="<%= restaurantObject.getCloses() %>"/>
            <br><br>
            Email:<br>
            <input type="text" id="email" name="email" value="<%= restaurantObject.getEmail() %>"/>
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= restaurantObject.getId() %>" />
        </form>
    </body>
</html>
