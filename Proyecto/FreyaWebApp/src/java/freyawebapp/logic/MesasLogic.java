package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.MesaObjects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MesasLogic extends Logic {
    
    public MesasLogic(String pConnectionString) {
        super(pConnectionString);
    }
     //Codigo para insertar nueva mesa
    public int insertNewMesa ( String pTipo, String pEstado, int pCantidad){
       // Conexión a la base de datos 
       DatabaseX database = getDatebase ();
       //Enviar el código para insertar SQL 
               String sql = "INSERT INTO `freya1`.`mesas`"
                      + "(`idmesas`, `tipo`, `estado`, `cantidad`) "
                      + "VALUES (0, '"+pTipo+"', '"+pEstado+"', '"+pCantidad+"');"; 
        //Get 
        int rows = database.executeNonQueryRows(sql);
        return rows; 
    }
    public int deleteMesas (int pID){
        DatabaseX database = getDatabase();
        
        String sql = "DELETE FROM `freya1`.`mesas`"
                + " WHERE idmesas = '"+pID+"');"; 
        int rows = database.executeNonQueryRows(sql);
        return rows; 
    }
    public ArrayList<MesaObjects> getAllMesas() {
        DatabaseX database = getDatabase();
        ArrayList<MesaObjects> mesasArray = new ArrayList();
        String sql = "SELECT idMesasa, tipo, estado, cantidad FROM freya1.mesas;";
        ResultSet result = database.executeQuery(sql);
        
            if (result!=null){
                try{
                    int iId;
                    String strTipo;
                    String strEstado;
                    int iCantidad;
                    MesaObjects temp; 
                    
                    while(result.next()){
                        iId = result.getInt("idmesas");
                        strTipo = result.getString("tipo");
                        strEstado = result.getString("estado");
                        iCantidad = result.getInt("cantidad");
                        temp = new MesaObjects(iId, strTipo, strEstado, iCantidad);
                        mesasArray.add(temp);
                    }
                } catch (SQLException ex) {
                Logger.getLogger(MesasLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        return mesasArray;
       
                      
    }

    private DatabaseX getDatebase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
