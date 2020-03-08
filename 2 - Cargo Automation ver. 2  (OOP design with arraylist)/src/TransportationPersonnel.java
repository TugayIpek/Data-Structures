import java.util.Scanner;

/***
 * TransportationPersonnel class uses to create new personnel for transportation.
 */
public class TransportationPersonnel extends CompanyPersonnel{

    private Branch branch;

    public TransportationPersonnel(String id, String name, String password, Branch branch) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.branch = branch;
    }

    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean exit_transporter = false;
        int choice;
        while(!exit_transporter){
            System.out.println("Transportation Personnel Menu");
            System.out.println("(1) Delivered Operations");
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
                    if(branch.getCustomers().size() > 0) {
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

                            System.out.println("Current Delivered Status: ");
                            System.out.println("(1) DELIVERED");
                            System.out.println("(2) NOT DELIVERED");
                            System.out.print("Choice: ");
                            int delivered_status = input.nextInt();
                            if (delivered_status == 1) {
                                branch.getCustomers().get(index - 1).getShipment().setDelivery(true);
                            }else{
                                branch.getCustomers().get(index - 1).getShipment().setDelivery(false);
                            }
                        }else if (index != 0){
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
}
