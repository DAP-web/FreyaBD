<%-- 
    Document   : newjsp
    Created on : Jul 28, 2020, 11:22:49 PM
    Author     : Mario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.PlatillosObjects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente Main</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            
        </style>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<PlatillosObjects> array = (ArrayList<PlatillosObjects>)
                request.getSession().getAttribute("platillosArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Client Main</h1>
        <br><br>
        
        <a href="newClient.html" style="font-size: 1.5em">New Client</a>
        <br><br>
        <%
        if (rows>0){
            
        %>
        <p style="color:red;"><%= rows %> affected</p>
            <br>
        <%
            }
        %>
            <table style="width:40%" border="1">
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
                <%
                    Iterator<PlatillosObjects> iteArray = null;
                    if(array!=null){
                        iteArray = array.iterator();
                        PlatillosObjects temp = null;
                        while (iteArray.hasNext()){
                            temp = iteArray.next();
                %>
                <tr>
                    <td><%= temp.getName() %></td>
                    <td><%= temp.getPrice() %></td>
                    <td><%= temp.getDescription()%></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            
    </body>
</html>

