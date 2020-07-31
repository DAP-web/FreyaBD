package freyawebapp.servlets;
import freyawebapp.logic.PlatillosLogic;
import freyawebapp.objects.PlatilloObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PlatilloServlet", urlPatterns = {"/PlatilloServlet"})
public class PlatilloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        PlatillosLogic logic;
        int iID, iPrice, rows;
        String strName, strDescription, strID, strPrice;
        request.getSession().setAttribute("rows", 0);
        
        switch (strformid){
            case "1":
                System.out.println("Code for insert new...");
                
                //al inicio pedir los parametros o datos
                strName = request.getParameter("name");
                strPrice = request.getParameter("price");
                strDescription = request.getParameter("description");

                
                //Crear un objeto Logic para mandar parametros
                logic = new PlatillosLogic(strConnString);
                rows = logic.insertNewPlatillo(strName, strPrice, strDescription);
                
                //PREGUNTAR ESTA ULTIMA PARTE DE GETSESSION
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PlatilloServlet?formid=6");
            break;
            case "2":
                System.out.println("Code for delete...");
                
                //request parameters
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                //LOGIC
                logic = new PlatillosLogic(strConnString);
                rows = logic.deletePlatillo(iID);
                
                //
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PlatilloServlet?formid=6");
                
            break;
            case "3":
                System.out.println("Code for select...");
                
                //logic
                logic = new PlatillosLogic(strConnString);
                ArrayList<PlatilloObject> platilloArray = logic.getAllPlatillos();
                
                //response
                request.getSession().setAttribute("platilloArray", platilloArray);
                response.sendRedirect("viewPlatillo.jsp");
            break;
            case "4":
                System.out.println("Code for update 1...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                logic = new PlatillosLogic(strConnString);
                PlatilloObject platilloObject = logic.getPlatilloByID(iID);
                
                request.getSession().setAttribute("platillobject", platilloObject);
                response.sendRedirect("updatePlatillo.jsp");
            break;
            case "5":
                System.out.println("Code for update 2...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                strName = request.getParameter("name");
                strPrice = request.getParameter("price");
                strDescription = request.getParameter("description");
                
                logic = new PlatillosLogic(strConnString);
                rows = logic.updateClient(iID, strName, strPrice, strDescription);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("PlatilloServlet?formid=6");
            break;
            case "6":
                System.out.println("Code for select...");
                
                //logic
                logic = new PlatillosLogic(strConnString);
                ArrayList<PlatilloObject> platilloarray = logic.getAllPlatillos();
                
                //response
                request.getSession().setAttribute("platilloArray", platilloarray);
                response.sendRedirect("modifyPlatillo.jsp");
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
