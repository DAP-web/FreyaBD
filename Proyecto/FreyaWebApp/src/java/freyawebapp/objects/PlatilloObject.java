
package freyawebapp.objects;

public class PlatilloObject {
    private int id;
    private String name;
    private int price;
    private String description;

    
    public PlatilloObject(int pId, String pName, int pPrice, String pDescription) {
        setId(pId);
        setName(pName);
        setPrice(pPrice);
        setDescription(pDescription);
  
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


    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }


    
}


    
