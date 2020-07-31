package freyawebapp.objects;

public class RestaurantObject {
    private int id;
    private String name;
    private int opens;
    private int closes;
    private String email;
    
    public RestaurantObject(int pId, String pName, int pOpens, 
            int pCloses, String pEmail) {
        setId(pId);
        setName(pName);
        setOpens (pOpens);
        setCloses(pCloses);
        setEmail(pEmail);
    } 

    public RestaurantObject(int iId, String strName, int iPhoneNumber, int iOpens, int iCloses) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RestaurantObject(int iId, String strName, String strEmail, int iOpens, int iCloses) {
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

    public int getOpens() {
        return opens;
    }

    private void setOpens(int opens) {
        this.opens = opens;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
    
        public int getCloses() {
        return closes;
    }

    private void setCloses(int closes) {
        this.closes = closes;
    }
    
}
