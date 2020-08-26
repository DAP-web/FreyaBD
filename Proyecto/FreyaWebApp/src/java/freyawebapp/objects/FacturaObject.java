package freyawebapp.objects;

public class FacturaObject {
    private int id;
    private int idRestaurante;
    private int idDireccion;
    private int idCliente;
    private String fecha;
    private String hora;
    private double iva;
    private int fastPass;
    private double total;

    public FacturaObject(int pId, int pIdRestaurante, int pIdDireccion, 
            int pIdCliente, String pFecha, String pHora, 
            double pIva, int pFastPass, double pTotal) {
        setId(pId);
        setIdRestaurante(pIdRestaurante);
        setIdDireccion(pIdDireccion);
        setIdCliente(pIdCliente);
        setFecha(pFecha);
        setHora(pHora);
        setIva(pIva);
        setFastPass(pFastPass);
        setTotal(pTotal);
    }

    public FacturaObject() {
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    private void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    private void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    private void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    private void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    private void setHora(String hora) {
        this.hora = hora;
    }

    public double getIva() {
        return iva;
    }

    private void setIva(double iva) {
        this.iva = iva;
    }

    public int getFastPass() {
        return fastPass;
    }

    private void setFastPass(int fastPass) {
        this.fastPass = fastPass;
    }

    public double getTotal() {
        return total;
    }

    private void setTotal(double total) {
        this.total = total;
    }
    
    
}
