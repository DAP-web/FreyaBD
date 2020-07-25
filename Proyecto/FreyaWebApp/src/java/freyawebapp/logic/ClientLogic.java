package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

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
    
}
