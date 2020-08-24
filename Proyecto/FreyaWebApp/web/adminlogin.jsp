<%-- 
    Document   : adminlogin
    Created on : Aug 13, 2020, 10:38:11 PM
    Author     : Diego Portillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrators Login</title>
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
        <h1>Login for Administrators</h1>
        <br>
        <%
            
        String message = (String)request.getSession().getAttribute("message1");
        
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
            <input type="hidden" name="formid" value="2" />
        </form>
        <br>
        Are you a new administrator? <a href="UsernameServlet?formid=3">Sign up here</a>
        <br>
        Not an administrator? <a href="index.jsp">Go back to client</a>
        <br>
    </body>
</html>
