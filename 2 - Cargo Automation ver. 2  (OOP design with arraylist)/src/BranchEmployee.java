import java.util.Scanner;

/***
 * BranchEmployee class uses to create new employee for branch.
 */
public class BranchEmployee extends CompanyPersonnel{

    private Branch branch;

    public BranchEmployee(String id, String name, String password,Branch branch) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.branch = branch;
    }

    public void addCustomer(Customer customer) {
        branch.getCustomers().add(customer);
    }
    public void removeCustomer(int index) {
        branch.getCustomers().remove(index);
    }

    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean exit_employee = false;
        int choice;
        while (!exit_employee) {
            System.out.println("Branch Employee Menu");
            System.out.println("(1) Customer Operations");
            System.out.println("(2) Shipment Operations");
            System.out.println("(3) Current Status");
            System.out.println("(0) Exit");
            System.out.print("Choice: ");
            try {
                choice = input.nextInt();
            }catch (Exception e){
                System.out.println("\nYour choice must be an integer value !");
                input.nextLine();
                choice = -1;
            }
            switch (choice) {
                case 1:
                    System.out.println("(1) Add Customer");
                    System.out.println("(2) Remove Customer");
                    System.out.println("(0) Exit");
                    System.out.print("Choice: ");
                    try {
                        choice = input.nextInt();
                    }catch (Exception e){
                        System.out.println("\nYour choice must be an integer value !");
                        input.nextLine();
                        choice = -1;
                    }
                    if (choice == 1) {
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

                        addCustomer(new Customer(name_customer, new Shipment(ship_number, sender, receiver, branch_status, false)));
                        System.out.println("\nSuccessfully. Customer and cargo created.\n");
                    } else if (choice == 2 && branch.getCustomers().size() > 0) {
                        System.out.println("Please choose a customer: \n");
                        for (int i = 0; i < branch.getCustomers().size(); i++) {
                            System.out.println((i + 1) + ") " + branch.getCustomers().get(i).getShipment().getShip_number()
                                    + " " + branch.getCustomers().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        if (index <= branch.getCustomers().size() && index > 0) {
                            removeCustomer((index - 1));
                        } else if(index != 0){
                            System.out.println("Please Try Again\n");
                        }

                    } else if (choice == 2 && branch.getCustomers().size() <= 0) {
                        System.out.println("There is no customer !\n");
                    }
                    break;
                case 2:
                    if (branch.getCustomers().size() > 0) {
                        System.out.println("Please choose a shipment: \n");
                        for (int i = 0; i < branch.getCustomers().size(); i++) {
                            System.out.println((i + 1) + ") " + branch.getCustomers().get(i).getShipment().getShip_number()
                                    + " " + branch.getCustomers().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        if (index <= branch.getCustomers().size() && index > 0) {
                            branch.getCustomers().get(index - 1).getShipment().show_infos();
                            System.out.println("(1) Edit Shipment Number");
                            System.out.println("(2) Edit Sender");
                            System.out.println("(3) Edit Receiver");
                            System.out.println("(0) Exit");
                            System.out.print("Choice: ");
                            choice = input.nextInt();
                            if (choice == 1) {
                                System.out.print("Please enter a new shipment number: ");
                                int ship_number = input.nextInt();
                                branch.getCustomers().get(index - 1).getShipment().setShip_number(ship_number);
                            } else if (choice == 2) {
                                System.out.print("Please enter a new sender name: ");
                                input.nextLine();
                                String sender_name = input.nextLine();
                                branch.getCustomers().get(index - 1).getShipment().setSender(sender_name);
                            } else if (choice == 3) {
                                System.out.print("Please enter a new receiver name: ");
                                input.nextLine();
                                String receiver_name = input.nextLine();
                                branch.getCustomers().get(index - 1).getShipment().setReceiver(receiver_name);
                            }
                        } else if (index != 0){
                            System.out.println("Please Try Again\n");
                        }

                    } else {
                        System.out.println("There is no customer !\n");
                    }
                    break;
                case 3:
                    if(branch.getCustomers().size() > 0) {
                        System.out.println("Please choose a shipment: \n");
                        for (int i = 0; i < branch.getCustomers().size(); i++) {
                            System.out.println((i + 1) + ") " + branch.getCustomers().get(i).getShipment().getShip_number()
                                    + " " + branch.getCustomers().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        if (index <= branch.getCustomers().size() && index > 0){
                            branch.getCustomers().get(index - 1).getShipment().show_infos();

                            System.out.print("Current Branch Status: ");
                            input.nextLine();
                            String branch_status = input.nextLine();
                            branch.getCustomers().get(index - 1).getShipment().setStatus(branch_status);
                        }else if(index != 0){
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
}