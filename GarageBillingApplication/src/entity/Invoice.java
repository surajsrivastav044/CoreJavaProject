package entity;

public class Invoice {

    private int id;
    private int customer_id;
    private int vehicle_id;
    private int service_id;

    public Invoice(int id, int customer_id, int vehicle_id, int service_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.vehicle_id = vehicle_id;
        this.service_id = service_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    @Override
    public String toString() {
        return "Invoice [ Id = "+id+", CustomerId = "+customer_id+"," +
                " VehicleId = "+vehicle_id+", ServiceId = "+service_id+" ]";
    }
}
