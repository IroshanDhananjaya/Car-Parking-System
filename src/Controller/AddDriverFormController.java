package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddDriverFormController {
    public AnchorPane addDriverContext;
    public TextField txtDriverName;
    public TextField txtNIC;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public TextField txtContactNo;
    String driverName[]=new String[16];
    int next;



    public void addDriverOnAction(ActionEvent actionEvent) {
        FirstWindowFormController.driverNameList.add(txtDriverName.getText());
    }
}
