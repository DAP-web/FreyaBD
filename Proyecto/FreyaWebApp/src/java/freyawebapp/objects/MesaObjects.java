
package freyawebapp.objects;


public class MesaObjects {
    private int id;
    private String tipo; 
    private String estado; 
    private int cantidad; 
    
    public MesaObjects (int pId, String pTipo, String pEstado, int pCantidad){
        setId(pId);
        setTipo(pTipo);
        setEstado(pEstado);
        setCantidad(pCantidad);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    private void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    private void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
