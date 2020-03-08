import java.util.Scanner;

/***
 * Administrator class uses to create new administrator.
 */
public class Administrator extends CompanyPersonnel{

    private CargoCompany company;

    public Administrator(String id, String name, String password, CargoCompany company) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.company = company;
    }

    /*Branch Operations*/
    public void addBranch(Branch branch) {
        company.getBranches().add(branch);
    }
    public void removeBranch(int index) {
        company.getBranches().remove(index);
    }
    /*Branch Operations*/

    /*Branch Employee Operations*/
    public void addBranchEmployee(int branch_index, BranchEmployee employee) {
        company.getBranches().get(branch_index).getEmployees().add(employee);
    }
    public void removeBranchEmployee(int branch_index, int employee_index) {
        company.getBranches().get(branch_index).getEmployees().remove(employee_index);
    }
    /*Branch Employee Operations*/

    /*Transporter Operations*/
    public void addTransportationPersonnel(int branch_index, TransportationPersonnel transporter) {
        company.getBranches().get(branch_index).getTransporters().add(transporter);
    }
    public void removeTransportationPersonnel(int branch_index, int transporter_index) {
        company.getBranches().get(branch_index).getTransporters().remove(transporter_index);
    }
    /*Transporter Operations*/


    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);
        int choice;
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
                        addBranch(new Branch(name_branch));
                    }else if(choice == 2 && company.getBranches().size() > 0){
                        System.out.println("Please choose a branch: \n");
                        for (int i = 0; i < company.getBranches().size(); i++) {
                            System.out.println((i+1) + ") " + company.getBranches().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        if (index <= company.getBranches().size() && index > 0){
                            removeBranch((index-1));
                        }
                    }else if (choice == 2 && company.getBranches().size() <= 0){
                        System.out.println("There is no branch !\n");
                    }
                    break;
                case 2:
                    if(company.getBranches().size() > 0){
                        System.out.println("Please choose a branch: ");
                        for (int i = 0; i < company.getBranches().size(); i++) {
                            System.out.println((i+1) + ") " + company.getBranches().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        if (index > 0 && index <= company.getBranches().size()){

                            System.out.println("(1) Add Employee");
                            System.out.println("(2) Remove Employee");
                            System.out.println("(0) Exit");
                            System.out.print("Choice: ");
                            choice = input.nextInt();
                            if(choice == 1){
                                System.out.print("ID of employee: ");
                                String id_employee = input.next();
                                System.out.print("Name of employee: ");
                                input.nextLine();
                                String name_employee = input.nextLine();
                                System.out.print("Password of employee: ");
                                String password_employee = input.next();
                                addBranchEmployee((index-1), new BranchEmployee(id_employee, name_employee, password_employee, company.getBranches().get(index-1)));
                            }else if(choice == 2 && company.getBranches().get(index - 1).getEmployees().size() > 0){
                                System.out.println("Please choose a employee: \n");
                                for (int i = 0; i < company.getBranches().get(index-1).getEmployees().size(); i++) {
                                    System.out.println((i+1) + ") " + company.getBranches().get(index-1).getEmployees().get(i).getName());
                                }
                                System.out.println("0) Cancel");
                                System.out.print("Index: ");
                                int index_employee = input.nextInt();
                                if(index_employee > 0 && index_employee <= company.getBranches().get(index-1).getEmployees().size()){
                                    removeBranchEmployee((index-1), index_employee);
                                }
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
                    if(company.getBranches().size() > 0){
                        System.out.println("Please choose a branch: ");
                        for (int i = 0; i < company.getBranches().size(); i++) {
                            System.out.println((i+1) + ") " + company.getBranches().get(i).getName());
                        }
                        System.out.println("0) Cancel");
                        System.out.print("Index: ");
                        int index = input.nextInt();
                        System.out.println("(1) Add Transportation Personnel");
                        System.out.println("(2) Remove Transportation Personnel");
                        System.out.println("(0) Exit");
                        System.out.print("Choice: ");
                        choice = input.nextInt();
                        if(choice == 1){
                            System.out.print("ID of transportation personnel: ");
                            String id_transportation_personnel = input.next();
                            System.out.print("Name of transportation personnel: ");
                            input.nextLine();
                            String name_transportation_personnel = input.nextLine();
                            System.out.print("Password of transportation personnel: ");
                            String password_transportation_personnel = input.next();
                            addTransportationPersonnel((index-1), new TransportationPersonnel(id_transportation_personnel,name_transportation_personnel,password_transportation_personnel, company.getBranches().get(index-1)));
                        }else if(choice == 2 && company.getBranches().get(index-1).getTransporters().size() > 0){
                            System.out.println("Please choose a transportation personnel: \n");
                            for (int i = 0; i < company.getBranches().get(index-1).getTransporters().size(); i++) {
                                System.out.println((i+1) + ") " + company.getBranches().get(index-1).getTransporters().get(i).getId() + " "
                                        + company.getBranches().get(index-1).getTransporters().get(i).getName());
                            }
                            System.out.println("0) Cancel");
                            System.out.print("Index: ");
                            int index_transportation_personnel = input.nextInt();
                            if(index_transportation_personnel > 0 && index_transportation_personnel <= company.getBranches().get(index-1).getTransporters().size()){
                                removeTransportationPersonnel((index-1), index_transportation_personnel);
                            }
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
}
