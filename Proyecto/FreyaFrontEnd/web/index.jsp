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
        <title>Login</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            a{
                color:#191970;
                font-weight: bold;
                font-size: 25px;
            }
            p{
                color: #000080;
                font-size: 20px;
            }
        </style>
    </head>
    <body bgcolor="#FFDAB9">
        <h1>Login</h1>
        <br><br>
        <form action="ClientServletFE" method="post" style="align">
            Email:<br>
            <input type="email" id="email" name="email" />
            <br><br>
            Password:<br>
            <input type="password" id="password" name="password" />
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="1" />
        </form>
        
    </body>
</html>
