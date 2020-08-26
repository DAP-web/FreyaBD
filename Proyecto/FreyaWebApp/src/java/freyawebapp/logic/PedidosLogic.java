
package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.PedidosObject;
import freyawebapp.objects.PedidosViewObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PedidosLogic extends Logic {

    public PedidosLogic() {
    }

    public PedidosLogic(String pConnectionString) {
        super(pConnectionString);
    }
   

    public int insertNewPedido(int pIdCliente, int pIdPlato)
    {
        DatabaseX database = getDatabase();
        String sql =  "INSERT INTO `freya1`.`reservas` "
                + "(`idpedidos`, `idCliente`, `idPlatillos`,) "
                + "VALUES (0, '"+pIdCliente+"', '"+pIdPlato+"'');";
        int rows = database.executeNonQueryRows(sql);
        return rows;       
    }
    
    public ArrayList<PedidosViewObject> getAllPedidos()
    {
        DatabaseX database = getDatabase();
        ArrayList<PedidosViewObject> pedidoArray = new ArrayList<>();
        String sql = "SELECT * FROM freya1.pedidos_view;";
        ResultSet result = database.executeQuery(sql);
        
        if (result !=null)
        {
            try
            {
                 int idpedido;
                String lastName;
                String name;
                String nombrePlatillo; 
                
              PedidosViewObject temp;
                
                while (result.next())
                {
                    idpedido = result.getInt("idpedido");
                    lastName = result.getString("lastName");
                    name = result.getString("name");
                    nombrePlatillo = result.getString("nombrePlatillo");
                    temp = new PedidosViewObject(idpedido, lastName, name, nombrePlatillo);
                    pedidoArray.add(temp);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(PedidosLogic.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }
        return pedidoArray;
        
        
    }
    
    public PedidosObject getPedidoByID (int pID) throws SQLException{
        DatabaseX database = getDatabase();
        PedidosViewObject pedidobj = new PedidosViewObject();
        String sql = "SELECT * FROM freya1.pedidos "
                + "WHERE idpedido = '"+pID+"';";
        ResultSet result = database.executeQuery(sql);
        
        PedidosObject temp = null;
        
        if (result!=null){
            try{
                int iId;
                int iIDCliente; 
                String strNombrePlatillo; 
                
                while (result.next()){
                    iId = result.getInt("idreserva");
                    iIDCliente = result.getInt("idCliente"); 
                    strNombrePlatillo = result.getString("nombrePlatillo");
                    
                }
        
            }catch (SQLException ex){
                Logger.getLogger(ReservaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return temp;
        
      
    }
     public int updatePedido(int pIDPedido, int pIDCliente, String pNombrePlatillos){
         DatabaseX database = getDatabase();
         String sql = "UPDATE `freya1`.`pedidos` "
                + "SET `idCliente` = '"+pIDCliente+"'"
                + "`nombrePlatillo` = '"+pNombrePlatillos+"' "
                + "WHERE (`idpedido` = '"+pIDPedido+"');";
         int rows = database.executeNonQueryRows(sql);
         
         return rows;   
    }
    
}
