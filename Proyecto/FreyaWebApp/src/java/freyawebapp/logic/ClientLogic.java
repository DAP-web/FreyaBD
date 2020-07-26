package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.ClientObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientLogic extends Logic{

    public ClientLogic(String pConnectionString) {
        super(pConnectionString);
    }
    //CODIGO PARA INSERTAR NUEVO CLIENTE
    public int insertNewClient (String pName, String pLastName, 
            String pNumeroTelefono, String pEmail, String pPassword){
        //CONEXION A LA BASE DE DATOS
        DatabaseX database = getDatabase();
        //ENVIAR CODIGO PARA INSERTAR SQL
        String sql = "INSERT INTO `freya1`.`cliente` "
                + "(`idcliente`, `nombre`, `apellido`, `numeroTelefono`,"
                + " `correoElectronico`, `contrasenia`) "
                + "VALUES (0, '"+pName+"', '"+pLastName+"', "
                + "'"+pNumeroTelefono+"', '"+pEmail+"', '"+pPassword+"');";
        //GET HOW MANY ROWS HAVE BEEN AFFECTED
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    public int deleteCliente (int pID) {
        DatabaseX database = getDatabase();
        
        String sql = "DELETE FROM `freya1`.`cliente` "
                + "WHERE idcliente = '"+pID+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public ArrayList<ClientObject> getAllClients() {
        DatabaseX database = getDatabase();
        ArrayList<ClientObject> clientArray = new ArrayList();
        String sql = "SELECT idcliente, nombre, apellido, numeroTelefono, correoElectronico FROM freya1.cliente;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null){
            try{
                int iId;
                String strName;
                String strLastName;
                int iPhoneNumber;
                String strEmail;
                ClientObject temp;
                
                while(result.next()){
                    iId = result.getInt("idcliente");
                    strName = result.getString("nombre");
                    strLastName = result.getString("apellido");
                    iPhoneNumber = result.getInt("numeroTelefono");
                    strEmail = result.getString("correoElectronico");
                    temp = new ClientObject(iId, strName, strLastName, iPhoneNumber, strEmail);
                    clientArray.add(temp);
                }
            } catch (SQLException ex){
                //Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientArray;
    }
    
}
