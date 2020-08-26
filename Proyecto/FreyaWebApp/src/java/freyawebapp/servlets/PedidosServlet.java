package freyawebapp.servlets;

import freyawebapp.logic.ClientLogic;
import freyawebapp.logic.PlatillosLogic;
import freyawebapp.logic.PedidosLogic;
import freyawebapp.objects.ClientObject;
import freyawebapp.objects.PlatilloObject;
import freyawebapp.objects.PedidosObject;
import freyawebapp.objects.PedidosViewObject;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidosServlet", urlPatterns = {"/PedidosServlet"})
public class PedidosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        PedidosLogic logic;
        request.getSession().setAttribute("rows", 0);
        
        String strIdpedidos, strIdcliente, strIdplatillos;
        int iIdpedidos, iIdCliente, iIdPlato, rows;
        
        ClientLogic clientLogic;
        PlatillosLogic platillosLogic;
                
        ArrayList<ClientObject> clientArray;
        ArrayList<PlatilloObject> platilloArray;
        
        switch(strformid){
            case "1":
                System.out.println("Código para ingresar un nuevo pedido...");
                
                //al inicio
                strIdcliente = request.getParameter("lastname");
                iIdCliente = Integer.parseInt(strIdcliente);
                strIdplatillos = request.getParameter("numeroPlatillo");
                iIdPlato = Integer.parseInt(strIdplatillos);
                
                //enmedio
                logic = new PedidosLogic(strConnString);
                rows = logic.insertNewPedido(iIdCliente, iIdPlato);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PedidosServlet?formid=3");
                break;
            case "2":
                System.out.println("Código para eliminar un pedido...");
                
                //al inicio
                strIdpedidos = request.getParameter("id");
                iIdpedidos = Integer.parseInt(strIdpedidos);
                
                //enmedio
                logic = new PedidosLogic(strConnString);
                rows = logic.deletePedidos(iIdpedidos);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PedidosServlet?formid=3");
                break;
            case "3":
                System.out.println("Traer todas los pedidos...");
                //enmedio
                logic = new PedidosLogic(strConnString);
                ArrayList<PedidosViewObject> pedidosArray = logic.getAllPedidos();
                
                //al final
                request.getSession().setAttribute("pedidosArray", pedidosArray);
                response.sendRedirect("PedidosMain.jsp");
                break;
            case "4":
                /*
                System.out.println("Get parts for update 1...");
                
                strIdreserva = request.getParameter("id");
                iIdreserva = Integer.parseInt(strIdreserva);
                
                logic = new ReservaLogic(strConnString);
                ReservaObject reservaobj = logic.getReservaByID(iIdreserva);
                
                request.getSession().setAttribute("reservaobj", reservaobj);
                response.sendRedirect("newReserva.jsp");
                */
                break;
            case "5":
                break;
            case "6":
                System.out.println("Get all parts for new pedido");
                
                clientLogic = new ClientLogic (strConnString);
                platillosLogic = new PlatillosLogic (strConnString);
                
                clientArray = clientLogic.getAllClients();
                platilloArray = platillosLogic.getAllPlatillos();
                
                request.getSession().setAttribute("clientArray", clientArray);
                request.getSession().setAttribute("platilloArray", platilloArray);
                response.sendRedirect("newPedido.jsp");
                break;
            default:
                break;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
