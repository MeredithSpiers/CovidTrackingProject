/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiersmecovidproject;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Meredith Spiers
 */
public class GraphController extends Switchable implements Initializable, CovidInterface {
    // the fields below were referenced from my FXMLCPUMonitorF20 challenge submission
    @FXML
    private XYChart.Series<String, Number> seriesLineChart;
    
    @FXML
    private LineChart<String, Number> covidLineChart;
    
    @FXML
    private Label graphLabel;
    
    @FXML
    private CategoryAxis xAxis; 
    
    @FXML
    private NumberAxis yAxis;

    @FXML
    private ComboBox combo;
    
    private Timeline timeline;
    
    public CovidModel covidModel;
    
    
    
    // the method below was referenced from https://www.youtube.com/watch?v=rKv8eavrAio
    @FXML
    void selectData(ActionEvent event) {
        String s = combo.getSelectionModel().getSelectedItem().toString();
        displayChartData();
    }
    
    // the method below was referenced from https://www.youtube.com/watch?v=rKv8eavrAio
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> dataTypesList = FXCollections.observableArrayList("Positive Cases", "Negative Cases", "Current Hospitalizations", "Cumulative Hospitalizations", "Recovered Cases", "Deaths");
        combo.setItems(dataTypesList);
        covidModel = new CovidModel();
    }
    
    // the event below was referenced from the SwitcherExample from class
    @FXML
    private void handleGoToAbout(ActionEvent event) {
        Switchable.switchTo("About");
    }
       
    // the method below were referenced from my FXMLCPUMonitorF20 challenge submission
    @Override
    public void displayChartData() { 
        seriesLineChart = new XYChart.Series();
        // the line below was referenced from https://stackoverflow.com/questions/12093556/javafx-2-x-how-to-remove-xy-line-chart-once-plotted/12114048
        covidLineChart.getData().clear();
        covidLineChart.getData().add(seriesLineChart);
        
        // the line below was referenced from https://www.youtube.com/watch?v=rKv8eavrAio
        String s = combo.getSelectionModel().getSelectedItem().toString();
        graphLabel.setText( s + " (per week)");
        xAxis.setLabel("Date");
        yAxis.setLabel("Number of " + s );
        // the line below was referenced from a combination of the controller of MVCExample class example, MVCStopwatch class example, and tutoring help.
        List<CovidData> covidDataList = covidModel.getCovidDataList();
        // the line below was referenced from https://examples.javacodegeeks.com/core-java/util/collections/reverse-order-of-list-example/
        Collections.reverse(covidDataList);
        
        switch (s)
        {
            case "Positive Cases":
                graphLabel.setText("Cumulative " + s + " (per week)");
                // the for loops in each of the cases was referenced from https://www.javatpoint.com/java-for-loop
                for (CovidData i : covidDataList) {
                    if( i.getDataValidation() == true){
                        // the line below and in all of the cases was referenced from my SpiersmeFXMLCPUMonitorF20 challenge submission
                        seriesLineChart.getData().add(new XYChart.Data(i.getDate(), i.getPositive())); 
                    }
                } 

                break;
            case "Negative Cases":
                graphLabel.setText("Cumulative " + s + " (per week)");
                for (CovidData i : covidDataList) {
                    if( i.getDataValidation() == true){
                        seriesLineChart.getData().add(new XYChart.Data(i.getDate(), i.getNegative())); 
                    }    
                }
                break;
            case "Current Hospitalizations":
                for (CovidData i : covidDataList) {
                    if( i.getDataValidation() == true){
                        seriesLineChart.getData().add(new XYChart.Data(i.getDate(), i.getHospitalizedCurrently())); 
                    }
                }
                break;
            case "Cumulative Hospitalizations":
                for (CovidData i : covidDataList) {
                    if( i.getDataValidation() == true){
                        seriesLineChart.getData().add(new XYChart.Data(i.getDate(), i.getHospitalizedCumulative())); 
                    }    
                }
                break;
            case "Recovered Cases":
                for (CovidData i : covidDataList) {
                    graphLabel.setText("Cumulative " + s + " (per week)");
                    if( i.getDataValidation() == true){
                        seriesLineChart.getData().add(new XYChart.Data(i.getDate(), i.getRecovered())); 
                    }
                }
                break;
            case "Deaths":
                for (CovidData i : covidDataList) {
                    graphLabel.setText("Current " + s + " (per week)");
                    if( i.getDataValidation() == true){
                        seriesLineChart.getData().add(new XYChart.Data(i.getDate(), i.getDeath())); 
                    }
                }
                break;
            default: 
                System.out.println("Error: Please make a selection"); 
        }
    }
}