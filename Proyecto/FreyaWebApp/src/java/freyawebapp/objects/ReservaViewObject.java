package freyawebapp.objects;

public class ReservaViewObject {
    private int idreserva;
    private String lastName;
    private String name;
    private int phoneNumber;
    private int tableID;
    private String horaReserva;

    public ReservaViewObject() {
    }
    
    public ReservaViewObject(int pReservaID, String pLastName, String pName, int pPhoneNumber, int pTableID, String pHoraReserva) {
        setReservaID(pReservaID);
        setLastName(pLastName);
        setName(pName);
        setPhoneNumber(pPhoneNumber);
        setTableID(pTableID);
        setHoraReserva(pHoraReserva);
    }

    public int getReservaID() {
        return idreserva;
    }

    private void setReservaID(int reservaID) {
        this.idreserva = reservaID;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTableID() {
        return tableID;
    }

    private void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    private void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }
}
