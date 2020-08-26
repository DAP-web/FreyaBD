<%-- 
    Document   : newPedido
    Created on : 08-26-2020, 01:15:23 AM
    Author     : accom
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.PlatilloObject"%>
<%@page import="freyawebapp.objects.ClientObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Pedido</title>
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
        ArrayList<ClientObject> clientArray = 
                (ArrayList<ClientObject>) request.getSession()
                        .getAttribute("clientArray");
        ArrayList<PlatilloObject> platilloArray = 
                (ArrayList<PlatilloObject>) request.getSession()
                        .getAttribute("platilloArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Nuevo Pedido</h1>
         <h1>Nueva Pedido</h1>
        <br>
        <form action="PedidosServlet" method="post">
            <%
                Iterator<ClientObject> iteClient = clientArray.iterator();
            %>
            <label for="lastname">Last Name:</label>
            <br>
            <select id="lastname" name="lastname" required>
              <option value="">--</option>
                           <%
                  if(iteClient!=null)
                  {
                      ClientObject temp;
                      while(iteClient.hasNext())
                      {
                          temp = iteClient.next();
              %>
                    <option value="<%= temp.getId() %>"><%= temp.getLastname() %></option>
              <%
                      }
                  }
              %>
            </select>            
            <br><br>
            <%
                Iterator<PlatilloObject> itePlatillos = platilloArray.iterator();
            %>
                        <label for="nombrePlatillo">Nombre del platillo:</label>
            <br>
            <select id="numeroPlatillo" name="numeroPlatillo" required>
              <option value="">--</option>
              <%
                  if(itePlatillos!=null)
                  {
                      PlatilloObject temp;
                      
                      while(itePlatillos.hasNext())
                      {
                          temp = itePlatillos.next();
              %>
              <option value="<%= temp.getId() %>"><%= temp.getId() %></option>
              <%
                      }
                  }
              %>
         </form>
    </body>
</html>
