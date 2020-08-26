<%-- 
    Document   : index_cliente
    Created on : Aug 16, 2020, 3:33:23 PM
    Author     : Diego Portillo
--%>

<%@page import="freyawebapp.objects.ClientObject"%>
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
    <%
    
    %>
    <body bgcolor="#FFDAB9">
        
        <h1>Freya BD website for Clients</h1>
        <br><br>
        <%
        String message = (String)request.getSession().getAttribute("message1");
        ClientObject temp = (ClientObject)request.getSession().getAttribute("clientobj");
        String login = (String)request.getSession().getAttribute("LoginName");
        if (!(login.equals(null))) {
        %>
        <footer>
            <p>Welcome <%= login %><br>
                <a href="index.jsp">Log out</a></p>
            
        </footer>
        
        <%
        }
                
        //if(!(message.equals(null))){
        %>
        <p><%= message %><br>
        <%
        //}
        %>
        
        <table style="width:45%" border="1">
                <tr>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Phone Number</th>
                    <th>Email Address</th>
                    <th>Password</th>
                    <th>Acciones</th>
                </tr>
                <tr>
                    <td style="text-align: center"><%= temp.getName() %></td>
                    <td style="text-align: center"><%= temp.getLastname() %></td>
                    <td style="text-align: center"><%= temp.getNumeroTelefono() %></td>
                    <td style="text-align: center"><%= temp.getEmail() %></td>
                    <td style="text-align: center"><%= temp.getPassword() %></td>
                    <td><a href="ClienteServlet?formid=8&id=<%= temp.getId() %>">Update</a></td>
                </tr>
            </table>
        <%
        
        %>
        <br>
        <a href="ClienteServlet?formid=7&id=<%= temp.getId() %>">Eliminar perfil</a>
        <br><br>
        <a href="ReservaServlet?formid=7&id=<%= temp.getId() %>">Hacer Reserva</a>

    </body>
</html>
