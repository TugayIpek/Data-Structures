import java.util.ArrayList;
import java.util.Scanner;

/***
 * CargoCompany class keeps information in the type administrators, branches with arrays and manages with their methods.
 */
public class CargoCompany {

    private String name;
    private ArrayList<Administrator> administrators;
    private ArrayList<Branch> branches;

    public CargoCompany(String name) {
        administrators = new ArrayList<>();
        branches = new ArrayList<>();
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /*Admin Operations*/
    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }
    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
    }
    /*Admin Operations*/

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void startTheSystem() {
        Scanner input = new Scanner(System.in);
        int choice = 3;
        while(choice != 0){
            System.out.println("\nWelcome to The Cargo Automation System");
            System.out.println(getName() + "Cargo Company");
            System.out.println("(1) Login");
            System.out.println("(2) Cargo Inquiry");
            System.out.println("(0) Exit");
            System.out.print("Choice: ");
            try{
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("\nYour choice must be an integer value !");
                input.nextLine();
            }
            if(choice == 1){
                loginScreen();
            }else if(choice == 2){
                cargoInquiry();
            }else if(choice == 0){
                System.out.println("System is shutting down..");
            }else{
                System.out.println("\nPlease Try Again\n");
            }
        }
    }

    public void loginScreen() {
        boolean access = false;
        Scanner input = new Scanner(System.in);
        System.out.println("\nCompany Personnel Screen");
        System.out.println("Please enter your ID and password.\n");
        while(!access){
            System.out.print("ID: ");
            String id = input.next();
            System.out.print("Password: ");
            String password = input.next();

            for (int i = 0; i < getAdministrators().size(); i++) {
                if (id.compareTo(getAdministrators().get(i).getId()) == 0 &&
                        password.compareTo(getAdministrators().get(i).getPassword()) == 0){
                    System.out.println("Access Granted\n");
                    System.out.println("Welcome " + getAdministrators().get(i).getName());
                    administrators.get(i).menu();
                    access = true;
                    break;
                }
            }
            if (!access){
                for (Branch branch : branches) {
                    for (int j = 0; j < branch.getEmployees().size(); j++) {
                        if (id.compareTo(branch.getEmployees().get(j).getId()) == 0 &&
                                password.compareTo(branch.getEmployees().get(j).getPassword()) == 0) {
                            System.out.println("Access Granted\n");
                            System.out.println("Welcome " + branch.getEmployees().get(j).getName());
                            branch.getEmployees().get(j).menu();
                            access = true;
                            break;
                        }
                    }
                }
            }
            if (!access){
                for (Branch branch : branches) {
                    for (int j = 0; j < branch.getTransporters().size(); j++) {
                        if (id.compareTo(branch.getTransporters().get(j).getId()) == 0 &&
                                password.compareTo(branch.getTransporters().get(j).getPassword()) == 0) {
                            System.out.println("Access Granted\n");
                            System.out.println("Welcome " + branch.getTransporters().get(j).getName());
                            branch.getTransporters().get(j).menu();
                            access = true;
                            break;
                        }
                    }
                }
            }
            if(!access){
                System.out.println("Access Denied\n");
                access = true;
            }
        }
    }

    public void cargoInquiry(){
        Scanner input = new Scanner(System.in);
        boolean found = false;
        int shipment_number = -1;
        System.out.println("\nPlease enter your shipment number.");
        System.out.print("Shipment Number: ");
        try {
            shipment_number = input.nextInt();
        }catch (Exception e){
            System.out.println("\nShipment number must be an integer value !");
            input.nextLine();
        }
        for (Branch branch : branches) {
            for (int j = 0; j < branch.getCustomers().size(); j++) {
                if (shipment_number == branch.getCustomers().get(j).getShipment().getShip_number()) {
                    System.out.println("Shipment found\n");
                    branch.getCustomers().get(j).menu();
                    found = true;
                    break;
                }
            }
        }
        if(!found && shipment_number >= 0){
            System.out.println("Shipment is not found !\n");
        }
    }


    /**
     * testCode uses to make a demo with cargo system
     */

   public void testCode(){
        administrators.get(0).addBranch(new Branch("Branch 1"));
        administrators.get(0).addBranch(new Branch("Branch 2"));
        administrators.get(0).addBranchEmployee(0, new BranchEmployee("101","Employee 1","101", branches.get(0)));
        administrators.get(0).addBranchEmployee(0, new BranchEmployee("102","Employee 2","102", branches.get(0)));
        administrators.get(0).addBranchEmployee(1, new BranchEmployee("103","Employee 3","103", branches.get(1)));
        administrators.get(0).addBranchEmployee(1, new BranchEmployee("104","Employee 4","104", branches.get(1)));
        administrators.get(0).addTransportationPersonnel(0, new TransportationPersonnel("201","Transporter 1","201", branches.get(0)));
        administrators.get(0).addTransportationPersonnel(0, new TransportationPersonnel("202","Transporter 2","202", branches.get(0)));
        administrators.get(0).addTransportationPersonnel(1, new TransportationPersonnel("203","Transporter 3","203", branches.get(1)));
        administrators.get(0).addTransportationPersonnel(1, new TransportationPersonnel("204","Transporter 4","204", branches.get(1)));
        branches.get(0).getEmployees().get(0).addCustomer(new Customer("Customer 1",new Shipment(301,"Sender 1","Receiver 1","Branch 1",false)));
        branches.get(0).getEmployees().get(0).addCustomer(new Customer("Customer 2",new Shipment(302,"Sender 2","Receiver 2","Branch 1",false)));
        branches.get(1).getEmployees().get(0).addCustomer(new Customer("Customer 3",new Shipment(303,"Sender 3","Receiver 3","Branch 2",false)));
        branches.get(1).getEmployees().get(0).addCustomer(new Customer("Customer 4",new Shipment(304,"Sender 4","Receiver 4","Branch 2",false)));
    }
}
