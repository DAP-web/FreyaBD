<%-- 
    Document   : index
    Created on : Aug 12, 2020, 6:56:04 PM
    Author     : Diego Portillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Clients</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            a{
                color:#191970;
                font-weight: bold;
                font-size: 15px;
            }
            p{
                color: #8B0000;
                font-size: 20px;
            }
        </style>
    </head>
    <body bgcolor="#FFDAB9">
        <h1>Login for Clients</h1>
        <br>
        <%
            
        String message = (String)request.getSession().getAttribute("message");
        
        if(message != null){
        
        %>
        <p><%= message %></p> 
        <%
        }
        %>
        <br>
        <form action="UsernameServlet" method="post">
            Email:<br>
            <input type="email" id="email" name="email" required/>
            <br><br>
            Password:<br>
            <input type="password" id="password" name="password" required/>
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="1" />
        </form>
        <br>
        Don't have an account yet? <a href="newClient1.html">Sign up here</a>
        <br>
        Are you an administrator? <a href="adminlogin.jsp">Log in here</a>
        <br><br>
        <a href="index_admin.html">Go to admin</a>
    </body>
</html>
