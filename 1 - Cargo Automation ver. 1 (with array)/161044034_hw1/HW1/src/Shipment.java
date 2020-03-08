/***
 * The shipping class keeps information about the shipment,
 *      such as the name, delivered, the sender, the recipient, the status.
 */
public class Shipment {

    private int ship_number;
    private String sender;
    private String receiver;
    private String branch_status;
    private Boolean delivered_status = false;

    public Shipment(int ship_number, String sender, String receiver, String branch_status, Boolean delivered_status) {
        this.ship_number = ship_number;
        this.sender = sender;
        this.receiver = receiver;
        this.branch_status = branch_status;
        this.delivered_status = delivered_status;
    }

    public int getShip_number() {
        return ship_number;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getBranch_status() {
        return branch_status;
    }

    public Boolean getDelivered_status() {
        return delivered_status;
    }

    public void show_infos() {
        System.out.println("- Shipment Informations -");
        System.out.println("Number : " + ship_number);
        System.out.println("Sender : " + sender);
        System.out.println("Reciever : " + receiver);
        System.out.println("Branch Status : " + branch_status);
        System.out.print("Delivered Status : ");
        if (delivered_status == true){
            System.out.println("DELIVERED");
        }else{
            System.out.println("NOT DELIVERED");
        }
        System.out.println("\n");
    }

    public void setShip_number(int ship_number) {
        this.ship_number = ship_number;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setStatus(String branch_status) {
        this.branch_status = branch_status;
    }

    public void setDelivery(Boolean delivered_status) {
        this.delivered_status = delivered_status;
    }
}