<%-- 
    Document   : PedidosMain
    Created on : 08-25-2020, 11:26:09 PM
    Author     : accom
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.PedidosViewObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            p{
                color: #000000;
                font-size: 20px;
            }
            h3{
                color: #000080;
                text-align:center;
                font-size: 20px;
            }
        </style>
    </head>
     <%
            int rows = (int)request.getSession().getAttribute("rows");
            ArrayList<PedidosViewObject> array = 
                    (ArrayList<PedidosViewObject>)request.getSession().
                            getAttribute("pedidosArray");
    %>
    <body bgcolor="#FFDAB9" >
        
        <h1>Pedidos</h1>
         <h3>Cliente y platillo</h3>
        <br><br>
        <a href="PedidosServlet?formid=6" style="font-size: 1.25em">Nuevo Pedido</a>
        <br><br>
        <%
        if(rows>0)
        {
        %>
            <p style="color:red;"><%= rows %> affected</p>
            <br><br>
        <%
        }
        %>
          <table style="width:40%" border="1">
          <tr>
            <th>Client Last Name</th>
            <th>Client Name</th>
            <th>Plato</th>
            <th>Acciones</th>
          </tr>
        <%
              Iterator<PedidosViewObject> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  PedidosViewObject temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
        %>
               <tr>
               <td><%= temp.getLastName() %></td>
               <td><%= temp.getName() %></td>
               <td style="text-align:left"><%= temp.getNombrePlato() %></td>
               <td><a href="PedidosServlet?formid=2&id=<%= temp.getPedidosID() %>">Delete</a></td>
               </tr> 
          <%
                   }
              }
          %>
                    
        </table>
        <br><br>
        <a href="RestauranteServlet?formid=3" style="font-size: 1.25em">Volver</a>
    </body>
</html>
