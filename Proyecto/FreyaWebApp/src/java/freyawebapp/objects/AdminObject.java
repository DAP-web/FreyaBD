package freyawebapp.objects;

public class AdminObject {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;

    public AdminObject() {
    }

    public AdminObject(int pId, String pName, String pLastname, String pEmail, String pPassword) {
        setId(pId);
        setName(pName);
        setLastname(pLastname);
        setEmail(pEmail);
        setPassword(pPassword);
    }

    public AdminObject(int iIdAdmin, String strName, String strLastName, String strEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
