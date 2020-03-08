/***
 * Administrator class uses to create new administrator.
 */
public class Administrator {

    private int id;
    private String name;
    private String password;

    public Administrator(int id, String name, String password) {
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
