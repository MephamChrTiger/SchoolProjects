/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//     Textfields -> Pane -> Scene -> Stage

/**
 *
 * @author s01164417
 */
public class TestFX extends Application {
    
    @Override
    public void start(Stage primaryStage) { //stage is the window that the program shows up on
        
        Label message = new Label();
        message.setText("Hello World!");
        
        TextField input1 = new TextField(); //Text box, user types something in
        TextField input2 = new TextField();
        
        Button btn = new Button();
        btn.setText("Push Me!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                double x = Double.parseDouble(input1.getText()) + Double.parseDouble(input2.getText());
                message.setText("Answer: " + x);
            }
        });
        
        AnchorPane root = new AnchorPane();
        
        AnchorPane.setBottomAnchor(btn, 10.0);
        AnchorPane.setRightAnchor(btn, 10.0);
        
        AnchorPane.setTopAnchor(input1, 50.0);
        AnchorPane.setLeftAnchor(input1, 10.0);
        
        AnchorPane.setTopAnchor(input2, 100.0);
        AnchorPane.setLeftAnchor(input2, 10.0);
        
        root.getChildren().addAll(btn,message,input1, input2);
//        root.getChildren().add(btn);
//        root.getChildren().add(message);
//        root.getChildren().add(input1);
        
        Scene scene = new Scene(root, 300, 250); //scene is what is set up, like a scene on a stage, and can change
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
