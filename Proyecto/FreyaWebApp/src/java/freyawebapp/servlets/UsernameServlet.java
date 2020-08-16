package freyawebapp.servlets;

import freyawebapp.logic.UsersLogic;
import freyawebapp.objects.AdminObject;
import freyawebapp.objects.ClientObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsernameServlet", urlPatterns = {"/UsernameServlet"})
public class UsernameServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        String strEmail, strPassword, message, strName, strLastName, strLoginName;
        int rows, identifier;
        
        UsersLogic logic;
        
        switch(strformid){
            case"1":
                System.out.println("Se verificará la identidad del usuario. Login Cliente");
                
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                
                logic = new UsersLogic(strConnString);
                ClientObject clientobject = logic.getClientByEmail(strEmail);
                
                request.getSession().setAttribute("clientobject", clientobject);
                
                if (clientobject!=null){
                    if(clientobject.getPassword().equals(strPassword)) {
                        System.out.println("Es un cliente.");
                        request.getSession().setAttribute("strEmail", strEmail);
                        response.sendRedirect("ClienteServlet?formid=10");
                    } else {
                        System.out.println("Algo salió mal.");
                        message = "Algo salió mal. Verifica los campos y vuelve a probar.";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    System.out.println("Algo salió mal.");
                        message = "Algo salió mal. Verifica los campos y vuelve a probar.";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("index.jsp");
                }
                break;
            case"2":
                System.out.println("Se verificará la identidad del usuario. Login Admin");
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                
                logic = new UsersLogic(strConnString);
                AdminObject adminobject = logic.getAdminByEmail(strEmail);
                
                request.getSession().setAttribute("adminobject", adminobject);
                
                if (adminobject!=null){
                    if(adminobject.getPassword().equals(strPassword)) {
                        System.out.println("Es un cliente.");
                        strName = adminobject.getName();
                        strLastName = adminobject.getLastname();
                        strLoginName = strName+" "+strLastName;
                        
                        request.getSession().setAttribute("LoginName", strLoginName);
                        response.sendRedirect("index_admin.jsp");
                        
                    } else {
                        System.out.println("Algo salió mal.");
                        message = "Algo salió mal. Verifica los campos y vuelve a probar.";
                        request.getSession().setAttribute("message1", message);
                        response.sendRedirect("adminlogin.jsp");
                    }
                } else {
                    System.out.println("Algo salió mal.");
                        message = "Algo salió mal. Verifica los campos y vuelve a probar.";
                        request.getSession().setAttribute("message1", message);
                        response.sendRedirect("adminlogin.jsp");
                }
                break;
            case "3":
                System.out.println("Se está intentando crear un nuevo usuario administrador");
                
                message = "Por favor ingrese a su cuenta de Administrador "
                        + "para poder agregar nuevos administradores";
                
                request.getSession().setAttribute("message1", message);
                response.sendRedirect("adminlogin.jsp");
                
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
