/***
 * Customer class uses to create new customer and customer's cargo.
 */
public class Customer {

    private String name;
    private Shipment shipment;

    public Customer(String name,Shipment shipment) {
        this.name = name;
        this.shipment = shipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shipment getShipment() {
        return shipment;
    }
}
