package Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class ParkingDetailsFormController {
    public AnchorPane InParkingContext;
    public TableView tblInParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public TableView tblDeliver;
    public TableColumn colDeliverVehicleNumber;
    public TableColumn colDeliverVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeaveTime;
    public ComboBox cmdParkingandLeave;
    public Button btnlogOut;
    VehicleParkCollection vehicleParkCollection;
    //VehicleParkandLeave vehicleParkandLeave=new VehicleParkandLeave();

    public void initialize(){
        cmdParkingandLeave.getItems().addAll("In Parking","On Deliver");
        cmdParkingandLeave.setValue("In Parking");

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("parkedTimeandLeveTime"));
       // tblInParking.setItems(FXCollections.observableArrayList(Arrays.asList(vehicleParkCollection.parakArray)));

        colDeliverVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colDeliverVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory("Driver"));
        colLeaveTime.setCellValueFactory(new PropertyValueFactory("parkedTimeandLeveTime"));

    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/addVehicleForm.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/addDriverForm.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/FirstWindowForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)InParkingContext.getScene().getWindow();
        window.setScene(new Scene(load));

      /*  URL resource = getClass().getResource("../view/FirstWindowForm.fxml");
        Parent load = FXMLLoader.load(resource);
        InParkingContext.getChildren().clear();
        InParkingContext.getChildren().add(load);*/
    }



    public void cmdOnAction(ActionEvent actionEvent) {
        if(cmdParkingandLeave.getValue().equals("On Deliver")){
            btnlogOut.setVisible(false);
            tblInParking.setVisible(false);
            tblDeliver.setVisible(true);
        }else{
            btnlogOut.setVisible(true);
            tblDeliver.setVisible(false);
            tblInParking.setVisible(true);
        }
    }
    public void setController(VehicleParkCollection vehicleParkCollection) {
        this.vehicleParkCollection=vehicleParkCollection;
        tblInParking.setItems(FXCollections.observableArrayList(Arrays.asList(vehicleParkCollection.parakArray)));
        tblDeliver.setItems(FXCollections.observableArrayList(Arrays.asList(vehicleParkCollection.leaveArray)));
    }
}
