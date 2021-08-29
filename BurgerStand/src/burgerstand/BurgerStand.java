/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerstand;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author s01164417
 */
public class BurgerStand extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ///////////// Scene Declarations ///////////////
        
        AnchorPane root = new AnchorPane();
        Scene sceneOrder = new Scene(root, 800,  600);
        
        AnchorPane root2 = new AnchorPane();
        Scene sceneAddItem = new Scene(root2, 800, 600);
        
        primaryStage.setTitle("Burger Stand");
        primaryStage.setScene(sceneOrder);
        
        //////////// END SCENE DECLARATIONS /////////////
        
        //////////// START SCENE ////////////////////////
        ListView<MenuItems> items = new ListView();
        
        items.getItems().add(new MenuItems("Hamburger", 400, 2.97));
        items.getItems().add(new MenuItems("Cheeseburger", 437, 3.39));
        items.getItems().add(new MenuItems("Fries", 332, 2.49));
        items.getItems().add(new MenuItems("Loaded Fries", 999, 6.09));
        
        Label showCal = new Label("Select item to see calories");
        
        Button btn = new Button();
        btn.setText("Select Item");
        btn.setOnAction((ActionEvent event) -> {
            int x = items.getSelectionModel().getSelectedIndex();
            showCal.setText("Calories: " + items.getItems().get(x).getCalories());
        });
        
        Button btnAddItem = new Button();
        btnAddItem.setText("Add Item");
        btnAddItem.setOnAction((ActionEvent event) -> {
        primaryStage.setScene(sceneAddItem);
        });
       
        
        AnchorPane.setBottomAnchor(btn, 150.0);
        AnchorPane.setRightAnchor(btn, 10.0);
        
        AnchorPane.setBottomAnchor(btnAddItem, 150.0);
        AnchorPane.setRightAnchor(btnAddItem, 180.0);
        
        
        AnchorPane.setTopAnchor(items, 10.0);
        AnchorPane.setRightAnchor(items, 10.0);
        
        AnchorPane.setTopAnchor(showCal, 10.0);
        AnchorPane.setLeftAnchor(showCal, 10.0);
        
        root.getChildren().addAll(btn, items, showCal, btnAddItem);
        
       //////////////// END SCENE /////////////////////////////////
       
       /////////////// START SCENE 2 //////////////////////////////
       
       Label scene2heading = new Label("Add Item To The Burger Stand List");
       
       Label lblitemName = new Label("Item: ");
       Label lblitemCal = new Label("Calories: ");
       Label lblitemPrice = new Label("Price: ");
       
       TextField itemName = new TextField();
       TextField itemCal = new TextField();
       TextField itemPrice = new TextField();
       
       Button btnCancelItem = new Button();
       btnCancelItem.setText("Go Back");
       btnCancelItem.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(sceneOrder);
       });
       
       Button btnConfirmItem = new Button();
       btnConfirmItem.setText("Confirm");
       btnConfirmItem.setOnAction((ActionEvent event) -> {
           
           int calValue = Integer.parseInt(itemCal.getText());
           double priceValue = Double.parseDouble(itemPrice.getText());
           
           try{
           items.getItems().add(new MenuItems(itemName.getText(), calValue, priceValue));
           
           primaryStage.setScene(sceneOrder);
           }
           catch(NumberFormatException exception){
               scene2heading.setText("You can only type numbers");
           }
       });
             
       AnchorPane.setTopAnchor(lblitemName, 100.0);
       AnchorPane.setLeftAnchor(lblitemName, 10.0);
       
       AnchorPane.setTopAnchor(itemName, 100.0);
       AnchorPane.setLeftAnchor(itemName, 160.0);
       
       AnchorPane.setTopAnchor(lblitemCal, 130.0);
       AnchorPane.setLeftAnchor(lblitemCal, 10.0);
       
       AnchorPane.setTopAnchor(itemCal, 130.0);
       AnchorPane.setLeftAnchor(itemCal, 160.0);
       
       AnchorPane.setTopAnchor(lblitemPrice, 160.0);
       AnchorPane.setLeftAnchor(lblitemPrice, 10.0);
       
       AnchorPane.setTopAnchor(itemPrice, 160.0);
       AnchorPane.setLeftAnchor(itemPrice, 160.0);
       
       AnchorPane.setBottomAnchor(btnCancelItem, 350.0);
       AnchorPane.setRightAnchor(btnCancelItem, 500.0);
       
       AnchorPane.setBottomAnchor(btnConfirmItem, 350.0);
       AnchorPane.setRightAnchor(btnConfirmItem, 650.0);
       
       AnchorPane.setTopAnchor(scene2heading, 10.0);
       AnchorPane.setLeftAnchor(scene2heading, 10.0);
       
       
       root2.getChildren().addAll(scene2heading, lblitemName, itemName, lblitemCal, itemCal, lblitemPrice, itemPrice, btnCancelItem, btnConfirmItem);

       
       
       /////////////// END SCENE 2//////////////////////////////

       
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
