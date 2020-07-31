<%-- 
    Document   : UpdatePlatillo
    Created on : Jul 30, 2020, 4:07:53 PM
    Author     : Mario
--%>

<%@page import="freyawebapp.objects.PlatilloObject"%>
<%@page import="freyawebapp.objects.DRObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update platillo</title>
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
    PlatilloObject PlatilloObject = (PlatilloObject) 
            request.getSession().getAttribute("platillobject");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Update Platillo</h1>
        <br><br>
        
        <form action="PlatilloServlet" method="post" style="color:#000000">
            Name<br>
            <input type="text" id="nombre" name="nombre" value="<%= PlatilloObject.getName() %>"/>
            <br><br>
            Price:<br>
            <input type="text" id="name" name="price" value="<%= PlatilloObject.getPrice() %>"/>
            <br><br>
            Description:<br>
            <input type="text" id="description" name="description" value="<%= PlatilloObject.getDescription() %>"/>
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= PlatilloObject.getId() %>" />
        </form>
    </body>
</html>

