
package freyawebapp.objects;


public class PedidosObject {
    private int idpedido;
    private int idCliente;
    private int idPlato;
    
    public PedidosObject (int pId, int pIdCliente, int pIdPlato){
        setId(pId);
        setIdCliente(pIdCliente);
        setIdPlato(pIdPlato);

        
    }
    public int geitId(){
        return idpedido;
    }

    private void setId(int id){
        this.idpedido = id;
    }
    
    public int getCliente() {
        return idCliente;
    }
    
    private void setIdCliente (int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getIdPlatillo () {
       return idPlato; 
    }
    
    private void setIdPlato (int idPlato) {
        this.idPlato = idPlato;
    }
    
}
