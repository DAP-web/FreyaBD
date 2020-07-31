package freyawebapp.objects;

public class RestaurantObject {
    private int id;
    private String name;
    private String opens;
    private String closes;
    private String email;
    
    public RestaurantObject(int pId, String pName, String pOpens, 
            String pCloses, String pEmail) {
        setId(pId);
        setName(pName);
        setOpens (pOpens);
        setCloses(pCloses);
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

    public String getOpens() {
        return opens;
    }

    private void setOpens(String opens) {
        this.opens = opens;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
    
    public String getCloses() {
        return closes;
    }

    private void setCloses(String closes) {
        this.closes = closes;
    }
    
}
