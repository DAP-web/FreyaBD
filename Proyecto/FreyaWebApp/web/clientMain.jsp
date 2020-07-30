<%-- 
    Document   : clientMain
    Created on : Jul 26, 2020, 5:14:31 PM
    Author     : Diego Portillo
--%>

<%@page import="freyawebapp.objects.ClientObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
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
            p{
                color: #000000;
            }
        </style>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<ClientObject> array = (ArrayList<ClientObject>)
                request.getSession().getAttribute("clientArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Client Main</h1>
        <br><br>
        
        <a href="newClient.html" style="font-size: 1.5em">New Client</a>
        <br><br>
        <a href="DRServlet?formid=3" style="font-size: 1.5em">View Direcciones Restaurante</a>
        <br><br>
    <%
    if (rows>0){
        
    %>
    <p><%= rows %> affected</p>
    <%
    }
    %>
        
            <table style="width:45%" border="1">
                <tr>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Phone Number</th>
                    <th>Email Address</th>
                </tr>
                <%
                    Iterator<ClientObject> iteArray = null;
                    if(array!=null){
                        iteArray = array.iterator();
                        ClientObject temp = null;
                        while (iteArray.hasNext()){
                            temp = iteArray.next();
                %>
                <tr>
                    <td><%= temp.getName() %></td>
                    <td><%= temp.getLastname() %></td>
                    <td><%= temp.getNumeroTelefono() %></td>
                    <td><%= temp.getEmail() %></td>
                    <td><a href="ClienteServlet?formid=4&id=<%= temp.getId() %>">Update</a></td>
                    <td><a href="ClienteServlet?formid=2&id=<%= temp.getId() %>">Delete</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            
    </body>
</html>
