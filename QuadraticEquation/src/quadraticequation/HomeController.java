/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package quadraticequation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane splash;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getStarted(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Solver.fxml"));
        Stage stage = new Stage(); 
        Scene scene = new Scene(root);
      
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        splash.getScene().getWindow().hide();
        
    }
    
}
