/***
 * BranchEmployee class uses to create new employee for branch.
 */
public class BranchEmployee {

    private int id;
    private String name;
    private String password;

    public BranchEmployee(int id, String name, String password) {
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