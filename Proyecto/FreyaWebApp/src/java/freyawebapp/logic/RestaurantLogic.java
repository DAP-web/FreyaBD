package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.RestaurantObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantLogic extends Logic{

    public RestaurantLogic(String pConnectionString) {
        super(pConnectionString);
    }
    
    //CODIGO PARA INSERTAR NUEVO RESTAURANTE
    public int insertNewRestaurant (String pName, String pOpens, String pCloses, String pEmail){
        //CONEXION A LA BASE DE DATOS
        DatabaseX database = getDatabase();
        //ENVIAR CODIGO PARA INSERTAR SQL
        String sql = "INSERT INTO `freya1`.`restaurante` "
                + "(`idRestaurante`, `nombre`, `horaApertura`, `horaCierre`,"
                + " `correoElectronico`) "
                + "VALUES (0, '"+pName+"', '"+pOpens+"', "
                + "'"+pCloses+"', '"+pEmail+"');";
        //GET HOW MANY ROWS HAVE BEEN AFFECTED
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public int deleteRestaurant (int pID) {
        DatabaseX database = getDatabase();
        
        String sql = "DELETE FROM `freya1`.`restaurante` "
                + "WHERE idRestaurante = '"+pID+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public ArrayList<RestaurantObject> getAllRestaurants() {
        DatabaseX database = getDatabase();
        ArrayList<RestaurantObject> restaurantArray = new ArrayList();
        String sql = "SELECT * FROM freya1.restaurante;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null){
            try{
                int iId;
                String strName;
                String strOpens;
                String strCloses;
                String strEmail;
                RestaurantObject temp;
                
                while(result.next()){
                    iId = result.getInt("idRestaurante");
                    strName = result.getString("nombre");
                    strEmail = result.getString("correoElectronico");
                    strCloses = result.getString("horaCierre");
                    strOpens = result.getString("horaApertura");
                    temp = new RestaurantObject(iId, strName, strOpens, strCloses, strEmail);
                    restaurantArray.add(temp);
                }
            } catch (SQLException ex){
                Logger.getLogger(RestaurantLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return restaurantArray;
    }
    
    public RestaurantObject getRestaurantByID (int pID){
        DatabaseX database = getDatabase();
        ArrayList<RestaurantObject> restaurantArray = new ArrayList<>();
        String sql = "select * from freya1.restaurante where idRestaurante="+pID+";";
        ResultSet result = database.executeQuery(sql);
        
        RestaurantObject temp = null;
        
        if(result!=null){
            try{
                int iId;
                String strName;
                String strEmail;
                String iOpens;
                String iCloses;
                
                while(result.next()){
                    iId = result.getInt("idRestaurante");
                    strName = result.getString("nombre");
                    strEmail = result.getString("correoElectronico");
                    iCloses = result.getString("horaCierre");
                    iOpens = result.getString("horaApertura");
                    temp = new RestaurantObject(iId, strName, iOpens, iCloses, strEmail);
                    
                }
            } catch (SQLException ex){
                Logger.getLogger(RestaurantLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
    public int updateRestaurant(int pId, String pName, String pOpens, 
            String pCloses, String pEmail){
        DatabaseX database = getDatabase();
        String sql = "UPDATE `freya1`.`restaurante` "
                + "SET `nombre` = '"+pName+"', "
                + "`horaApertura` = '"+pOpens+"', "
                + "`horaCierre` = '"+pCloses+"', "
                + "`correoElectronico` = '"+pEmail+"' "
                + "WHERE (`idRestaurante` = '"+pId+"');";
        int rows = database.executeNonQueryRows(sql);
        
        return rows;
    }
/*
    public int insertNewRestaurant(String strName, String iOpens, String iCloses, String strEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateRestaurant(int iID, String strName, String iOpens, String iCloses, String strEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
}
