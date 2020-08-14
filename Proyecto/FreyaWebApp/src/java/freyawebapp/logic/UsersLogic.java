package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.AdminObject;
import freyawebapp.objects.ClientObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersLogic extends Logic{

    public UsersLogic(String pConnectionString) {
        super(pConnectionString);
    }
           
    public ClientObject getClientByEmail(String pEmail) {
        DatabaseX database = getDatabase();
        String sql = "SELECT * FROM freya1.cliente "
                + "WHERE correoElectronico = '"+pEmail+"';";
        ResultSet result = database.executeQuery(sql);
        ClientObject temp = null;
        
        if(result!=null){
            try{
                int iId;
                String strName;
                String strLastName;
                int iPhoneNumber;
                String strEmail;
                String strPassword;
                
                while(result.next()){
                    iId = result.getInt("idcliente");
                    strName = result.getString("nombre");
                    strLastName = result.getString("apellido");
                    iPhoneNumber = result.getInt("numeroTelefono");
                    strEmail = result.getString("correoElectronico");
                    strPassword = result.getString("contrasenia");
                    temp = new ClientObject(iId, strName, strLastName, iPhoneNumber,strEmail, strPassword);
                    
                }
            } catch (SQLException ex){
                Logger.getLogger(UsersLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
    public AdminObject getAdminByEmail(String pEmail) {
        DatabaseX database = getDatabase();
        String sql = "SELECT * FROM freya1.administrators "
                + "WHERE email = '"+pEmail+"';";
        ResultSet result = database.executeQuery(sql);
        AdminObject temp = null;
        
        if(result!=null){
            try{
                int id;
                String name;
                String lastname;
                String email;
                String password;
                
                while(result.next()){
                    id = result.getInt("idadmin");
                    name = result.getString("name");
                    lastname = result.getString("lastName");
                    email = result.getString("email");
                    password = result.getString("password");
                    temp = new AdminObject(id, name, lastname, email, password);
                    
                }
            } catch (SQLException ex){
                Logger.getLogger(UsersLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
}
