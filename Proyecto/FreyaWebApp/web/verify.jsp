<%-- 
    Document   : verify
    Created on : Aug 26, 2020, 1:03:38 PM
    Author     : Diego Portillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify your identity</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            a{
                color:#191970;
                font-weight: bold;
                font-size: 20px;
            }
            p{
                color: black;
                font-weight: bold;
                font-size: 25px;
            }
        </style>
    </head>
    <body bgcolor="#FFDAB9">
        <h1>Verify your identity</h1>
        <%
        String mensaje = (String)request.getSession().getAttribute("mensaje2");
        //if (!(mensaje.equals(null))){
        %>
        <p style="color:darkred"><%= mensaje %></p>
        <%
       // }
        %>
        <br><br>
        <form action="AdminServlet" method="post" style="color:#000000">
            Name:<br>
            <input type="text" id="name" name="name" required/>
            <br><br>
            Password:<br>
            <input type="password" id="password" name="password" required/>
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="7" />
        </form>
    </body>
</html>
