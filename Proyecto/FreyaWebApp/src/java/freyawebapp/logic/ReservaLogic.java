package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.ReservaObject;
import freyawebapp.objects.ReservaViewObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReservaLogic extends Logic{

    public ReservaLogic(String pConnectionString) {
        super(pConnectionString);
    }
    public int insertNewReserva(int pIdCliente, int pIdMesa, String pHorareserva)
    {
        DatabaseX database = getDatabase();
        String sql = "INSERT INTO `freya1`.`reservas` "
                + "(`idreserva`, `idCliente`, `idMesa`, `horaReserva`) "
                + "VALUES (0, '"+pIdCliente+"', '"+pIdMesa+"', '"+pHorareserva+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public int deleteReserva (int pIdReserva){
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM `freya1`.`reservas` "
                + "WHERE (`idreserva` = '"+pIdReserva+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public ArrayList<ReservaViewObject> getAllReservas() 
    {
        DatabaseX database = getDatabase();
        ArrayList<ReservaViewObject> reservaArray = new ArrayList<>();
        String sql = "SELECT * FROM freya1.reservas_view;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                
                int idreserva;
                String lastName;
                String name;
                int phoneNumber;
                int tableID;
                String horaReserva;               
                
                ReservaViewObject temp;
                
                while(result.next())
                {
                    idreserva = result.getInt("idreserva");
                    lastName = result.getString("lastName");
                    name = result.getString("name");
                    phoneNumber = result.getInt("phoneNumber");
                    tableID = result.getInt("tableID");
                    horaReserva = result.getString("horaReserva");
                    temp = new ReservaViewObject(idreserva, lastName, name, phoneNumber, tableID, horaReserva);
                    reservaArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ReservaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return reservaArray;        
        
    }
    
    public ReservaObject getReservaByID(int pID){
        DatabaseX database = getDatabase();
        ReservaViewObject reservaobj = new ReservaViewObject();
        String sql = "SELECT * FROM freya1.reservas "
                + "WHERE idreserva = '"+pID+"';";
        ResultSet result = database.executeQuery(sql);
        
        ReservaObject temp = null;
        
        if(result!=null){
            try{
                int iId;
                int iIDCliente;
                int iTableID;
                String strHoraReserva;
                
                while(result.next()){
                    iId = result.getInt("idreserva");
                    iIDCliente = result.getInt("idCliente");
                    iTableID = result.getInt("idMesa");
                    strHoraReserva = result.getString("horaReserva");
                    temp = new ReservaObject(iId, iIDCliente, iTableID, strHoraReserva);
                    
                }
            } catch (SQLException ex){
                Logger.getLogger(ReservaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
    public int updateReserva(int pIDReserva, int pIDCliente, int pIDMesa, 
            String pHoraReserva){
        DatabaseX database = getDatabase();
        String sql = "UPDATE `freya1`.`reservas` "
                + "SET `idCliente` = '"+pIDCliente+"', `idMesa` = '"+pIDMesa+"', "
                + "`horaReserva` = '"+pHoraReserva+"' "
                + "WHERE (`idreserva` = '"+pIDReserva+"');";
        int rows = database.executeNonQueryRows(sql);
        
        return rows;
    }
}
