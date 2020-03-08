import java.util.Scanner;

/***
 * Main contains a menu for the cargo system.
 *  This menu can be used by administrator, branch employee,
 *  transportation personnel and customer.
 */

public class Main {
    public static void main(String[] args) {
        CargoCompany company = new CargoCompany("BlaBla Cargo");
        company.addAdministrator(new Administrator(1234, "admin", "abcd"));
        /**
         * Code gets testCode function.
         @param testCode testCode for automatic fills
         */
        company.testCode(); //Test function.
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println("Welcome to Cargo Automation System");
            System.out.println("*" + company.getName() + " Company");
            System.out.println("(1) Administrator");
            System.out.println("(2) Branch Employee");
            System.out.println("(3) Transportation Personnel");
            System.out.println("(4) Customer");
            System.out.println("(0) Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    boolean access = false;
                    System.out.println("Please enter your ID and password.");
                    while(!access){
                        System.out.print("ID: ");
                        int admin_id = input.nextInt();
                        System.out.print("Password: ");
                        String admin_password = input.next();
                        for (int i = 0; i < company.getAdmin_size(); i++) {
                            if (admin_id == company.getAdministrators()[i].getId() &&
                                    admin_password.compareTo(company.getAdministrators()[i].getPassword()) == 0){
                                System.out.println("Access Granted\n");
                                System.out.println("Welcome " + company.getAdministrators()[i].getName());
                                access = true;
                                break;
                            }
                        }
                        if(!access){
                            System.out.println("Access Denied\n");
                            access = false;
                            break;
                        }
                    }
                    if(access){
                        boolean exit_admin = false;
                        while(!exit_admin){
                            System.out.println("Administrator Menu");
                            System.out.println("(1) Branch Operations");
                            System.out.println("(2) Branch Employee Operations");
                            System.out.println("(3) Transportation Personnel Operations");
                            System.out.println("(0) Exit");
                            System.out.print("Choice: ");
                            choice = input.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("(1) Add Branch");
                                    System.out.println("(2) Remove Branch");
                                    System.out.println("(0) Exit");
                                    System.out.print("Choice: ");
                                    choice = input.nextInt();
                                    if(choice == 1){
                                        System.out.print("Please enter a name for the branch: ");
                                        input.nextLine();
                                        String name_branch = input.nextLine();
                                        company.addBranch(new Branch(name_branch));
                                    }else if(choice == 2 && company.getBranch_size() > 0){
                                        System.out.println("Please choose a branch: \n");
                                        for (int i = 0; i < company.getBranch_size(); i++) {
                                            System.out.println((i+1) + ") " + company.getBranches()[i].getName());
                                        }
                                        System.out.print("Index: ");
                                        int index = input.nextInt();
                                        if (index <= company.getBranch_size() && index > 0){
                                            company.removeBranch((index-1));
                                        }
                                    }else if (choice == 2 && company.getBranch_size() <= 0){
                                        System.out.println("There is no branch !\n");
                                    }
                                    break;
                                case 2:
                                    if(company.getBranch_size() > 0){
                                        System.out.println("Please choose a branch: ");
                                        for (int i = 0; i < company.getBranch_size(); i++) {
                                            System.out.println((i+1) + ") " + company.getBranches()[i].getName());
                                        }
                                        System.out.print("Index: ");
                                        int index = input.nextInt();
                                        if (index > 0 && index <= company.getBranch_size()){

                                            System.out.println("(1) Add Employee");
                                            System.out.println("(2) Remove Employee");
                                            System.out.println("(0) Exit");
                                            System.out.print("Choice: ");
                                            choice = input.nextInt();
                                            if(choice == 1){
                                                System.out.print("ID of employee: ");
                                                int id_employee = input.nextInt();
                                                System.out.print("Name of employee: ");
                                                input.nextLine();
                                                String name_employee = input.nextLine();
                                                System.out.print("Password of employee: ");
                                                String password_employee = input.next();
                                                company.getBranches()[index-1].addBranchEmployee(new BranchEmployee(id_employee,name_employee,password_employee));
                                            }else if(choice == 2 && company.getBranches()[index-1].getEmployee_size() > 0){
                                                System.out.println("Please choose a employee: \n");
                                                for (int i = 0; i < company.getBranches()[index-1].getEmployee_size(); i++) {
                                                    System.out.println((i+1) + ") " + company.getBranches()[index-1].getEmployees()[i].getName());
                                                }
                                                System.out.print("Index: ");
                                                int index_employee = input.nextInt();
                                                company.getBranches()[index-1].removeBranchEmployee(index_employee);
                                            }else{
                                                System.out.println("There is no employee !\n");
                                            }
                                        }else{
                                            System.out.println("Please Try Again\n");
                                        }
                                    }else{
                                        System.out.println("There is no branch !\n");
                                    }
                                    break;
                                case 3:
                                    if(company.getBranch_size() > 0){
                                        System.out.println("Please choose a branch: ");
                                        for (int i = 0; i < company.getBranch_size(); i++) {
                                            System.out.println((i+1) + ") " + company.getBranches()[i].getName());
                                        }
                                        System.out.print("Index: ");
                                        int index = input.nextInt();
                                        System.out.println("(1) Add Transportation Personnel");
                                        System.out.println("(2) Remove Transportation Personnel");
                                        System.out.println("(0) Exit");
                                        System.out.print("Choice: ");
                                        choice = input.nextInt();
                                        if(choice == 1){
                                            System.out.print("ID of transportation personnel: ");
                                            int id_transportation_personnel = input.nextInt();
                                            System.out.print("Name of transportation personnel: ");
                                            input.nextLine();
                                            String name_transportation_personnel = input.nextLine();
                                            System.out.print("Password of transportation personnel: ");
                                            String password_transportation_personnel = input.next();
                                            company.getBranches()[index-1].addTransportationPersonnel(new TransportationPersonnel(id_transportation_personnel,name_transportation_personnel,password_transportation_personnel));
                                        }else if(choice == 2 && company.getBranches()[index-1].getTransporter_size() > 0){
                                            System.out.println("Please choose a transportation personnel: \n");
                                            for (int i = 0; i < company.getBranches()[index-1].getTransporter_size(); i++) {
                                                System.out.println((i+1) + ") " + company.getBranches()[index-1].getTransporters()[i].getId() + " "
                                                        + company.getBranches()[index-1].getTransporters()[i].getName());
                                            }
                                            System.out.print("Index: ");
                                            int index_transportation_personnel = input.nextInt();
                                            company.getBranches()[index-1].removeTransportationPersonnel(index_transportation_personnel);
                                        }else{
                                            System.out.println("There is no transportation personnel !\n");
                                        }
                                    }else{
                                        System.out.println("There is no branch !\n");
                                    }
                                    break;
                                case 0:
                                    exit_admin = true;
                                    break;
                                default:
                                    System.out.println("Please Try Again\n");
                            }
                        }
                    }
                    break;
                case 2:
                    int branch_code = -1;
                    access = false;
                    System.out.println("Please enter your ID and password.");
                    while(!access){
                        System.out.print("ID: ");
                        int employee_id = input.nextInt();
                        System.out.print("Password: ");
                        String employee_password = input.next();
                        for (int i = 0; i < company.getBranch_size(); i++) {
                            for (int j = 0; j < company.getBranches()[i].getEmployee_size(); j++) {
                                if (employee_id == company.getBranches()[i].getEmployees()[j].getId() &&
                                        employee_password.compareTo(company.getBranches()[i].getEmployees()[j].getPassword()) == 0){
                                    System.out.println("Access Granted\n");
                                    System.out.println("Welcome " + company.getBranches()[i].getEmployees()[j].getName());
                                    access = true;
                                    branch_code = i;
                                    break;
                                }
                            }
                        }
                        if(!access){
                            System.out.println("Access Denied\n");
                            access = false;
                            break;
                        }
                    }
                    if(access){
                        boolean exit_employee = false;
                        while(!exit_employee){
                            System.out.println("Branch Employee Menu");
                            System.out.println("(1) Customer Operations");
                            System.out.println("(2) Shipment Operations");
                            System.out.println("(3) Current Status");
                            System.out.println("(0) Exit");
                            System.out.print("Choice: ");
                            choice = input.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("(1) Add Customer");
                                    System.out.println("(2) Remove Customer");
                                    System.out.println("(0) Exit");
                                    System.out.print("Choice: ");
                                    choice = input.nextInt();
                                    if(choice == 1){
                                        System.out.print("Please enter name of the customer: ");
                                        input.nextLine();
                                        String name_customer = input.nextLine();
                                        System.out.println("Please enter information of the shipment: ");
                                        System.out.print("Shipment Number: ");
                                        int ship_number = input.nextInt();
                                        System.out.print("Sender: ");
                                        input.nextLine();
                                        String sender = input.nextLine();
                                        System.out.print("Receiver: ");

                                        String receiver = input.nextLine();
                                        System.out.print("Branch Status: ");

                                        String branch_status = input.nextLine();
                                        System.out.print("Delivered Status: NOT DELIVERED");

                                        company.getBranches()[branch_code].addCustomer(new Customer(name_customer, new Shipment(ship_number,sender,receiver,branch_status,false)));
                                        System.out.println("\nSuccessfully. Customer and cargo created.\n");
                                    }else if(choice == 2 && company.getBranches()[branch_code].getCustomer_size() > 0){
                                        System.out.println("Please choose a shipment: \n");
                                        for (int i = 0; i < company.getBranches()[branch_code].getCustomer_size(); i++) {
                                            System.out.println((i+1) + ") " + company.getBranches()[branch_code].getCustomers()[i].getShipment().getShip_number()
                                            + " " + company.getBranches()[branch_code].getCustomers()[i].getName());
                                        }
                                        System.out.print("Index: ");
                                        int index = input.nextInt();
                                        if (index <= company.getBranches()[branch_code].getCustomer_size() && index > 0){
                                            company.getBranches()[branch_code].removeCustomer((index-1));
                                        }else{
                                            System.out.println("Please Try Again\n");
                                        }

                                    }else if (choice == 2 && company.getBranches()[branch_code].getCustomer_size() <= 0){
                                        System.out.println("There is no customer !\n");
                                    }
                                    break;
                                case 2:
                                    if(company.getBranches()[branch_code].getCustomer_size() > 0){
                                        System.out.println("Please choose a shipment: \n");
                                        for (int i = 0; i < company.getBranches()[branch_code].getCustomer_size(); i++) {
                                            System.out.println((i+1) + ") " + company.getBranches()[branch_code].getCustomers()[i].getShipment().getShip_number()
                                                    + " " + company.getBranches()[branch_code].getCustomers()[i].getName());
                                        }
                                        System.out.print("Index: ");
                                        int index = input.nextInt();
                                        if (index <= company.getBranches()[branch_code].getCustomer_size() && index > 0){
                                            company.getBranches()[branch_code].getCustomers()[index-1].getShipment().show_infos();
                                            System.out.println("(1) Edit Shipment Number");
                                            System.out.println("(2) Edit Sender");
                                            System.out.println("(3) Edit Receiver");
                                            System.out.println("(0) Exit");
                                            System.out.print("Choice: ");
                                            choice = input.nextInt();
                                            if(choice == 1){
                                                System.out.print("Please enter a new shipment number: ");
                                                int ship_number = input.nextInt();
                                                company.getBranches()[branch_code].getCustomers()[index-1].getShipment().setShip_number(ship_number);
                                            }else if(choice == 2){
                                                System.out.print("Please enter a new sender name: ");
                                                input.nextLine();
                                                String sender_name = input.nextLine();
                                                company.getBranches()[branch_code].getCustomers()[index-1].getShipment().setSender(sender_name);
                                            }else if(choice == 3){
                                                System.out.print("Please enter a new receiver name: ");
                                                input.nextLine();
                                                String receiver_name = input.nextLine();
                                                company.getBranches()[branch_code].getCustomers()[index-1].getShipment().setReceiver(receiver_name);
                                            }
                                        }else{
                                            System.out.println("Please Try Again\n");
                                        }

                                    }else{
                                        System.out.println("There is no customer !\n");
                                    }
                                    break;
                                case 3:
                                    if(company.getBranches()[branch_code].getCustomer_size() > 0) {
                                        System.out.println("Please choose a shipment: \n");
                                        for (int i = 0; i < company.getBranches()[branch_code].getCustomer_size(); i++) {
                                            System.out.println((i + 1) + ") " + company.getBranches()[branch_code].getCustomers()[i].getShipment().getShip_number()
                                                    + " " + company.getBranches()[branch_code].getCustomers()[i].getName());
                                        }
                                        System.out.print("Index: ");
                                        int index = input.nextInt();
                                        if (index <= company.getBranches()[branch_code].getCustomer_size() && index > 0){
                                            company.getBranches()[branch_code].getCustomers()[index - 1].getShipment().show_infos();

                                            System.out.print("Current Branch Status: ");
                                            input.nextLine();
                                            String branch_status = input.nextLine();
                                            company.getBranches()[branch_code].getCustomers()[index-1].getShipment().setStatus(branch_status);
                                        }else{
                                            System.out.println("Please Try Again");
                                        }
                                    }else{
                                        System.out.println("There is no customer");
                                    }
                                    break;
                                case 0:
                                    exit_employee = true;
                                    break;
                                default:
                                    System.out.println("Please Try Again\n");
                            }
                        }
                    }
                    break;
                case 3:
                    branch_code = -1;
                    access = false;
                    System.out.println("Please enter your ID and password.");
                    while(!access){
                        System.out.print("ID: ");
                        int transporter_id = input.nextInt();
                        System.out.print("Password: ");
                        String transporter_password = input.next();
                        for (int i = 0; i < company.getBranch_size(); i++) {
                            for (int j = 0; j < company.getBranches()[i].getTransporter_size(); j++) {
                                if (transporter_id == company.getBranches()[i].getTransporters()[j].getId() &&
                                        transporter_password.compareTo(company.getBranches()[i].getTransporters()[j].getPassword()) == 0){
                                    System.out.println("Access Granted\n");
                                    System.out.println("Welcome " + company.getBranches()[i].getTransporters()[j].getName());
                                    access = true;
                                    branch_code = i;
                                    break;
                                }
                            }
                        }
                        if(!access){
                            System.out.println("Access Denied\n");
                            access = false;
                            break;
                        }
                    }
                    if(access){
                        boolean exit_transporter = false;
                        while(!exit_transporter){
                            System.out.println("Transportation Personnel Menu");
                            System.out.println("(1) Delivered Operations");
                            System.out.println("(0) Exit");
                            System.out.print("Choice: ");
                            choice = input.nextInt();
                            switch (choice) {
                                case 1:
                                    if(company.getBranches()[branch_code].getCustomer_size() > 0) {
                                        System.out.println("Please choose a shipment: \n");
                                        for (int i = 0; i < company.getBranches()[branch_code].getCustomer_size(); i++) {
                                            System.out.println((i + 1) + ") " + company.getBranches()[branch_code].getCustomers()[i].getShipment().getShip_number()
                                                    + " " + company.getBranches()[branch_code].getCustomers()[i].getName());
                                        }
                                        System.out.print("Index: ");
                                        int index = input.nextInt();
                                        if (index <= company.getBranches()[branch_code].getCustomer_size() && index > 0) {
                                            company.getBranches()[branch_code].getCustomers()[index - 1].getShipment().show_infos();

                                            System.out.println("Current Delivered Status: ");
                                            System.out.println("(1) DELIVERED");
                                            System.out.println("(2) NOT DELIVERED");
                                            System.out.print("Choice: ");
                                            int delivered_status = input.nextInt();
                                            if (delivered_status == 1) {
                                                company.getBranches()[branch_code].getCustomers()[index - 1].getShipment().setDelivery(true);
                                            }else{
                                                company.getBranches()[branch_code].getCustomers()[index - 1].getShipment().setDelivery(false);
                                            }
                                        }else{
                                            System.out.println("Please Try Again\n");
                                        }
                                    }
                                    break;
                                case 0:
                                    exit_transporter = true;
                                    break;
                                default:
                                    System.out.println("Please Try Again\n");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Please enter your shipment number.");
                    access = false;
                    while(!access){
                        System.out.print("Shipment Number: ");
                        int shipment_number = input.nextInt();
                        for (int i = 0; i < company.getBranch_size(); i++) {
                            for (int j = 0; j < company.getBranches()[i].getCustomer_size(); j++) {
                                if (shipment_number == company.getBranches()[i].getCustomers()[j].getShipment().getShip_number()){
                                    System.out.println("Shipment found\n");
                                    company.getBranches()[i].getCustomers()[j].getShipment().show_infos();
                                    access = true;
                                    break;
                                }
                            }
                        }
                        if(!access){
                            System.out.println("Access Denied\n");
                           access = false;
                        }
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.print("Please Try Again\n\n");
            }
        }
    }
}
