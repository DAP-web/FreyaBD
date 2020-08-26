
package freyawebapp.servlets;

import freyawebapp.logic.AdminLogic;
import freyawebapp.objects.AdminObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        AdminLogic logic;
        AdminObject adminobject;
        int iID, rows, id;
        String strName, strLastName, strID, strEmail, strPassword, message;
        request.getSession().setAttribute("rows", 0);
        
        switch (strformid){
            case "1":
                System.out.println("Code for insert new...");
                
                //al inicio pedir los parametros o datos
                
                strName = request.getParameter("name");
                strLastName = request.getParameter("lastname");
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                String login = strName+" "+strLastName;
                
                //nNumeroTelefono = request.getParameter(nName)
                
                //Crear un objeto Logic para mandar parametros
                logic = new AdminLogic(strConnString);
                rows = logic.insertNewAdmin (strName, strLastName, strEmail, strPassword);
                
                //PREGUNTAR ESTA ULTIMA PARTE DE GETSESSION
                request.getSession().setAttribute("LoginName", login);
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("index_admin.jsp");
            break;
            case "2":
                System.out.println("Code for delete...");
                
                //request parameters
                strID = request.getParameter("id");
                iID = Integer.parseInt(strID);
                
                //LOGIC
                logic = new AdminLogic(strConnString);
                rows = logic.deleteAdmin(iID);
                
                //
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("AdminServlet?formid=6");
                
            break;
            case "3":
                System.out.println("Code for select...");
                
                //logic
                logic = new AdminLogic(strConnString);
                ArrayList<AdminObject> adminArray = logic.getAllAdmin();
                
                //response
                request.getSession().setAttribute("adminArray", adminArray);
                response.sendRedirect("viewAdmin.jsp");
            break;
            case "4":
                System.out.println("Code for update 1...");
                
                
                iID = (int)request.getSession().getAttribute("id");
                
                logic = new AdminLogic(strConnString);
                adminobject = logic.getAdminByID(iID);
                
                request.getSession().setAttribute("adminobject", adminobject);
                response.sendRedirect("updateAdmin.jsp");
            break;
            case "5":
                System.out.println("Code for update 2...");
                
                strID = request.getParameter("idadmin");
                iID = Integer.parseInt(strID);
                strName = request.getParameter("name");
                strLastName = request.getParameter("lastName");
                strEmail = request.getParameter("email");
                strPassword = request.getParameter("password");
                
                //nNumeroTelefono = request.getParameter(nName)
                
                logic = new AdminLogic(strConnString);
                rows = logic.updateAdmin (iID, strName, strLastName, strEmail, strPassword);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("index_admin.jsp");
            break;
            case "6":
                System.out.println("Code for select 2...");
                
                //logic
                logic = new AdminLogic(strConnString);
                ArrayList <AdminObject> admiNArray = logic.getAllAdmin();
                
                //response
                request.getSession().setAttribute("adminArray", admiNArray);
                response.sendRedirect("modifyAdmin.jsp");
            break;
            case"7":
                strName = request.getParameter("name");
                strPassword = request.getParameter("password");
                
                if(strPassword.equals("abcde")){
                    response.sendRedirect("newAdmin.html");
                } else {
                    message = "No tiene permisos para agregar nuevos administradores";
                    request.getSession().setAttribute("mensaje2", message);
                    response.sendRedirect("verify.jsp");
                }
                
                break;
            case "8":
                strName = request.getParameter("name");
                strPassword = request.getParameter("password");
                
                if(strPassword.equals("abcde")){
                    
                    response.sendRedirect("AdminServlet?formid=4");
                } else {
                    message = "No tiene permisos para agregar nuevos administradores";
                    request.getSession().setAttribute("mensaje2", message);
                    response.sendRedirect("AdminServlet?formid=8");
                }
                
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
