<%-- 
    Document   : reserva
    Created on : Jul 30, 2020, 2:16:58 PM
    Author     : Diego Portillo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.ReservaViewObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
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
        ArrayList<ReservaViewObject> array = 
                (ArrayList<ReservaViewObject>)request.getSession()
                        .getAttribute("reservaArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Reservas</h1>
        <h3>Cliente, mesa y hora de reserva</h3>
        <p>Aquí irá una view que permita ver y modificar las reservas de las mesas 
        que los clientes han hecho.</p>
        <br><br>
        <a href="ReservaServlet?formid=6" style="font-size: 1.25em">Nueva Reserva</a>
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
            <th>Client Phone Number</th>
            <th>Table ID</th>
            <th>Hora Reserva</th>
            <th <!--colspan="2"-->Acciones</th>
          </tr>
          <%
              Iterator<ReservaViewObject> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  ReservaViewObject temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getLastName() %></td>
                      <td><%= temp.getName() %></td>
                      <td style="text-align:center"><%= temp.getPhoneNumber() %></td>
                      <td style="text-align:center"><%= temp.getTableID() %></td>
                      <td style="text-align:center"><%= temp.getHoraReserva() %></td><!--
                      <td><a href="SectionServlet?formid=4&id=<%= temp.getReservaID() %>">Update</a></td>-->
                      <td><a href="ReservaServlet?formid=2&id=<%= temp.getReservaID()%>">Delete</a></td>
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
