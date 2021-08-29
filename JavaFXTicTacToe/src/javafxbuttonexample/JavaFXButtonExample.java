/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbuttonexample;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author John Ostroske
 */
public class JavaFXButtonExample extends Application
{
    //Media media = new Media(""); 
    //MediaPlayer mediaPlayer = new MediaPlayer(media);  
    

    @Override
    public void start(Stage primaryStage)
    {
        
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 640, 480);
        
        AnchorPane endScreen = new AnchorPane();
        Scene endScene = new Scene(endScreen, 640, 480);
        
        ///////START SCENE//////////
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe     -     Press a Tile to Begin!");
        
         
        

        GameManager gm = new GameManager();
        
        ArrayList<Tile> combos = new ArrayList<>();

        Tile[][] btn = new Tile[3][3];
        
        
        for(int i = 0; i < btn.length; i++)
        {
            for(int j = 0; j < btn[i].length; j++)
            {
                btn[i][j] = new Tile(i, j);
                btn[i][j].setText(" ");
                btn[i][j].setPrefSize(100, 100);
                btn[i][j].setOnAction((ActionEvent event) ->
                {
                    
                    
                    Boolean XhasWon = false;
                    Boolean OhasWon = false;
                    Tile temp = (Tile)event.getSource();
                    int x = temp.getX();
                    int y = temp.getY();
                    
                    if(gm.takeTurn())
                    {
                        primaryStage.setTitle("Tic Tac Toe");
                        btn[x][y].setText("X");
                    }
                    else
                    {
                        btn[x][y].setText("O");
                    }
                    
                    /////////////WINNING MECHANIC//////////// - I know its really messy im sorry but it works
                    //probably could have made it easier with a arraylist of tile spaces but it was taking too long to figure it out
                    
                   //Vertical
                   for(int u = 0; u < 3; u++){
                       if(btn[0][u].textProperty().getValue().equals("X") && btn[1][u].textProperty().getValue().equals("X") && btn[2][u].textProperty().getValue().equals("X")){
                           XhasWon = true;
                       }
                   }
                   for(int u = 0; u < 3; u++){
                       if(btn[0][u].textProperty().getValue().equals("O") && btn[1][u].textProperty().getValue().equals("O") && btn[2][u].textProperty().getValue().equals("O")){
                           OhasWon = true;
                           
                       }
                   }
                   
                   //Horizontal
                   for(int w = 0; w < 3; w++){
                       if(btn[w][0].textProperty().getValue().equals("X") && btn[w][1].textProperty().getValue().equals("X") && btn[w][2].textProperty().getValue().equals("X")){
                           XhasWon = true;                           
                       }
                   }
                   for(int w = 0; w < 3; w++){
                       if(btn[w][0].textProperty().getValue().equals("O") && btn[w][1].textProperty().getValue().equals("O") && btn[w][2].textProperty().getValue().equals("O")){
                           OhasWon = true;                           
                       }
                   }
                   
                   //Diagonal X
                   if(btn[0][0].textProperty().getValue().equals("X") && btn[1][1].textProperty().getValue().equals("X") && btn[2][2].textProperty().getValue().equals("X")){
                       XhasWon = true;
                   }
                   else if(btn[2][0].textProperty().getValue().equals("X") && btn[1][1].textProperty().getValue().equals("X") && btn[0][2].textProperty().getValue().equals("X")){
                       XhasWon = true;
                   }
                   //Diagonal O
                   if(btn[0][0].textProperty().getValue().equals("O") && btn[1][1].textProperty().getValue().equals("O") && btn[2][2].textProperty().getValue().equals("O")){
                       OhasWon = true;
                   }
                   else if(btn[2][0].textProperty().getValue().equals("O") && btn[1][1].textProperty().getValue().equals("O") && btn[0][2].textProperty().getValue().equals("O")){
                       XhasWon = true;
                   }
                   
                   if(XhasWon == true){
                       //Reset Board and switch to end screen
                       primaryStage.setTitle("--X Has Won!!--");
                       for(int v = 0; v < 3; v++)
                        {
                            for(int b = 0; b < 3; b++) {
                                btn[v][b].setText(" ");
                            }
                        }
                       primaryStage.setScene(endScene);
                   }
                   else if(OhasWon == true){
                       primaryStage.setTitle("--O Has Won!!--");
                       for(int v = 0; v < 3; v++)
                        {
                            for(int b = 0; b < 3; b++) {
                                btn[v][b].setText(" ");
                            }
                        }
                       primaryStage.setScene(endScene);
                   }
                        
                });
                
                
                btn[i][j].setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
                

                AnchorPane.setTopAnchor(btn[i][j], 40.0 + i * 110);
                AnchorPane.setLeftAnchor(btn[i][j], 80.0 + j * 110);
                
                root.getChildren().addAll(btn[i][j]);
                
                /////////////END START SCENE/////////
                
                ///////START WINNING SCENE//////////
                //mediaPlayer.setVolume(50);
                //mediaPlayer.play();
                Button newGame = new Button();
                newGame.setText("Play Again");
                newGame.setOnAction((ActionEvent event) -> {
                    primaryStage.setTitle("Tic Tac Toe     -     Press a Tile to Begin!");
                    primaryStage.setScene(scene);
                });
        
                Button endGame = new Button();
                endGame.setText("Exit Game");
                endGame.setOnAction((ActionEvent event) -> {
                    Platform.exit();
                });
                
                Label hasWon = new Label("What a Game!!! Play Again?");
                
                
                
                
                
                
                
                
                newGame.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
                endGame.setStyle("-fx-background-color: deepskyblue; -fx-text-fill: white;");
                
                AnchorPane.setTopAnchor(hasWon, 120.0);
                AnchorPane.setLeftAnchor(hasWon, 225.0);
                AnchorPane.setTopAnchor(newGame, 175.0);
                AnchorPane.setRightAnchor(newGame, 285.0);
                AnchorPane.setTopAnchor(endGame, 225.0);
                AnchorPane.setRightAnchor(endGame, 285.0);
                endScreen.getChildren().addAll(newGame,endGame, hasWon);
            }
        }
        
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
