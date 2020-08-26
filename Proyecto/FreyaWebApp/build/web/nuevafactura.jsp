<%-- 
    Document   : nuevafactura
    Created on : Aug 25, 2020, 11:10:12 PM
    Author     : Diego Portillo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.PlatilloObject"%>
<%@page import="freyawebapp.objects.RestaurantObject"%>
<%@page import="freyawebapp.objects.DRObject"%>
<%@page import="freyawebapp.objects.ClientObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Factura</title>
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
        ArrayList<DRObject> drArray = 
                (ArrayList<DRObject>) request.getSession()
                        .getAttribute("drArray");
        ArrayList<RestaurantObject> rArray = 
                (ArrayList<RestaurantObject>) request.getSession()
                        .getAttribute("rArray");
        ArrayList<PlatilloObject> pArray = 
                (ArrayList<PlatilloObject>) request.getSession()
                        .getAttribute("pArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Nueva Factura</h1>
        <br>
        <form action="FacturasServlet" method="post">
            <%
                Iterator<RestaurantObject> iteRestaurant = rArray.iterator();
            %>
            <label for="restaurante">Nombre del restaurante:</label>
            <br>
            <select id="restaurante" name="restaurante" required>
              <option value="">--</option>
              <%
                  if(iteRestaurant!=null)
                  {
                      RestaurantObject temp;
                      while(iteRestaurant.hasNext())
                      {
                          temp = iteRestaurant.next();
              %>
                    <option value="<%= temp.getId() %>"><%= temp.getName() %></option>
              <%
                      }
                  }
              %>
            </select>            
            <br><br>
            <%
                Iterator<DRObject> iteDR = drArray.iterator();
            %>
            <label for="ubicacion">Ubicacion:</label>
            <br>
            <select id="ubicacion" name="ubicacion" required>
              <option value="">--</option>
              <%
                  if(iteDR!=null)
                  {
                      DRObject temp;
                      
                      while(iteDR.hasNext())
                      {
                          temp = iteDR.next();
              %>
                    <option value="<%= temp.getIdDireccion() %>"><%= temp.getLocalizacion() %></option>
              <%
                      }
                  }
              %>
            </select>
            <br><br>
            <%
                Iterator<ClientObject> iteCliente = clientArray.iterator();
            %>
            <label for="lastname">Last Name:</label>
            <br>
            <select id="lastname" name="lastname" required>
              <option value="">--</option>
              <%
                  if(iteCliente!=null)
                  {
                      ClientObject temp;
                      while(iteCliente.hasNext())
                      {
                          temp = iteCliente.next();
              %>
                    <option value="<%= temp.getId() %>"><%= temp.getLastname() %></option>
              <%
                      }
                  }
              %>
            </select>            
            <br><br>
            <%
                Iterator<PlatilloObject> itePlatillo = pArray.iterator();
            %>
  
            <label for="platillo">Platillos:</label>
            <br>
            
              <%
                  if(itePlatillo!=null)
                  {
                      PlatilloObject temp;
                      double precio;
                      while(itePlatillo.hasNext())
                      {
                          temp = itePlatillo.next();
              %>
                    <input type="checkbox" id="platillo" name="platillo" value="<%= temp.getId() %>">      
                    <label for="platillo" value="<%= temp.getId() %>"><%= temp.getName() %></label>
                    
                    <br>
              <%
                      }
                  }

                String platillo = request.getParameter("platillo");
                
              %>
            </select>
            <br>
            Date: <br>
            <input type="date" id="fecha" name="fecha" required/>
            <br><br>
            Hora Reserva: <br>
            <input type="time" id="hora" name="hora" required/>
            <br><br>
            <label for="fastpass">Fast pass?</label><br>
            <select id="fastpass" name="fastpass" required>
              <option value="">--</option>
              <option value="0">Si</option>
              <option value="0">No</option>
            </select>
            <br><br>
            Sub-Total: <br>
            <input type="text" id="total" name="total" required/>
            <br><br>
            
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="1" />
        </form>
    </body>
</html>
