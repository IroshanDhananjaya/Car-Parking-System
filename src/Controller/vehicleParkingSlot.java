package Controller;

public class vehicleParkingSlot {
   public String slotNumber;
    public String VehicleType;
   public String parkedOrLeave;

    public vehicleParkingSlot() {
    }

    public vehicleParkingSlot(String slotNumber, String vehicleType, String parkedOrLeave) {
        this.slotNumber = slotNumber;
        this.VehicleType = vehicleType;
        this.parkedOrLeave = parkedOrLeave;
    }
}
