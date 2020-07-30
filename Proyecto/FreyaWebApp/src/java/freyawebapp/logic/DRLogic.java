
package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.DRObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DRLogic extends Logic{

    public DRLogic(String pConnectionString) {
        super(pConnectionString);
    }
    //CODIGO PARA INSERTAR NUEVO CLIENTE
    public int insertNewDR (String pLocalizacion, String pCodigoPostal, 
            String pNumeroTelefono){
        //CONEXION A LA BASE DE DATOS
        DatabaseX database = getDatabase();
        //ENVIAR CODIGO PARA INSERTAR SQL
        String sql = "INSERT INTO `freya1`.`direccionesrestaurante` "
                + "(`iddireccion`, `localizacion`, `codigoPostal`, `numeroTelefono')"
                + "VALUES (0, '"+pLocalizacion+"', '"+pCodigoPostal+"', "
                + "'"+pNumeroTelefono+"');";
        //GET HOW MANY ROWS HAVE BEEN AFFECTED
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    public int deleteDR (int pID) {
        DatabaseX database = getDatabase();
        
        String sql = "DELETE FROM `freya1`.`direccionesrestaurante` "
                + "WHERE iddireccion = '"+pID+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public ArrayList<DRObject> getAllDR() {
        DatabaseX database = getDatabase();
        ArrayList<DRObject> dRArray = new ArrayList();
        String sql = "SELECT idDireccion, localizacion, codigoPostal, "
                + "numeroTelefono FROM freya1.direccionesrestaurante;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null){
            try{
                int iIdDireccion;
                String strLocalizacion;
                int iCodigoPostal;
                int iNumeroTelefono;
                DRObject temp;
                
                while(result.next()){
                    iIdDireccion = result.getInt("idDireccion");
                    strLocalizacion = result.getString("localizacion");
                    iCodigoPostal = result.getInt("codigoPostal");
                    iNumeroTelefono = result.getInt("numeroTelefono");
                    temp = new DRObject(iIdDireccion, strLocalizacion, iCodigoPostal, iNumeroTelefono);
                    dRArray.add(temp);
                }
            } catch (SQLException ex){
                //Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(DRLogic.class.getName()).log(Level.SEVERE, null, ex);
                //Logger.getLogger(ClientLogic.class.get).log(Level.SEVERE, null, ex);
            }
        }
        return dRArray;
    }
    
    public DRObject getDRByID (int pID){
        DatabaseX database = getDatabase();
        ArrayList<DRObject> dRArray = new ArrayList<>();
        String sql = "select * from freya1.direccionesrestaurante where idDireccion="+pID+";";
        ResultSet result = database.executeQuery(sql);
        
        DRObject temp = null;
        
        if(result!=null){
            try{
                int iIdDireccion;
                String strLocalizacion;
                int iCodigoPostal;
                int iNumeroTelefono;
                
                while(result.next()){
                    iIdDireccion = result.getInt("iddireccion");
                    strLocalizacion = result.getString("localizacion");
                    iCodigoPostal = result.getInt("codigoPostal");
                    iNumeroTelefono = result.getInt("numeroTelefono");
                    temp = new DRObject(iIdDireccion, strLocalizacion, iCodigoPostal, iNumeroTelefono);
                    
                }
            } catch (SQLException ex){
                Logger.getLogger(DRLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
    public int updateDR(int pId, String pLocalizacion, String pCodigoPostal, 
            String pNumeroTelefono){
        DatabaseX database = getDatabase();
        String sql = "UPDATE `freya1`.`direccionesrestaurante` SET `localizacion` = '"+pLocalizacion+"', "
                + "`apellido` = '"+pCodigoPostal+"', "
                + "`numeroTelefono` = '"+pNumeroTelefono+"' "
                + "WHERE (`iddireccion` = '"+pId+"');";
        int rows = database.executeNonQueryRows(sql);
        
        return rows;
    }
    
}
