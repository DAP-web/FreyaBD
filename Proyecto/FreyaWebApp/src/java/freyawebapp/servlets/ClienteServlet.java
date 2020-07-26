package freyawebapp.servlets;

import freyawebapp.logic.ClientLogic;
import freyawebapp.objects.ClientObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        ClientLogic logic;
        int nID, nNumeroTelefono, rows;
        String nName, nLastName, nEmail, nPassword, strID, strNumeroTelefono;
        
        switch (strformid){
            case "1":
                System.out.println("Code for insert new...");
                
                //al inicio pedir los parametros o datos
                nName = request.getParameter("name");
                nLastName = request.getParameter("lastname");
                strNumeroTelefono = request.getParameter("numeroTelefono");
                nNumeroTelefono = Integer.parseInt(strNumeroTelefono);
                //nNumeroTelefono = request.getParameter(nName)
                nEmail = request.getParameter("email");
                nPassword = request.getParameter("password");
                
                //Crear un objeto Logic para mandar parametros
                logic = new ClientLogic(strConnString);
                rows = logic.insertNewClient(nName, nLastName, strNumeroTelefono, nEmail, nPassword);
                
                //PREGUNTAR ESTA ULTIMA PARTE DE GETSESSION
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClienteServlet?formid=3");
            break;
            case "2":
                System.out.println("Code for delete...");
                
                //request parameters
                strID = request.getParameter("id");
                nID = Integer.parseInt(strID);
                
                //LOGIC
                logic = new ClientLogic(strConnString);
                rows = logic.deleteCliente(nID);
                
                //
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClienteServlet?formid=3");
                
            break;
            case "3":
                System.out.println("Code for select...");
                
                //logic
                logic = new ClientLogic(strConnString);
                ArrayList<ClientObject> clientArray = logic.getAllClients();
                
                //response
                request.getSession().setAttribute("clientArray", clientArray);
                response.sendRedirect("clientMain.jsp");
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
