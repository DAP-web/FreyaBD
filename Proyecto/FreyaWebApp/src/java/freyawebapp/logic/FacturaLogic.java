package freyawebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import freyawebapp.objects.FacturaViewObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacturaLogic extends Logic{

    public FacturaLogic(String pConnectionString) {
        super(pConnectionString);
    }
    
    public int insertarFactura (int pIdRestaurante, int pIdDireccion, 
            int pIdCliente, String pFecha, String pHora, 
            double pIva, int pFastPass, double pTotal){
        DatabaseX database = getDatabase();
        String sql = "INSERT INTO `freya1`.`factura` "
                + "(`idfactura`, `idRestaurante`, `idDireccion`, `idCliente`, "
                + "`fecha`, `hora`, `IVA`, `fastpass`, `total`) "
                + "VALUES (0, '"+pIdRestaurante+"', '"+pIdDireccion+"', '"+pIdCliente+"', '"+pFecha+"', "
                + "'"+pHora+"', 0.13 , '"+pFastPass+"', '"+pTotal+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;  
    }
    
    public ArrayList<FacturaViewObject> getAllFacturas() 
    {
        DatabaseX database = getDatabase();
        ArrayList<FacturaViewObject> facturasArray = new ArrayList<>();
        String sql = "SELECT * FROM freya1.facturacomplete;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                
                int idfactura;
                String restaurante;
                String ubicacion;
                String name;
                String lastname;
                String date;
                String time;
                double iva;
                int fastpass;
                double total;      
                
                FacturaViewObject temp;
                
                while(result.next())
                {
                    idfactura = result.getInt("idFactura");
                    restaurante = result.getString("Restaurante");
                    ubicacion = result.getString("Ubicacion");
                    name = result.getString("name");
                    lastname = result.getString("lastName");
                    date = result.getString("Date");
                    time = result.getString("Time");
                    iva = result.getDouble("IVA");
                    fastpass = result.getInt("fastPass");
                    total = result.getDouble("Total");
                    
                    temp = new FacturaViewObject(idfactura, restaurante, ubicacion, 
                            name, lastname, date, time, iva, fastpass, total);
                    facturasArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ReservaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return facturasArray;        
        
    }
    
}
