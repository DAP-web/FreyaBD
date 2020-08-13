package freyawebapp.servlets;

import freyawebapp.logic.ClientLogic;
import freyawebapp.logic.MesasLogic;
import freyawebapp.logic.ReservaLogic;
import freyawebapp.objects.ClientObject;
import freyawebapp.objects.MesaObjects;
import freyawebapp.objects.ReservaViewObject;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        ReservaLogic logic;
        request.getSession().setAttribute("rows", 0);
        
        String strIdreserva, strIdcliente, strIdmesa, strHoraReserva;
        int iIdreserva, iIdcliente, iIdmesa, rows;
        
        switch(strformid){
            case "1":
                System.out.println("Código para ingresar una reserva nueva...");
                
                //al inicio
                strIdcliente = request.getParameter("lastname");
                iIdcliente = Integer.parseInt(strIdcliente);
                strIdmesa = request.getParameter("numeroMesa");
                iIdmesa = Integer.parseInt(strIdmesa);
                strHoraReserva = request.getParameter("horaReserva");
                
                //enmedio
                logic = new ReservaLogic(strConnString);
                rows = logic.insertNewReserva(iIdcliente, iIdmesa, strHoraReserva);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ReservaServlet?formid=3");
                break;
            case "2":
                break;
            case "3":
                System.out.println("Traer todas las reservas...");
                //enmedio
                logic = new ReservaLogic(strConnString);
                ArrayList<ReservaViewObject> reservaArray = logic.getAllReservas();
                
                //al final
                request.getSession().setAttribute("reservaArray", reservaArray);
                response.sendRedirect("reserva.jsp");
                break;
            case "6":
                System.out.println("Get all parts for new reservation");
                
                ClientLogic clientLogic = new ClientLogic (strConnString);
                MesasLogic mesasLogic = new MesasLogic (strConnString);
                
                ArrayList<ClientObject> clientArray = clientLogic.getAllClients();
                ArrayList<MesaObjects> mesasArray = mesasLogic.getAllMesas();
                
                request.getSession().setAttribute("clientArray", clientArray);
                request.getSession().setAttribute("mesasArray", mesasArray);
                response.sendRedirect("newReserva.jsp");
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
