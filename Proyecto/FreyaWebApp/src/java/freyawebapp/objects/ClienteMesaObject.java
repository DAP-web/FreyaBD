package freyawebapp.objects;

public class ClienteMesaObject {
    private int id;
    private int idCliente;
    private int idMesa;
    private String horaReserva;

    public ClienteMesaObject(int pId, int pIdCliente, int pIdMesa, String pHoraReserva) {
        setId(pId);
        setIdCliente(pIdCliente);
        setIdMesa(pIdMesa);
        setHoraReserva(pHoraReserva);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    private void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMesa() {
        return idMesa;
    }

    private void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    private void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }
    
    
}
