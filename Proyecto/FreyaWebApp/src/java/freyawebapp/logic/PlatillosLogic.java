
package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.PlatilloObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlatillosLogic extends Logic{

    public PlatillosLogic(String pConnectionString) {
        super(pConnectionString);
    }


    //CODIGO PARA INSERTAR NUEVO CLIENTE
    public int insertNewPlatillo (String pName, String pPrice, 
            String pDescription){
        //CONEXION A LA BASE DE DATOS
        DatabaseX database = getDatabase();
        //ENVIAR CODIGO PARA INSERTAR SQL
        String sql = "INSERT INTO `freya1`.`platillos` "
                + "(`idplatillos`, `nombrePlatillo`, `precio`, `detalle`) "
                + "VALUES (0, '"+pName+"', '"+pPrice+"', '"+pDescription+"');";
        //GET HOW MANY ROWS HAVE BEEN AFFECTED
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }

    public int deletePlatillo (int pID) {
        DatabaseX database = getDatabase();
        
        String sql = "DELETE FROM `freya1`.`platillos` "
                + "WHERE idplatillos = '"+pID+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public ArrayList<PlatilloObject> getAllPlatillos() {
        DatabaseX database = getDatabase();
        ArrayList<PlatilloObject> platilloArray = new ArrayList();
        String sql = "SELECT * FROM freya1.platillos;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null){
            try{
                int iId;
                String strName;
                double dPrice;
                String strDescription;
                PlatilloObject temp;
                
                while(result.next()){
                    iId = result.getInt("idplatillos");
                    strName = result.getString("nombrePlatillo");
                    dPrice = result.getDouble("precio");
                    strDescription = result.getString("detalle");
                    temp = new PlatilloObject(iId, strName, dPrice, strDescription );
                    platilloArray.add(temp);
                }
            } catch (SQLException ex){
                Logger.getLogger(PlatillosLogic.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        return platilloArray;
    }
    
    public PlatilloObject getPlatilloByID (int pID){
        DatabaseX database = getDatabase();
        ArrayList<PlatilloObject> platilloArray = new ArrayList<>();
        String sql = "select * from freya1.platillos where idplatillos="+pID+";";
        ResultSet result = database.executeQuery(sql);
        
        PlatilloObject temp = null;
        
        if(result!=null){
            try{
                int iId;
                String strName;
                double dPrice;
                String strDescription;
                
                while(result.next()){
                    iId = result.getInt("idplatillos");
                    strName = result.getString("nombrePlatillo");
                    dPrice = result.getDouble("precio");
                    strDescription = result.getString("detalle");
                    temp = new PlatilloObject(iId, strName, dPrice, strDescription);
                    
                }
            } catch (SQLException ex){
                Logger.getLogger(PlatillosLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
    public int updateClient(int pId, String pName, String pPrice, 
            String pDescription){
        DatabaseX database = getDatabase();
        String sql = "UPDATE `freya1`.`platillos` "
                + "SET `nombrePlatillo` = '"+pName+"', `precio` = '"+pPrice+"', "
                + "`detalle` = '"+pDescription+"' "
                + "WHERE (`idplatillos` = '"+pId+"');";
        int rows = database.executeNonQueryRows(sql);
        
        return rows;
    }
    
}


