package Controller;

public class VehicleParkCollection {
    static VehicleParkandLeave parakArray[];
    static VehicleParkandLeave leaveArray[];
    int nextElement;
    int nextIndex;


    VehicleParkCollection() {
        parakArray = new VehicleParkandLeave[14];
        leaveArray = new VehicleParkandLeave[14];
        nextElement = 0;
        nextIndex = 0;
    }


    public void addParkData(VehicleParkandLeave vehiclePark) {
        if (leaveArray[0] != null) {
            for (int i = 0; i < nextElement; i++) {
                if (vehiclePark.getVehicleNumber() == leaveArray[i].getVehicleNumber()) {
                    for (int j = i; j < nextElement; j++) {
                        leaveArray[j] = leaveArray[j + 1];
                    }
                    nextElement--;
                    break;
                }
            }
        }
        parakArray[nextIndex++] = vehiclePark;
    }

    public void leaveData(VehicleParkandLeave vehicleLeave) {
        if (parakArray[0] != null) {
            for (int i = 0; i < nextIndex; i++) {
                if (vehicleLeave.getVehicleNumber() == parakArray[i].getVehicleNumber()) {
                    for (int j = i; j < nextIndex; j++) {
                        parakArray[j] = parakArray[j + 1];
                    }
                    nextIndex--;
                    break;
                }
            }
        }
        leaveArray[nextElement++] = vehicleLeave;
    }
}
