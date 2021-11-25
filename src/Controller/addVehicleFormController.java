package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class addVehicleFormController {
    public AnchorPane addVehicleContext;
    public TextField txtVehicleNumber;
    public TextField txtWeight;
    public TextField txtPassengers;
    public ComboBox cmbVehicleType;
    static String  vehicleType1;

    public void initialize(){
        cmbVehicleType.getItems().addAll("Van","Bus","Cargo Lorry");

    }


    public void addVehicleOnAction(ActionEvent actionEvent) {
        FirstWindowFormController.vehicleNumber.add(txtVehicleNumber.getText());
        txtVehicleNumber.clear();
        txtPassengers.clear();
        txtWeight.clear();
      /*  vehicleType1=cmbVehicleType.getSelectionModel().getSelectedItem().toString();*/

    }
    public static String vType(){
        return vehicleType1;
    }

}
