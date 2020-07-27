package freyawebapp.objects;

public class ClientObject {
    private int id;
    private String name;
    private String lastname;
    private int numeroTelefono;
    private String email;
    private String password;
    
    public ClientObject(int pId, String pName, String pLastname, 
            int pNumeroTelefono, String pEmail, String pPassword) {
        setId(pId);
        setName(pName);
        setLastname(pLastname);
        setNumeroTelefono(pNumeroTelefono);
        setEmail(pEmail);
        setPassword(pPassword);
    }
    
    public ClientObject(int pId, String pName, String pLastname, 
            int pNumeroTelefono, String pEmail) {
        setId(pId);
        setName(pName);
        setLastname(pLastname);
        setNumeroTelefono(pNumeroTelefono);
        setEmail(pEmail);
    }  

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
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

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    private void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
    
    
}
