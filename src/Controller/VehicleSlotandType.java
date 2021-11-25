package Controller;

public class VehicleSlotandType {
    String vehicleNumber;
    String vehicleType;
    String vehicleSlot;
    String parkTime;
    String driverName;

    vehicleParkingSlot vehicleParkingSlot[]=new vehicleParkingSlot[14];

    {
        vehicleParkingSlot[0]=new vehicleParkingSlot("1","Van","No Vehicle");
        vehicleParkingSlot[1]=new vehicleParkingSlot("2","Van","No Vehicle");
        vehicleParkingSlot[2]=new vehicleParkingSlot("3","Van","No Vehicle");
        vehicleParkingSlot[3]=new vehicleParkingSlot("4","Van","No Vehicle");
        vehicleParkingSlot[4]=new vehicleParkingSlot("5","Cargo Lorry","No Vehicle");
        vehicleParkingSlot[5]=new vehicleParkingSlot("6","Cargo Lorry","No Vehicle");
        vehicleParkingSlot[6]=new vehicleParkingSlot("7","Cargo Lorry","No Vehicle");
        vehicleParkingSlot[7]=new vehicleParkingSlot("8","Cargo Lorry","No Vehicle");
        vehicleParkingSlot[8]=new vehicleParkingSlot("9","Cargo Lorry","No Vehicle");
        vehicleParkingSlot[9]=new vehicleParkingSlot("10","Cargo Lorry","No Vehicle");
        vehicleParkingSlot[10]=new vehicleParkingSlot("11","Cargo Lorry","No Vehicle");
        vehicleParkingSlot[11]=new vehicleParkingSlot("12","Van","No Vehicle");
        vehicleParkingSlot[12]=new vehicleParkingSlot("13","Van","No Vehicle");
        vehicleParkingSlot[13]=new vehicleParkingSlot("14","Bus","No Vehicle");
    }

    public VehicleSlotandType() {
    }

    public VehicleSlotandType(String vehicleNumber, String vehicleType, String vehicleSlot, String parkTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleSlot = vehicleSlot;
        this.parkTime=parkTime;
    }
    public VehicleSlotandType(String vehicleNumber, String vehicleType, String vehicleSlot, String driverName, String parkTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleSlot=vehicleSlot;
        this.driverName = driverName;
        this.parkTime=parkTime;
    }


   public String toString() {
       return "{"+vehicleNumber+"/"+vehicleType+"/"+vehicleSlot+"/"+parkTime+"}";
    }

    public void park(String a){
        vehicleNumber=a;
        if(vehicleNumber.equals("NA-3434")){
        vehicleType="Bus";
            for(int i=0;i<vehicleParkingSlot.length;i++){
                if(vehicleParkingSlot[i].VehicleType.equals("Bus")){
                    if(vehicleParkingSlot[i].parkedOrLeave.equals("No Vehicle")){
                        vehicleSlot=vehicleParkingSlot[i].slotNumber;
                        vehicleParkingSlot[i].parkedOrLeave=vehicleNumber;

                        break;
                    }else{
                        vehicleSlot="NO Slot Available";
                    }
                }
            }

            }else if(vehicleNumber.equals("KA-4563")||vehicleNumber.equals("58-3567")||vehicleNumber.equals("GF-4358")||vehicleNumber.equals("CCB-3568")||vehicleNumber.equals("LM-6679")||vehicleNumber.equals("QA-3369")){
            vehicleType="Van";
            for(int i=0;i<vehicleParkingSlot.length;i++){
                if(vehicleParkingSlot[i].VehicleType.equals("Van")){
                    if(vehicleParkingSlot[i].parkedOrLeave.equals("No Vehicle")){
                        vehicleSlot=vehicleParkingSlot[i].slotNumber;
                        vehicleParkingSlot[i].parkedOrLeave=vehicleNumber;
                        i++;
                        break;
                    }else{
                    vehicleSlot="NO Slot Available";
                }
                }
            }
        }else if(vehicleNumber.equals("KB-3668")||vehicleNumber.equals("JJ-9878")||vehicleNumber.equals("GH-5772")||vehicleNumber.equals("XY-4456")||vehicleNumber.equals("YQ-3536")||vehicleNumber.equals("CBB-3566")){
            vehicleType="Cargo Lorry";
            for(int i=0;i<vehicleParkingSlot.length;i++){
                if(vehicleParkingSlot[i].VehicleType.equals("Cargo Lorry")){
                    if(vehicleParkingSlot[i].parkedOrLeave.equals("No Vehicle")){
                        vehicleSlot=vehicleParkingSlot[i].slotNumber;
                        vehicleParkingSlot[i].parkedOrLeave=vehicleNumber;
                        break;
                    }else{
                    vehicleSlot="NO Slot Available";
                }
                }
            }

        }
    }
    public void freeSlot(String vehicleNumberLeave){
        for(int i=0;i<vehicleParkingSlot.length;i++){
            if(vehicleNumberLeave.equals(vehicleParkingSlot[i].parkedOrLeave)){
                vehicleParkingSlot[i].parkedOrLeave="No Vehicle";
            }
        }


    }
}
