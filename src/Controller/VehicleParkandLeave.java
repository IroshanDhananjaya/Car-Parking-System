package Controller;

public class VehicleParkandLeave {
    private String vehicleNumber;
    private String vehicleType;
    private String parkingSlot;
    private String parkedTimeandLeveTime;
    private String Driver;

    public VehicleParkandLeave() {
    }

    public VehicleParkandLeave(String vehicleNumber, String vehicleType, String parkingSlot, String parkedTimeandLeveTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.parkedTimeandLeveTime = parkedTimeandLeveTime;
    }

    public VehicleParkandLeave(String vehicleNumber, String vehicleType, String parkingSlot, String parkedTimeandLeveTime, String driver) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.parkedTimeandLeveTime = parkedTimeandLeveTime;
        Driver = driver;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getParkedTimeandLeveTime() {
        return parkedTimeandLeveTime;
    }

    public void setParkedTimeandLeveTime(String parkedTimeandLeveTime) {
        this.parkedTimeandLeveTime = parkedTimeandLeveTime;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }
}
