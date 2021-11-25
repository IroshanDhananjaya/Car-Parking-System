package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLogInFormController {
    public AnchorPane managementLoginContext;
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane anchorPane;
    VehicleParkCollection vehicleParkCollection;

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage stage=(Stage) managementLoginContext.getScene().getWindow();
        stage.close();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("admin")&txtPassword.getText().equals("admin")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ParkingDetailsForm.fxml"));
           Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            ParkingDetailsFormController parkingDetailsFormController = fxmlLoader.getController();
            parkingDetailsFormController.setController(vehicleParkCollection);
            Stage stage1 = (Stage) anchorPane.getScene().getWindow();
            Stage stage2 = (Stage) managementLoginContext.getScene().getWindow();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage1.close();
            stage2.close();
            stage.show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Incorrect Password...", ButtonType.CLOSE).show();
        }
    }
    public void setController(VehicleParkCollection vehicleParkCollection,AnchorPane anchorPane) {
        this.vehicleParkCollection=vehicleParkCollection;
        this.anchorPane=anchorPane;
    }
}
