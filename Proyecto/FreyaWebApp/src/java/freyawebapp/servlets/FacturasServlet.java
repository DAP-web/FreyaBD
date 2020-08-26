package freyawebapp.servlets;

import freyawebapp.logic.ClientLogic;
import freyawebapp.logic.DRLogic;
import freyawebapp.logic.FacturaLogic;
import freyawebapp.logic.PlatillosLogic;
import freyawebapp.logic.RestaurantLogic;
import freyawebapp.objects.ClientObject;
import freyawebapp.objects.DRObject;
import freyawebapp.objects.FacturaViewObject;
import freyawebapp.objects.PlatilloObject;
import freyawebapp.objects.RestaurantObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FacturasServlet", urlPatterns = {"/FacturasServlet"})
public class FacturasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        
        String strID, strIDRestaurante, strIDDR, strIDCliente, strFecha, strHora, strfastpass, strtotal;
        int iID, iIDRestaurante, iIDDR, iIDCliente, ifastpass, rows;
        double total, iva, subtotal;
        
        FacturaLogic logicf;
        ClientLogic logic;
        DRLogic logicdr;
        RestaurantLogic logicr;
        PlatillosLogic logicp;
        
        ArrayList<ClientObject> clientArray;
        ArrayList<DRObject> drArray;
        ArrayList<RestaurantObject> rArray;
        ArrayList<PlatilloObject> pArray;
        
        switch(strformid){
            case "1":
                System.out.println("Código para ingresar una factura nueva...");
                
                //al inicio
                strIDRestaurante = request.getParameter("restaurante");
                iIDRestaurante = Integer.parseInt(strIDRestaurante);
                strIDDR = request.getParameter("ubicacion");
                iIDDR = Integer.parseInt(strIDDR);
                strIDCliente = request.getParameter("lastname");
                iIDCliente = Integer.parseInt(strIDCliente);
                strFecha = request.getParameter("fecha");
                strHora = request.getParameter("hora");
                iva = 0.13;
                strfastpass = request.getParameter("fastpass");
                ifastpass = Integer.parseInt(strfastpass);
                strtotal = request.getParameter("total");
                subtotal = Double.parseDouble(strtotal);
                if(ifastpass==1){
                    total = (subtotal*1.13)+10;
                } else {
                    total = subtotal*1.13;
                }
                //enmedio
                logicf = new FacturaLogic(strConnString);
                rows = logicf.insertarFactura(iIDRestaurante, iIDDR, 
                        iIDCliente, strFecha, strHora, iva, ifastpass, total);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("FacturasServlet?formid=2");
                break;
            case "2":
                System.out.println("Traer todas las reservas...");
                //enmedio
                logicf = new FacturaLogic(strConnString);
                ArrayList<FacturaViewObject> facturasArray = logicf.getAllFacturas();
                
                //al final
                request.getSession().setAttribute("facturasArray", facturasArray);
                response.sendRedirect("facturacomplete.jsp");
                break;
            case "3":
                System.out.println("Get all parts for new reservation");
                
                logic = new ClientLogic (strConnString);
                logicdr = new DRLogic (strConnString);
                logicr = new RestaurantLogic(strConnString);
                logicp = new PlatillosLogic(strConnString);
                
                clientArray = logic.getAllClients();
                drArray = logicdr.getAllDR();
                rArray = logicr.getAllRestaurants();
                pArray = logicp.getAllPlatillos();
                
                
                
                request.getSession().setAttribute("clientArray", clientArray);
                request.getSession().setAttribute("drArray", drArray);
                request.getSession().setAttribute("rArray", rArray);
                request.getSession().setAttribute("pArray", pArray);
                response.sendRedirect("nuevafactura.jsp");
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
