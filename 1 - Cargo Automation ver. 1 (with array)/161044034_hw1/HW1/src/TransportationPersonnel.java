/***
 * TransportationPersonnel class uses to create new personnel for transportation.
 */
public class TransportationPersonnel {

    private int id;
    private String name;
    private String password;

    public TransportationPersonnel(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
