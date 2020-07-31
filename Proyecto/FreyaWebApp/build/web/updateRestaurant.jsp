<%-- 
    Document   : updateClient
    Created on : Jul 27, 2020, 3:03:32 PM
    Author     : Diego Portillo
--%>

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
    ClientObject clientobject = (ClientObject) 
            request.getSession().getAttribute("clientobject");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Update Client</h1>
        <br><br>
        
        <form action="ClienteServlet" method="post" style="color:#000000">
            Name:<br>
            <input type="text" id="name" name="name" value="<%= clientobject.getName() %>"/>
            <br><br>
            Last name:<br>
            <input type="text" id="lastname" name="lastname" value="<%= clientobject.getLastname() %>"/>
            <br><br>
            Phone number:<br>
            <input type="text" id="phoneNumber" name="numeroTelefono" value="<%= clientobject.getNumeroTelefono() %>"/>
            <br><br>
            Email:<br>
            <input type="text" id="email" name="email" value="<%= clientobject.getEmail() %>"/>
            <br><br>
            Password:<br>
            <input type="password" id="password" name="password" value="<%= clientobject.getPassword() %>"/>
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= clientobject.getId() %>" />
        </form>
    </body>
</html>
