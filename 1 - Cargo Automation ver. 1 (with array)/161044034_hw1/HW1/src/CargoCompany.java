/***
 * CargoCompany class keeps information in the type administrators, branches with arrays and manages with their methods.
 */
public class CargoCompany {

    private int admin_size;
    private int branch_size;
    private String name;
    private Administrator[] administrators;
    private Branch[] branches;

    public CargoCompany(String name) {
        admin_size = 0;
        branch_size = 0;
        administrators = new Administrator[admin_size+1];
        branches = new Branch[branch_size+1];
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Branch[] getBranches() {
        return branches;
    }
    public void addBranch(Branch branch) {
        Branch[] temp = new Branch[branch_size+2];
        for (int i = 0; i < branch_size; i++) {
            temp[i] = branches[i];
        }
        temp[branch_size] = branch;
        this.branches = temp;
        branch_size++;
    }
    public void removeBranch(int index) {
        for (int i = index; i < branch_size - 1; i++) {
            branches[i] = branches[i + 1];
        }
        branch_size--;
    }
    public int getBranch_size() {
        return branch_size;
    }

    public Administrator[] getAdministrators() {
        return administrators;
    }
    public void addAdministrator(Administrator administrator) {
        Administrator[] temp = new Administrator[admin_size+2];
        for (int i = 0; i < admin_size; i++) {
            temp[i] = administrators[i];
        }
        temp[admin_size] = administrator;
        this.administrators = temp;
        admin_size++;
    }

    public int getAdmin_size() {
        return admin_size;
    }
    /**
     * testCode uses to make a demo with cargo system
     */

    public void testCode(){
        addBranch(new Branch("Branch 1"));
        addBranch(new Branch("Branch 2"));
        branches[0].addBranchEmployee(new BranchEmployee(101,"Employee 1","101"));
        branches[0].addBranchEmployee(new BranchEmployee(102,"Employee 2","102"));
        branches[1].addBranchEmployee(new BranchEmployee(103,"Employee 3","103"));
        branches[1].addBranchEmployee(new BranchEmployee(104,"Employee 4","104"));
        branches[0].addTransportationPersonnel(new TransportationPersonnel(201,"Transporter 1","201"));
        branches[0].addTransportationPersonnel(new TransportationPersonnel(202,"Transporter 2","202"));
        branches[1].addTransportationPersonnel(new TransportationPersonnel(203,"Transporter 3","203"));
        branches[1].addTransportationPersonnel(new TransportationPersonnel(204,"Transporter 4","204"));
        branches[0].addCustomer(new Customer("Customer 1",new Shipment(301,"Sender 1","Receiver 1","Branch 1",false)));
        branches[0].addCustomer(new Customer("Customer 2",new Shipment(302,"Sender 2","Receiver 2","Branch 1",false)));
        branches[1].addCustomer(new Customer("Customer 1",new Shipment(303,"Sender 3","Receiver 3","Branch 2",false)));
        branches[1].addCustomer(new Customer("Customer 1",new Shipment(304,"Sender 4","Receiver 4","Branch 2",false)));
    }
}
