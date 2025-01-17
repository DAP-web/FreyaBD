package freyawebapp.servlets;

import freyawebapp.logic.ClientLogic;
import freyawebapp.logic.UsersLogic;
import freyawebapp.objects.ClientObject;
import java.io.IOException;
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
        UsersLogic logix;
        int iID, iNumeroTelefono, rows;
        String strName, strLastName, strEmail, strPassword, strID, strNumeroTelefono, strLoginName, message;
        
        switch (strformid){
            case "1":
                System.out.println("Code for insert new Client...");
                
                //al inicio pedir los parametros o datos
                strName = request.getParameter("name");
                strLastName = request.getParameter("lastname");
                strNumeroTelefono = request.getParameter("numeroTelefono");
                //nNumeroTelefono = request.getParameter(nName)
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                
                //Crear un objeto Logic para mandar parametros
                logic = new ClientLogic(strConnString);
                rows = logic.insertNewClient(strName, strLastName, strNumeroTelefono, strEmail, strPassword);
                
                //PREGUNTAR ESTA ULTIMA PARTE DE GETSESSION
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClienteServlet?formid=3");
            break;
            case "2":
                System.out.println("Code for delete Client...");
                
                //request parameters
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                //LOGIC
                logic = new ClientLogic(strConnString);
                rows = logic.deleteCliente(iID);
                
                //
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClienteServlet?formid=3");
                
            break;
            case "3":
                System.out.println("Code for select all clients...");
                
                //logic
                
                logic = new ClientLogic(strConnString);
                ArrayList<ClientObject> clientArray = logic.getAllClients();
                
                //response
                request.getSession().setAttribute("clientArray", clientArray);
                response.sendRedirect("clientMain.jsp");
            break;
            case "4":
                System.out.println("Code for update Client (1)...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                logic = new ClientLogic(strConnString);
                ClientObject clientObject = logic.getClientByID(iID);
                
                request.getSession().setAttribute("clientobject", clientObject);
                response.sendRedirect("updateClient.jsp");
            break;
            case "5":
                System.out.println("Code for update Client (2)...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                strName = request.getParameter("name");
                strLastName = request.getParameter("lastname");
                strNumeroTelefono = request.getParameter("numeroTelefono");
                //nNumeroTelefono = request.getParameter(nName)
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                
                logic = new ClientLogic(strConnString);
                rows = logic.updateClient(iID, strName, strLastName, strNumeroTelefono, strEmail, strPassword);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClienteServlet?formid=3");
            break;
            case "6":
                System.out.println("Código para registrar nuevo cliente desde el index.");
                
                //al inicio pedir los parametros o datos
                strName = request.getParameter("name");
                strLastName = request.getParameter("lastname");
                strNumeroTelefono = request.getParameter("numeroTelefono");
                //nNumeroTelefono = request.getParameter(nName)
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                strLoginName = strName+" "+strLastName;
                
                //Crear un objeto Logic para mandar parametros
                logic = new ClientLogic(strConnString);
                rows = logic.insertNewClient(strName, strLastName, strNumeroTelefono, strEmail, strPassword);
                
                //PREGUNTAR ESTA ULTIMA PARTE DE GETSESSION
                request.getSession().setAttribute("LoginName", strLoginName);
                request.getSession().setAttribute("rows", rows);
                
                //Mandar a traer informacion para el usuario
                
                response.sendRedirect("index_cliente.jsp");
                break;
            case "7":
                System.out.println("Code for delete Client...");
                
                //request parameters
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                //LOGIC
                logic = new ClientLogic(strConnString);
                rows = logic.deleteCliente(iID);
                message = "Se ha removido el cliente con éxito. Esperamos volverte a ver.";
                
                request.getSession().setAttribute("message", message);
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("index.jsp");
                break;
            case "8":
                System.out.println("Code for update Client (1)...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                logic = new ClientLogic(strConnString);
                ClientObject clientobject = logic.getClientByID(iID);
                
                request.getSession().setAttribute("clientobject", clientobject);
                response.sendRedirect("updateClient1.jsp");
                break;
            case "9":
                System.out.println("Code for update Client (2)...");
                
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                strName = request.getParameter("name");
                strLastName = request.getParameter("lastname");
                strNumeroTelefono = request.getParameter("numeroTelefono");
                //nNumeroTelefono = request.getParameter(nName)
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                
                logic = new ClientLogic(strConnString);
                rows = logic.updateClient(iID, strName, strLastName, strNumeroTelefono, strEmail, strPassword);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClienteServlet?formid=10");
            break;
            case "10":
                strEmail = (String)request.getSession().getAttribute("strEmail");
                
                logix = new UsersLogic(strConnString);
                ClientObject clientobj = logix.getClientByEmail(strEmail);
                strName = clientobj.getName();
                strLastName = clientobj.getLastname();
                
                strLoginName = strName+" "+strLastName;
                
                message = null;
                    
                request.getSession().setAttribute("message1", message);  
                request.getSession().setAttribute("LoginName", strLoginName);
                request.getSession().setAttribute("clientobj", clientobj);
                response.sendRedirect("index_cliente.jsp");
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
