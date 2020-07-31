package freyawebapp.servlets;

import freyawebapp.logic.MesasLogic;
import freyawebapp.objects.MesaObjects;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MesasServlet", urlPatterns = {"/MesasServlet"})
public class MesasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strConnString = "jdbc:mysql://localhost/freya1?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strformid = request.getParameter("formid");
        MesasLogic logic;
        int nID, nCantidad, rows;
        String nTipo, nEstado, strID, strCantidad;
        
        switch(strformid){
            case "1":
                System.out.println("Code for insert new...");
                
                //Pedir parametros y datos 
                nTipo = request.getParameter("tipo");
                nEstado = request.getParameter("estado");
                strCantidad = request.getParameter("cantidad");
                nCantidad = Integer.parseInt(strCantidad);
                
                //Crear el objeto logic para mandar parametros
                logic = new MesasLogic(strConnString);
                rows = logic.insertNewMesa(nTipo, nEstado, nCantidad);
                
                //GetSession
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("MesasServlet?formid=6");
            break; 
            case "2":
                System.out.println("Code for delete...");
                
                //pedir parametros
                strID = request.getParameter("id");
                nID = Integer.parseInt(strID);
                
                //Logic 
                logic = new MesasLogic(strConnString);
                rows = logic.deleteMesas(nID);
                
                //
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("MesasServlet?formid=6");
                
            break;
            case "3":
                System.out.println("Code for select...");
                
                //logic
                logic = new MesasLogic(strConnString);
                ArrayList<MesaObjects> mesasArray = logic.getAllMesas();
                
                // respuesta
                request.getSession().setAttribute("mesasArray", mesasArray);
                response.sendRedirect("MesasCliente.jsp");
            break;
            //case 4 para update 1
            case "4":
                System.out.println("Code for update 1...");
                
                strID = request.getParameter("id");
                nID = Integer.parseInt(strID);
                
                logic = new MesasLogic(strConnString);
                MesaObjects mesaObjects = logic.getMesaByID(nID);
                
                request.getSession().setAttribute("mesaObjects", mesaObjects);
                response.sendRedirect("UpdateMesas.jsp");
            break;
             //case 5 para update 2
            case "5":
                System.out.println("Code for update 2...");
                strID = request.getParameter("id");
                nID = Integer.parseInt(strID);
                nTipo = request.getParameter("tipo");
                nEstado = request.getParameter("estado");
                strCantidad = request.getParameter("cantidad");
                nCantidad = Integer.parseInt(strCantidad);
                
                logic = new MesasLogic(strConnString);
                rows = logic.updateMesas(nID, nTipo, nEstado, nCantidad);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("MesasServlet?formid=6");
                break;
               //case 6 va a ser el mismo case 3 pero me va a redirigir hacia MesasCliente.jsp 
                case "6":
                System.out.println("Code for select...");
                
                //logic
                logic = new MesasLogic(strConnString);
                ArrayList<MesaObjects> mesasarray = logic.getAllMesas();
                
                // respuesta
                request.getSession().setAttribute("mesasArray", mesasarray);
                response.sendRedirect("MesasRestaurante.jsp");
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
