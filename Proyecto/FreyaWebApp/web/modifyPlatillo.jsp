<%-- 
    Document   : modifyPlatillo
    Created on : Jul 31, 2020, 12:43:12 AM
    Author     : Diego Portillo
--%>

<%@page import="freyawebapp.objects.PlatilloObject"%>
<%@page import="freyawebapp.objects.DRObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Platillos Main</title>
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
        ArrayList<PlatilloObject> array = (ArrayList<PlatilloObject>)
                request.getSession().getAttribute("platilloArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Platillos Main</h1>
        <br><br>
        <a href="newPlatillo.html" style="font-size: 1.5em">Nuevo Platillo</a>
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
                    <th>Price</th>
                    <th>Description</th>
                    <th colspan="2">Acciones</th>
                </tr>
                <%
                    Iterator<PlatilloObject> iteArray = null;
                    if(array!=null){
                        iteArray = array.iterator();
                        PlatilloObject temp = null;
                        while (iteArray.hasNext()){
                            temp = iteArray.next();
                %>
                <tr>
                    <td><%= temp.getName() %></td>
                    <td style="text-align:right">$<%= temp.getPrice() %></td>
                    <td><%= temp.getDescription() %></td>
                    <td><a href="PlatilloServlet?formid=4&id=<%= temp.getId() %>">Update</a></td>
                    <td><a href="PlatilloServlet?formid=2&id=<%= temp.getId() %>">Delete</a></td>

                </tr>
                <%
                        }
                    }
                %>
            </table>
            <br>
            <a href="RestauranteServlet?formid=3" style="font-size: 1.25em">Volver</a>
            
    </body>
</html>
