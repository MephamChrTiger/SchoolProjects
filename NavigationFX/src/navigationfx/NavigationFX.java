/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationfx;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author s01164417
 */
public class NavigationFX extends Application {
    
    TruckFX truck1;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

    ///////////// Scene Declarations ///////////////

        AnchorPane start = new AnchorPane();
        Scene sceneStart = new Scene(start, 700, 700);
        
        AnchorPane truckCreation = new AnchorPane();
        Scene truckStart = new Scene(truckCreation, 700, 700);
        
        AnchorPane locationCreation = new AnchorPane();
        Scene locCreation = new Scene(locationCreation, 700, 700);
        
        
    //////////// END SCENE DECLARATIONS /////////////
    //1 array and 1 listview makes it easier to declare at the top
    ArrayList<locationFX> locationArray = new ArrayList<locationFX>(); 
        locationArray.add(new locationFX("Cleveland", 0, 0, true));
        locationArray.add(new locationFX("North Pole", 500, -100, true));
        locationArray.add(new locationFX("Campbell Hill", -50, -50, false));
        locationArray.add(new locationFX("Tokyo", -100, 1000, true));
        locationArray.add(new locationFX("Chicago", -200, 75, true));
        locationArray.add(new locationFX("Erie PA", 150, 0, true));
        locationArray.add(new locationFX("Allegheny Nation Forest", 300, -75, false));

    
    ListView<locationFX> locations = new ListView();
        locations.getItems().add(new locationFX("Cleveland", 0, 0, true));
        locations.getItems().add(new locationFX("North Pole", 500, -100, true));
        locations.getItems().add(new locationFX("Campbell Hill", -50, -50, false));
        locations.getItems().add(new locationFX("Tokyo", -100, 1000, true));
        locations.getItems().add(new locationFX("Chicago", -200, 75, true));
        locations.getItems().add(new locationFX("Erie PA", 150, 0, true));
        locations.getItems().add(new locationFX("Allegheny Nation Forest", 300, -75, false));
        
        
        
