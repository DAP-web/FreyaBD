<%-- 
    Document   : index_admin
    Created on : Aug 16, 2020, 2:26:30 PM
    Author     : Diego Portillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Freya</title>
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
        
        <h1>Freya BD website for Administrators</h1>
        <br><br>
        <%
        String login = (String)request.getSession().getAttribute("LoginName");
        if (!(login.equals(null))) {
        %>
        <footer>
            <p>Welcome <%= login %><br>
            <a href="adminlogin.jsp">Log out</a></p>
        </footer>
        
        <%
        }
        %>
        
        <br>
        <a href="ClienteServlet?formid=3">Go to client</a>
        <br><br>
        <a href="RestauranteServlet?formid=3">Go to restaurant</a>
        <br><br><br>

        
    </body>
</html>
