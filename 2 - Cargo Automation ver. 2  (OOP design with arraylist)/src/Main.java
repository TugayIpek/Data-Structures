/***
 * Main contains a menu for the cargo system.
 *  This menu can be used by administrator, branch employee,
 *  transportation personnel and customer.
 */

public class Main {
    public static void main(String[] args) {
        CargoCompany company = new CargoCompany("BlaBla Cargo");
        company.addAdministrator(new Administrator("1234", "Admin 1", "abcd", company));
        /*
          Code gets testCode function.
          testCode testCode for automatic fills
        */
        company.testCode();
        company.startTheSystem();
    }
}
