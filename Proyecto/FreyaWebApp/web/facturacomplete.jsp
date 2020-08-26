<%-- 
    Document   : facturacomplete
    Created on : Jul 31, 2020, 1:41:20 AM
    Author     : Diego Portillo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.FacturaViewObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Facturas</title>
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
            table {
                table-layout: fixed;
                width: 70%;
            }
        </style>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<FacturaViewObject> array = 
                (ArrayList<FacturaViewObject>)request.getSession()
                        .getAttribute("facturasArray");
        %>
    <body bgcolor="#FFDAB9">
        <h1>Registro de Facturas</h1>
        <h3>Facturas de todos los clientes y pedidos</h3>
        <br>
        <a href="FacturasServlet?formid=3" style="font-size: 1.5em">Nueva Factura</a>
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
        <table border="1">
            <tr>
            <th>Restaurante</th>
            <th>Ubicacion</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>IVA</th>
            <th>Fast pass?</th>
            <th>Total</th>
          </tr>
          <%
              Iterator<FacturaViewObject> iteArray= null;
              if(array!=null)
              {
                  int fastpass;
                  String message;
                  iteArray = array.iterator();
                  FacturaViewObject temp = null;
                  while(iteArray.hasNext())
                  {
                      
                      temp = iteArray.next();
                      fastpass = temp.getFastpass();
                      if(fastpass==1){
                          message = "Sí";
                      } else {
                          message = "No";
                      }
          %>
                    <tr>
                      <td><%= temp.getRestaurante() %></td>
                      <td><%= temp.getUbicacion() %></td>
                      <td style="text-align:left"><%= temp.getName() %></td>
                      <td style="text-align:left"><%= temp.getLastname() %></td>
                      <td style="text-align:center"><%= temp.getDate() %></td>
                      <td style="text-align:center"><%= temp.getTime() %></td>
                      <td style="text-align:center"><%= temp.getIva() %>%</td>
                      <td style="text-align:center"><%= message %></td>
                      <td style="text-align:right">$ <%= temp.getTotal() %></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
              
        <%
        
        %>
        <br><br>
        
        
        <a href="RestauranteServlet?formid=3" style="font-size: 1.25em">Volver</a>
    </body>
</html>