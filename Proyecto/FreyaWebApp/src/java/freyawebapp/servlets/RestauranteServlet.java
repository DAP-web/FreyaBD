package freyawebapp.servlets;

import freyawebapp.logic.RestaurantLogic;
import freyawebapp.objects.RestaurantObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RestauranteServlet", urlPatterns = {"/RestauranteServlet"})
public class RestauranteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        RestaurantLogic logic;
        int iID, iNumeroTelefono, rows;
        String strName, strOpens, strCloses, strEmail, strID;
        request.getSession().setAttribute("rows", 0);
        
        switch (strformid){
            case "1":
                System.out.println("Code for insert new...");
                
                //al inicio pedir los parametros o datos
                strName = request.getParameter("name");
                strOpens = request.getParameter("horaapertura");
                strCloses = request.getParameter("horacierre");
                //nNumeroTelefono = request.getParameter(nName)
                strEmail = request.getParameter("email");
                
                //Crear un objeto Logic para mandar parametros
                logic = new RestaurantLogic(strConnString);
                rows = logic.insertNewRestaurant(strName, strOpens, strCloses, strEmail);
                
                //PREGUNTAR ESTA ULTIMA PARTE DE GETSESSION
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("RestauranteServlet?formid=3");
            break;
            case "2":
                System.out.println("Code for delete...");
                
                //request parameters
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                //LOGIC
                logic = new RestaurantLogic(strConnString);
                rows = logic.deleteRestaurant(iID);
                
                //
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("RestauranteServlet?formid=3");
                
            break;
            case "3":
                System.out.println("Code for select...");
                
                //logic
                logic = new RestaurantLogic(strConnString);
                ArrayList<RestaurantObject> restaurantArray = logic.getAllRestaurants();
                
                //response
                request.getSession().setAttribute("restaurantArray", restaurantArray);
                response.sendRedirect("restaurantMain.jsp");
            break;
            case "4":
                System.out.println("Code for update 1...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                logic = new RestaurantLogic(strConnString);
                RestaurantObject RestaurantObject = logic.getRestaurantByID(iID);
                
                request.getSession().setAttribute("restaurantObject", RestaurantObject);
                response.sendRedirect("updateRestaurant.jsp");
            break;
            case "5":
                System.out.println("Code for update 2...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                strName = request.getParameter("name");
                strOpens = request.getParameter("horaapertura");
                strCloses = request.getParameter("horacierre");
                //nNumeroTelefono = request.getParameter(nName)
                strEmail = request.getParameter("email");
                //strPassword = request.getParameter("password");
                
                logic = new RestaurantLogic(strConnString);
                rows = logic.updateRestaurant(iID, strName, strOpens, strCloses, strEmail);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("RestauranteServlet?formid=3");
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
