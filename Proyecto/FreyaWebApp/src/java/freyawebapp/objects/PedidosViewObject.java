
package freyawebapp.objects;

public class PedidosViewObject {
    private int idpedidos;
    private String lastName;
    private String name;
    private String nombrePlato;

    
    public PedidosViewObject(int pPedidosID, String pLastName, String pName, String pNombrePlatillo) {
        setPedidosID(pPedidosID);
        setLastName(pLastName);
        setName(pName);
        setNombrePlato(pNombrePlatillo);
    }

    public PedidosViewObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getPedidosID() {
        return idpedidos;
    }

    private void setPedidosID(int pedidosID) {
        this.idpedidos = pedidosID;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    private void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
}

    

