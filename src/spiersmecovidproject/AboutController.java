/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiersmecovidproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Meredith Spiers
 */
// the class and objects below were referenced from the SwitcherExample from class
public class AboutController extends Switchable implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    @FXML
    private void handleGoToGraph(ActionEvent event) {
        Switchable.switchTo("Graph");
        
        GraphController controller = (GraphController)getControllerByName("Graph");
    }  
}