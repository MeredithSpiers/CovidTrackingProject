/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiersmecovidproject;
/**
 *
 * @author Meredith Spiers
 */

public class CovidData implements java.io.Serializable {
    // the fields below was referenced from the NYTNewsStory.java file of the NYTimesViewer class example
    private String date;
    private Integer positive;
    private Integer negative;
    private Integer hospitalizedCurrently;
    private Integer hospitalizedCumulative;
    private Integer recovered;
    private Integer death;
    
    private boolean dataValidation = false;
    
    // the method below was referenced from https://stackoverflow.com/questions/43308394/split-csv-and-store-in-different-arrays-in-java
    public CovidData(String data) {
        try {
            String [] createDailyData = data.split(",", 25);
            this.date = createDailyData[0];
            this.positive = Integer.parseInt(createDailyData[2]);
            this.negative = Integer.parseInt(createDailyData[3]);
            this.hospitalizedCurrently = Integer.parseInt(createDailyData[4]);
            this.hospitalizedCumulative = Integer.parseInt(createDailyData[5]);
            this.recovered = Integer.parseInt(createDailyData[6]);
            this.death = Integer.parseInt(createDailyData[7]);
            dataValidation = true;
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    // the getters and setters below were referenced from the Person.java file of the SerializationJsonExample class example
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setPositive(Integer positive) {
        this.positive = positive;
    }
    
    public void setNegative(Integer negative) {
        this.negative = negative;
    }
    
    public void setHospitalizedCurrently(Integer hospitalizedCurrently) {
        this.hospitalizedCurrently = hospitalizedCurrently;
    }
    
    public void setHospitalizedCumulative(Integer hospitalizedCumulative) {
        this.hospitalizedCumulative = hospitalizedCumulative;
    }
    
    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }
    
    public void setDeath(Integer death) {
        this.death = death;
    }
    
   
    
    public String getDate() {
        return date;
    }
    
    public Integer getPositive() {
        return positive;
    }
    
    public Integer getNegative() {
        return negative;
    }
    
    public Integer getHospitalizedCurrently() {
        return hospitalizedCurrently;
    }
    
    public Integer getHospitalizedCumulative() {
        return hospitalizedCumulative;
    }
    
    public Integer getRecovered() {
        return recovered;
    }
    
    public Integer getDeath() {
        return death;
    }
    
    public boolean getDataValidation() {
        return dataValidation;
    }
}
