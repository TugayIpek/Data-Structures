/***
 * Customer class uses to create new customer and customer's cargo.
 */
public class Customer extends Person{

    private Shipment shipment;

    public Customer(String name,Shipment shipment) {
        this.name = name;
        this.shipment = shipment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    @Override
    public void menu() {
        shipment.show_infos();
    }
}
