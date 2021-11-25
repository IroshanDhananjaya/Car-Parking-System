package Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class FirstWindowFormController extends VehicleSlotandType {
    public AnchorPane firstWindowContext;
    public ComboBox cmdVehicleNumber;
    public ComboBox cmdDriver;
    public TextField txtVehicleType;
    public Label labelSlotNumber;
    public Label lblTime;
    public Label lblDate;
    VehicleSlotandType vehicleSlotandType =new VehicleSlotandType();
    String vNumber;
    String driverName;

    String addVehicleNumber[]=new String[14];
    int next;
   {
        for(int i=0;i<addVehicleNumber.length;i++) {
            addVehicleNumber[i] = "";

        }
    }
    VehicleParkCollection vehicleParkCollection=new VehicleParkCollection();
    public void initialize(){

        cmdVehicleNumber.setItems(vehicleNumber);
        cmdDriver.setItems(driverNameList);

        cmdVehicleNumber.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           park((String) newValue);
           vNumber= (String) newValue;
           txtVehicleType.setText(vehicleType);

           if(isExistsSlot()){
               labelSlotNumber.setText("In Parking");
           }else{ labelSlotNumber.setText(vehicleSlot);}


        });
        cmdDriver.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            driverName= (String) newValue;
        });

        {
            Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy:MM:dd");
                lblTime.setText(LocalDateTime.now().format(formatter));
                lblDate.setText(LocalDateTime.now().format(formatter1));
            }),new KeyFrame(Duration.seconds(1)));
            clock.setCycleCount(Animation.INDEFINITE);
            clock.play();
        }
    }


    public void parkOnAction(ActionEvent actionEvent) {
        if(isExistsPark()){
            new Alert(Alert.AlertType.WARNING, "Already Park....", ButtonType.CLOSE).show();
        }else {
            vehicleParkCollection.addParkData(new VehicleParkandLeave(vNumber, txtVehicleType.getText(), labelSlotNumber.getText(), lblDate.getText() + "-" + lblTime.getText()));
            addVehicleNumber[next++] = vNumber;
        }
    }

    public void DiliveryOnAction(ActionEvent actionEvent) {
        if(isExistsPark()){
            vehicleParkCollection.leaveData(new VehicleParkandLeave(vNumber,txtVehicleType.getText(),labelSlotNumber.getText(),lblDate.getText()+"-"+lblTime.getText(),driverName));
            for(int i = 0; i< vehicleSlotandType.vehicleParkingSlot.length; i++){
                if(vNumber.equals(vehicleSlotandType.vehicleParkingSlot[i].parkedOrLeave)){
                    vehicleSlotandType.vehicleParkingSlot[i].parkedOrLeave="No Vehicle";
                }
            }
            for(int i=0;i<next;i++){
                if(addVehicleNumber[i].equals(vNumber)){
                    addVehicleNumber[i]=addVehicleNumber[next-1];
                    next--;
                }
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Already Deliver...", ButtonType.CLOSE).show();
        }
        freeSlot(vNumber);
    }
    public void managementLoginOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ManagementLogInForm.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        ManagementLogInFormController managementLogInFormController = fxmlLoader.getController();
        managementLogInFormController.setController(vehicleParkCollection,firstWindowContext);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
    public boolean isExistsPark(){
       for(int i=0;i<next;i++){
           if(addVehicleNumber[i].equals(vNumber)){
               return true;

           }
       }return false;
    }


    public boolean isExistsSlot(){
        for(int i=0;i<next;i++){
            if(addVehicleNumber[i].equals(vNumber)){
                return true;
            }
        }
        return false;
    }
    static ObservableList<String> vehicleNumber=FXCollections.observableArrayList("NA-3434",
            "KA-4563",
            "58-3567",
            "GF-4358",
            "CCB-3568",
            "LM-6679",
            "QA-3369",
            "KB-3668",
            "JJ-9878",
            "GH-5772",
            "XY-4456",
            "YQ-3536",
            "CBB-3566",
            "QH-3444");
    static ObservableList<String> driverNameList=FXCollections.observableArrayList("Sumith Kumara",
            "Amila Pathirana",
            "Jithmal Perera",
            "Sumith Dissanayaka",
            "Sumanasiri Herath",
            "Awantha Fernando",
            "Charith Sudara",
            "Prashan Dineth",
            "Chethiya Dilan",
            "Dushantha Perera",
            "Sumith Udayanga",
            "Dinesh Udara",
            "Mohommad Riaz",
            "Udana Chathuranga","Sandun Kumara","Priyanga Perera");
}
