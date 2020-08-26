package freyawebapp.objects;

public class FacturaViewObject {
    private int id;
    private String restaurante;
    private String ubicacion;
    private String name;
    private String lastname;
    private String date;
    private String time;
    private double iva;
    private int fastpass;
    private double total;

    public FacturaViewObject(int pId, String pRestaurante, String pUbicacion, 
            String pName, String pLastname, String pDate, 
            String pTime, double pIva, int pFastpass, double pTotal) {
        setId(pId);
        setRestaurante(pRestaurante);
        setUbicacion(pUbicacion);
        setName(pName);
        setLastname(pLastname);
        setDate(pDate);
        setTime(pTime);
        setIva(pIva);
        setFastpass(pFastpass);
        setTotal(pTotal);
    }

    public FacturaViewObject() {
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getRestaurante() {
        return restaurante;
    }

    private void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    private void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        return date;
    }

    private void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    private void setTime(String time) {
        this.time = time;
    }

    public double getIva() {
        return iva;
    }

    private void setIva(double iva) {
        this.iva = iva;
    }

    public int getFastpass() {
        return fastpass;
    }

    private void setFastpass(int fastpass) {
        this.fastpass = fastpass;
    }

    public double getTotal() {
        return total;
    }

    private void setTotal(double total) {
        this.total = total;
    }
}
