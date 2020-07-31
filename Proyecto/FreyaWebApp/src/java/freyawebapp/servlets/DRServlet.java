package freyawebapp.servlets;

import freyawebapp.logic.DRLogic;
import freyawebapp.objects.DRObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DRServlet", urlPatterns = {"/DRServlet"})
public class DRServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        DRLogic logic;
        int iID, iNumeroTelefono, rows;
        String strLocalizacion, strCodigoPostal, strID, strNumeroTelefono;
        request.getSession().setAttribute("rows", 0);
        
        switch (strformid){
            case "1":
                System.out.println("Code for insert new...");
                
                //al inicio pedir los parametros o datos
                
                strLocalizacion = request.getParameter("localizacion");
                strCodigoPostal = request.getParameter("codigoPostal");
                strNumeroTelefono = request.getParameter("numeroTelefono");
                //nNumeroTelefono = request.getParameter(nName)
                
                //Crear un objeto Logic para mandar parametros
                logic = new DRLogic(strConnString);
                rows = logic.insertNewDR (strLocalizacion, strCodigoPostal, strNumeroTelefono);
                
                //PREGUNTAR ESTA ULTIMA PARTE DE GETSESSION
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("DRServlet?formid=3");
            break;
            case "2":
                System.out.println("Code for delete...");
                
                //request parameters
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                //LOGIC
                logic = new DRLogic(strConnString);
                rows = logic.deleteDR(iID);
                
                //
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("DRServlet?formid=3");
                
            break;
            case "3":
                System.out.println("Code for select...");
                
                //logic
                logic = new DRLogic(strConnString);
                ArrayList<DRObject> dRArray = logic.getAllDR();
                
                //response
                request.getSession().setAttribute("dRArray", dRArray);
                response.sendRedirect("viewDR.jsp");
            break;
            case "4":
                System.out.println("Code for update 1...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                logic = new DRLogic(strConnString);
                DRObject dRObject = logic.getDRByID(iID);
                
                request.getSession().setAttribute("dRobject", dRObject);
                response.sendRedirect("updateDR.jsp");
            break;
            case "5":
                System.out.println("Code for update 2...");
                
                strID = request.getParameter("iddireccion");
                iID = Integer.parseInt(strID);
                strLocalizacion = request.getParameter("localizacion");
                strCodigoPostal= request.getParameter("codigoPostal");
                strNumeroTelefono = request.getParameter("numeroTelefono");
                //nNumeroTelefono = request.getParameter(nName)
                
                logic = new DRLogic(strConnString);
                rows = logic.updateDR (iID, strLocalizacion, strCodigoPostal, strNumeroTelefono);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("DRServlet?formid=3");
            break;
            case "6":
                System.out.println("Code for select 2...");
                
                //logic
                logic = new DRLogic(strConnString);
                ArrayList<DRObject> drArray = logic.getAllDR();
                
                //response
                request.getSession().setAttribute("dRArray", drArray);
                response.sendRedirect("modifyDR.jsp");
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
