package entity;

public class Vehicle {

    private int id;
    private int customerId;
    private String vehicleNumber;
    private String modelYear;

    public Vehicle(int id, int customerId, String vehicleNumber, String modelYear) {
        this.id = id;
        this.customerId = customerId;
        this.vehicleNumber = vehicleNumber;
        this.modelYear = modelYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "Vehicle [ id = "+id+", customerId ="+customerId+", vehicleNumber ="+vehicleNumber+", modelYear"+modelYear+" ]";
    }
}
