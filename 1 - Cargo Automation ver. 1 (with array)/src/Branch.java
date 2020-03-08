import java.util.ArrayList;

/***
 * Branch class keeps information in the type branch employee, transportation personnel,
 *      customer with arrays and manages with their methods.
 */
public class Branch {

    private String name;
    private ArrayList<BranchEmployee>  employees;
    private ArrayList<TransportationPersonnel>  transporters;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
        transporters = new ArrayList<>();
        employees = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public ArrayList<BranchEmployee> getEmployees() {
        return employees;
    }
    public ArrayList<TransportationPersonnel> getTransporters() {
        return transporters;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
