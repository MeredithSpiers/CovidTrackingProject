/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiersmecovidproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Meredith Spiers
 *
 */

public class CovidModel {
    
    // Lines 23-27 were referenced from https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html
    List<CovidData> covidDatas;
    public CovidModel(){
        // the data was accessed from https://covidtracking.com/data/api
        covidDatas = readDataFromCSV("daily.csv");
    } 
    
    // the List below was referenced from MVCExampleModel.java of class example MVCExample
    public List<CovidData> getCovidDataList(){
        return covidDatas;
    }
    
    // the List below was referenced from https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html and from MVCExampleModel.java of class example MVCExample
    private static List<CovidData> readDataFromCSV(String fileName) {
        List<CovidData> covidDatas = new ArrayList<>();
        fileName = "src/spiersmecovidproject/daily.csv";
        
        int i = 0;
        // the try and while statements below were referenced from https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html
        try{
            File fd = new File(fileName);
            Scanner sd = new Scanner(fd); 

            while (sd.hasNextLine()) {
                if (i != 0){
                    i++;
                    covidDatas.add(new CovidData(sd.nextLine()));
                }
                i++;
            }
        // the remaining code below was referenced from https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html
        } catch(Exception e) {
            
            e.printStackTrace();
        }
        return covidDatas;
    }  
}