    //////////////// START TRUCK SCENE /////////////////////   
    Label createTrucklbl = new Label("Create Your Truck Below: ");
    Label fuelRange = new Label("Current Range: 0");
    Label truckErrorMsg = new Label(" ");
    Button backToStart = new Button();
        backToStart.setText("Go Back");
        backToStart.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(sceneStart);
        });
        
    Label truckMaxFuel = new Label("Truck's max fuel capacity: ");
    Label truckMPG = new Label("Truck's Miles Per Gallon: ");
    
    TextField userMaxFuel = new TextField();
    TextField userMPG = new TextField();
    
    Button createTruck = new Button();
        createTruck.setText("Create Truck");
        createTruck.setOnAction((ActionEvent event) -> {
            try{
                locationFX placeH = new locationFX("placeholder", 0.0, 0.0, true);
                double truckMaxF = Double.parseDouble(userMaxFuel.getText());
                double truckIntMPG = Double.parseDouble(userMPG.getText());
                truck1 = new TruckFX(placeH, truckMaxF, truckMaxF, truckIntMPG); //starts at cleveland
                fuelRange.setText("Current range: " + truck1.getRange() + " miles");
                primaryStage.setScene(sceneStart);
                }
            catch(Exception e){
                truckErrorMsg.setText("Oops! You need to use real numbers!");
            }
        });
        
    createTruck.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
    backToStart.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
        
    AnchorPane.setTopAnchor(createTrucklbl, 5.0);
    AnchorPane.setLeftAnchor(createTrucklbl, 10.0);
    
    AnchorPane.setTopAnchor(truckMaxFuel, 50.0);
    AnchorPane.setLeftAnchor(truckMaxFuel, 10.0);
    
    AnchorPane.setTopAnchor(userMaxFuel, 50.0);
    AnchorPane.setLeftAnchor(userMaxFuel, 185.0);
    
    AnchorPane.setTopAnchor(truckMPG, 90.0);
    AnchorPane.setLeftAnchor(truckMPG, 10.0);
    
    AnchorPane.setTopAnchor(userMPG, 90.0);
    AnchorPane.setLeftAnchor(userMPG, 185.0);
    
    AnchorPane.setTopAnchor(createTruck, 130.0);
    AnchorPane.setLeftAnchor(createTruck, 150.0);
    
    AnchorPane.setBottomAnchor(backToStart, 25.0);
    AnchorPane.setRightAnchor(backToStart, 25.0);
    
    AnchorPane.setTopAnchor(truckErrorMsg, 175.0);
    AnchorPane.setLeftAnchor(truckErrorMsg, 10.0);
    
    truckCreation.getChildren().addAll(backToStart, createTrucklbl, truckMaxFuel, truckMPG, userMaxFuel, userMPG,
            createTruck, truckErrorMsg);
    
    //////////////// END TRUCK SCENE ////////////////
        
        
    //////////// START SCENE ////////////////////////
    Label startMessage = new Label("🚩 -Welcome to Truck Driving Simulator!- 🚩");
    Label currentLoc = new Label("Current location: ");
    Label options = new Label("Options: ");
    Label liveLocation = new Label(locationArray.get(0).locationTitle());
    Label errorlbl1 = new Label("-Current Messages-");
    Label errorlbl2 = new Label("Please Create A Truck BEFORE Doing Anything Else.");
    Label errorlbl3 = new Label(" ");
    
    Button exitApp = new Button();
        exitApp.setText("Exit");
        exitApp.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
    
    Button truckPage = new Button();
        truckPage.setText("Create Truck");
        truckPage.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(truckStart);
            errorlbl2.setText("Your truck has been created!");
        });
        
    Button viewLocations = new Button();
        viewLocations.setText("Drive To New Location");
        viewLocations.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(locCreation);
        });
        
    Button refuelbtn = new Button();
        refuelbtn.setText("Refuel");
        refuelbtn.setOnAction((ActionEvent event) -> {
            if(truck1.currentLocation().gasCheck()){ //fuel check
                    truck1.refuel();
                    fuelRange.setText("Current Range: " + truck1.getRange() + " miles");
                    errorlbl2.setText("Your truck has been refueled!");
                    errorlbl3.setText(" ");
            }
            else if(truck1.currentLocation().gasCheck() != true){
                errorlbl2.setText("OOPS! This location does not have a gas station!");
            }
        });
        
    viewLocations.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
    refuelbtn.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
    truckPage.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
    exitApp.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
    
    AnchorPane.setTopAnchor(startMessage, 10.0);
    AnchorPane.setRightAnchor(startMessage, 250.0);
    
    AnchorPane.setTopAnchor(currentLoc, 50.0);
    AnchorPane.setLeftAnchor(currentLoc, 25.0);
    
    AnchorPane.setTopAnchor(fuelRange, 100.0);
    AnchorPane.setLeftAnchor(fuelRange, 25.0);
    
    AnchorPane.setTopAnchor(truckPage, 50.0);
    AnchorPane.setRightAnchor(truckPage, 100.0);
    
    AnchorPane.setTopAnchor(viewLocations, 100.0);
    AnchorPane.setRightAnchor(viewLocations, 35.0);
    
    AnchorPane.setTopAnchor(options, 10.0);
    AnchorPane.setRightAnchor(options, 140.0);
    
    AnchorPane.setTopAnchor(refuelbtn, 150.0);
    AnchorPane.setRightAnchor(refuelbtn, 142.0);
    
    AnchorPane.setTopAnchor(exitApp, 200.0);
    AnchorPane.setRightAnchor(exitApp, 160.0);
    
    AnchorPane.setTopAnchor(liveLocation, 50.0);
    AnchorPane.setLeftAnchor(liveLocation, 145.0);
    
    AnchorPane.setTopAnchor(errorlbl1, 150.0);
    AnchorPane.setLeftAnchor(errorlbl1, 25.0);
    
    AnchorPane.setTopAnchor(errorlbl2, 170.0);
    AnchorPane.setLeftAnchor(errorlbl2, 25.0);
    
    AnchorPane.setTopAnchor(errorlbl3, 190.0);
    AnchorPane.setLeftAnchor(errorlbl3, 25.0);

    start.getChildren().addAll(startMessage, currentLoc, fuelRange, truckPage, options,
            viewLocations, liveLocation, refuelbtn, errorlbl1, errorlbl2, errorlbl3, exitApp);
    
    //////////////// END STARTING SCENE /////////////////////
    
    //////////////// START LOCATION LIST SCENE ////////////////////
    
    Label locationLbl = new Label("Choose a location from the list: ");
    Label locCreateLbl = new Label("Or create a new location here: ");
    Label newLocName = new Label("Location Name: ");
    Label newLocX = new Label("X-Coordinate: ");
    Label newLocY = new Label("Y-Coordinate: ");
    Label newLocGas = new Label("Gas Station? ");
    Label locErrorCode = new Label(" ");
    Label locErrorCode2 = new Label(" ");
       
    locationFX placeH = new locationFX(" ",0,0,true); //placeholder that I need idk why, doesnt work without it
    
    TextField userLocName = new TextField();
    TextField userLocX = new TextField();
    TextField userLocY = new TextField();
    TextField userLocGas = new TextField();
    
    ObservableList<String> dropDown = 
    FXCollections.observableArrayList(
        "Yes",
        "No"
    );
    
    final ComboBox comboBox = new ComboBox(dropDown);
    
    Button backToStart2 = new Button();
        backToStart2.setText("Go Back");
        backToStart2.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(sceneStart);
        });
        
    Button driveToLoc = new Button();
        driveToLoc.setText("Drive To Location");
        driveToLoc.setOnAction((ActionEvent event) -> {
            int x = locations.getSelectionModel().getSelectedIndex();
            //is distance > or < range
            if(placeH.calcLocation(truck1.currentLocation(), locationArray.get(x)) < truck1.getRange()){
                double newRange = truck1.getRange() - placeH.calcLocation(truck1.currentLocation(), locationArray.get(x));
                truck1.driveToLocation(locationArray.get(x), newRange); 
                fuelRange.setText("Current Range: " + newRange + "miles");
                errorlbl2.setText("You have arrived at " + truck1.currentLocation().locationTitle());
                liveLocation.setText(locationArray.get(x).locationTitle());
            }
            //if range < needed distance
            else if (placeH.calcLocation(truck1.currentLocation(), locationArray.get(x)) > truck1.getRange()){
                errorlbl2.setText("Oops! You don't have enough gas! Current Range: " + truck1.getRange() + " miles.");
                errorlbl3.setText(placeH.calcLocation(truck1.currentLocation(), locationArray.get(x)) + " miles required.");
            }
            primaryStage.setScene(sceneStart);
        });
        
        
    Button submitNewLoc = new Button();
        submitNewLoc.setText("Create");
        submitNewLoc.setOnAction((ActionEvent event) -> {
            
            try{
                boolean gasDecision = false;
                if(comboBox.getSelectionModel().getSelectedItem().equals("Yes")){
                    //was stuck here for a long time because I thought I could do comboBox.equals(), turns out I can't.
                    gasDecision = true;
                }
                else if(comboBox.getSelectionModel().getSelectedItem().equals("No")){
                    gasDecision = false;
                }
                int placeLocX = Integer.parseInt(userLocX.getText());
                int placeLocY = Integer.parseInt(userLocY.getText());
                locations.getItems().add(new locationFX(userLocName.getText(), placeLocX, placeLocY, gasDecision));
                locationArray.add(new locationFX(userLocName.getText(), placeLocX, placeLocY, gasDecision));
                locErrorCode.setText(" ");
                locErrorCode2.setText(" ");
                }
            catch (Exception e){
                locErrorCode.setText("You're a rock. Numbers go in X and Y");
                locErrorCode2.setText("A name goes in 'Location Name'");
            }
            //Still working on getting gas station boolean from text
        });
        
    submitNewLoc.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
    driveToLoc.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
    backToStart2.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
        
    AnchorPane.setBottomAnchor(backToStart2, 25.0);
    AnchorPane.setRightAnchor(backToStart2, 25.0);
    
    AnchorPane.setTopAnchor(locations, 25.0);
    AnchorPane.setLeftAnchor(locations, 10.0);
    
    AnchorPane.setTopAnchor(locationLbl, 5.0);
    AnchorPane.setLeftAnchor(locationLbl, 10.0);
    
    AnchorPane.setTopAnchor(locCreateLbl, 5.0);
    AnchorPane.setRightAnchor(locCreateLbl, 75.0);
    
    AnchorPane.setTopAnchor(locErrorCode, 250.0);
    AnchorPane.setRightAnchor(locErrorCode, 100.0);
    
    AnchorPane.setTopAnchor(locErrorCode2, 275.0);
    AnchorPane.setRightAnchor(locErrorCode2, 100.0);
    
    AnchorPane.setTopAnchor(newLocName, 45.0);
    AnchorPane.setRightAnchor(newLocName, 200.0);
    
    AnchorPane.setTopAnchor(userLocName, 45.0);
    AnchorPane.setRightAnchor(userLocName, 15.0);
    
    AnchorPane.setTopAnchor(newLocX, 85.0);
    AnchorPane.setRightAnchor(newLocX, 209.0);
    
    AnchorPane.setTopAnchor(userLocX, 85.0);
    AnchorPane.setRightAnchor(userLocX, 15.0);
    
    AnchorPane.setTopAnchor(newLocY, 125.0);
    AnchorPane.setRightAnchor(newLocY, 209.0);
    
    AnchorPane.setTopAnchor(userLocY, 125.0);
    AnchorPane.setRightAnchor(userLocY, 15.0);
    
    AnchorPane.setTopAnchor(newLocGas, 165.0);
    AnchorPane.setRightAnchor(newLocGas, 209.0);
    
    AnchorPane.setTopAnchor(comboBox, 165.0);
    AnchorPane.setRightAnchor(comboBox, 95.0);
    
    AnchorPane.setTopAnchor(submitNewLoc, 200.0);
    AnchorPane.setRightAnchor(submitNewLoc, 125.0);
    
    AnchorPane.setTopAnchor(driveToLoc, 450.0);
    AnchorPane.setLeftAnchor(driveToLoc, 75.0);
    
    locationCreation.getChildren().addAll(backToStart2, locations, locationLbl, locCreateLbl, newLocName, userLocName,
            newLocX, userLocX, newLocY, userLocY, newLocGas, submitNewLoc, driveToLoc, locErrorCode,
            locErrorCode2, comboBox);
    //////////////// END LOCATION LIST SCENE ////////////////////
    
    
        primaryStage.setTitle("🚚 Truck Simulator");
        primaryStage.setScene(sceneStart);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
