<%-- 
    Document   : updateAdmin
    Created on : 08-25-2020, 09:42:16 PM
    Author     : VictoriaZepeda
--%>


<%@page import="freyawebapp.objects.AdminObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Administrador</title>
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
    AdminObject adminobject = (AdminObject) 
            request.getSession().getAttribute("adminobject");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Update Administrador</h1>
        <br><br>
        
        <form action="AdminServlet" method="post" style="color:#000000">
            Nombre<br>
            <input type="text" id="name" name="name" value="<%= adminobject.getName() %>"/>
            <br><br>
            Apellido:<br>
            <input type="text" id="lastName" name="lastName" value="<%= adminobject.getLastname() %>"/>
            <br><br>
            Email:<br>
            <input type="text" id="email" name="numeroTelefono" value="<%= adminobject.getEmail() %>"/>
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="idadmin" value="<%= adminobject.getId() %>" />
        </form>
    </body>
</html>
