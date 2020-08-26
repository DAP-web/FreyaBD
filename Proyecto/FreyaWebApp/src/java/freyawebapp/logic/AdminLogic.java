
package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.AdminObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLogic  extends Logic{

    public AdminLogic(String pConnectionString) {
        super(pConnectionString);
    }
    //CODIGO PARA INSERTAR NUEVO CLIENTE
    public int insertNewAdmin (String pName, String pLastname, 
            String pEmail, String pPassword){
        //CONEXION A LA BASE DE DATOS
        DatabaseX database = getDatabase();
        //ENVIAR CODIGO PARA INSERTAR SQL
        String sql = "INSERT INTO `freya1`.`administrators` "
                + "(`idadmin`, `name`, `lastName`, `email`, `password`)"
                + "VALUES (0, '"+pName+"', '"+pLastname+"', "
                + "'"+pEmail+"', '"+pPassword+"');";
        //GET HOW MANY ROWS HAVE BEEN AFFECTED
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    public int deleteAdmin (int pID) {
        DatabaseX database = getDatabase();
        
        String sql = "DELETE FROM `freya1`.`administrators` "
                + "WHERE idadmin = '"+pID+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public ArrayList<AdminObject> getAllAdmin() {
        DatabaseX database = getDatabase();
        ArrayList<AdminObject> adminArray = new ArrayList();
        String sql = "SELECT idadmin, name, lastName, email "
                + " FROM freya1.administrators;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null){
            try{
                int iIdAdmin;
                String strName;
                String strLastName;
                String strEmail;
                AdminObject temp;
                
                while(result.next()){
                    iIdAdmin = result.getInt("idadmin");
                    strName = result.getString("name");
                    strLastName = result.getString("lastName");
                    strEmail = result.getString("email");
                    temp = new AdminObject(iIdAdmin, strName, strLastName, strEmail);
                    adminArray.add(temp);
                }
            } catch (SQLException ex){
                //Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(AdminLogic.class.getName()).log(Level.SEVERE, null, ex);
                //Logger.getLogger(ClientLogic.class.get).log(Level.SEVERE, null, ex);
            }
        }
        return adminArray;
    }
    
    public AdminObject getAdminByID (int pID){
        DatabaseX database = getDatabase();
        ArrayList<AdminObject> adminArray = new ArrayList<>();
        String sql = "select * from freya1.administrators where idadmin='"+pID+"';";
        ResultSet result = database.executeQuery(sql);
        
        AdminObject temp = null;
        
        if(result!=null){
            try{
                int iIdAdmin;
                String strName;
                String strLastName;
                String strEmail;
                
                while(result.next()){
                    iIdAdmin = result.getInt("idadmin");
                    strName = result.getString("name");
                    strLastName = result.getString("lastName");
                    strEmail = result.getString("email");
                    temp = new AdminObject(iIdAdmin, strName, strLastName, strEmail);
                    
                }
            } catch (SQLException ex){
                Logger.getLogger(AdminLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
    public int updateAdmin(int pId, String pName, String pLastname, String pEmail, 
            String pPassword){
        DatabaseX database = getDatabase();
        String sql = "UPDATE `freya1`.`administrators` SET `name` = '"+pName+"', "
                + "`lastName` = '"+pLastname+"', "
                + "`email` = '"+pEmail+"' "
                + "`contrasenia` = '"+pPassword+"' "
                + "WHERE (`idadmin` = '"+pId+"');";
        int rows = database.executeNonQueryRows(sql);
        
        return rows;
    }

    public int insertNewAdmin(String strName, String strLastName, String strEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
