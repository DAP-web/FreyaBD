<%-- 
    Document   : newReserva
    Created on : Aug 12, 2020, 10:18:46 PM
    Author     : Diego Portillo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.MesaObjects"%>
<%@page import="freyawebapp.objects.ClientObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Reserva</title>
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
        ArrayList<MesaObjects> mesasArray = 
                (ArrayList<MesaObjects>) request.getSession()
                        .getAttribute("mesasArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Nueva Reserva</h1>
        <br>
        <form action="ReservaServlet" method="post">
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
                Iterator<MesaObjects> iteMesas = mesasArray.iterator();
            %>
            <label for="numeroMesa">Numero de mesa:</label>
            <br>
            <select id="numeroMesa" name="numeroMesa" required>
              <option value="">--</option>
              <%
                  if(iteMesas!=null)
                  {
                      MesaObjects temp;
                      
                      while(iteMesas.hasNext())
                      {
                          temp = iteMesas.next();
              %>
                    <option value="<%= temp.getId() %>"><%= temp.getId() %></option>
              <%
                      }
                  }
              %>
            </select>
            <br><br>
            
            Hora Reserva: <br>
            <input type="time" id="horaReserva" name="horaReserva" />
            <br><br>
            
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="1" />
        </form>
        
    </body>
</html>
