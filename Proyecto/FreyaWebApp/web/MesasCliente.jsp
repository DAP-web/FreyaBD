<%-- 
    Document   : MesasCliente
    Created on : 07-30-2020, 07:13:09 PM
    Author     : accom
--%>

<%@page import="java.util.Iterator"%>
<%@page import="freyawebapp.objects.MesaObjects"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Mesas Disponibles </title>
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
        ArrayList<MesaObjects> array = (ArrayList<MesaObjects>)
                request.getSession().getAttribute("mesasArray");
    %>
    <body bgcolor="#FFDAB9">
        <h1>Mesas disponibles</h1>
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
                   <th>Tipo </th>
                    <th>Estado</th>
                    <th>Cantidad</th>
                </tr>    
                <%
                 Iterator<MesaObjects> iteArray = null;
                 if(array!=null){
                     iteArray = array.iterator();
                     MesaObjects temp = null;
                     while (iteArray.hasNext()){
                         temp = iteArray.next();
                     
                 
                %>
                <tr> 
                    <td><%= temp.getTipo()   %></td>
                    <td><%= temp.getEstado()  %></td>
                    <td><%= temp.getCantidad()  %></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            <br>
            <a href="ClienteServlet?formid=3" style="font-size: 1.25em">Volver</a>             
                

    </body>
</html>
