/***
 * Branch class keeps information in the type branch employee, transportation personnel,
 *      customer with arrays and manages with their methods.
 */
public class Branch {

    private String name;
    private int employee_size;
    private int transporter_size;
    private int customer_size;

    private BranchEmployee[] employees;
    private TransportationPersonnel[] transporters;
    private Customer[] customers;

    public Branch(String name) {
        this.name = name;
        employee_size = 0;
        transporter_size = 0;
        customer_size = 0;
        customers = new Customer[customer_size+1];
        transporters = new TransportationPersonnel[transporter_size+1];
        employees = new BranchEmployee[employee_size+1];
    }

    public String getName() {
        return name;
    }

    public int getEmployee_size() {
        return employee_size;
    }

    public int getTransporter_size() {
        return transporter_size;
    }

    public int getCustomer_size() {
        return customer_size;
    }

    public BranchEmployee[] getEmployees() {
        return employees;
    }

    public void addBranchEmployee(BranchEmployee employee) {
        BranchEmployee[] temp = new BranchEmployee[employee_size+2];
        for (int i = 0; i < employee_size; i++) {
            temp[i] = employees[i];
        }
        temp[employee_size] = employee;
        this.employees = temp;
        employee_size++;
    }

    public void removeBranchEmployee(int index) {
        for (int i = index; i < employee_size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employee_size--;
    }
    public TransportationPersonnel[] getTransporters() {
        return transporters;
    }
    public void addTransportationPersonnel(TransportationPersonnel transporter) {
        TransportationPersonnel[] temp = new TransportationPersonnel[transporter_size+2];
        for (int i = 0; i < transporter_size; i++) {
            temp[i] = transporters[i];
        }
        temp[transporter_size] = transporter;
        this.transporters = temp;
        transporter_size++;
    }
    public void removeTransportationPersonnel(int index) {
        for (int i = index; i < transporter_size - 1; i++) {
            transporters[i] = transporters[i + 1];
        }
        transporter_size--;
    }
    public Customer[] getCustomers() {
        return customers;
    }
    public void addCustomer(Customer customer) {
        Customer[] temp = new Customer[customer_size+2];
        for (int i = 0; i < customer_size; i++) {
            temp[i] = customers[i];
        }
        temp[customer_size] = customer;
        this.customers = temp;
        customer_size++;
    }
    public void removeCustomer(int index) {
        for (int i = index; i < customer_size - 1; i++) {
            customers[i] = customers[i + 1];
        }
        customer_size--;
    }
}
