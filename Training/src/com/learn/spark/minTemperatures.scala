package com.learn.spark

import org.apache.spark._;
import org.apache.spark.SparkContext._;
import org.apache.log4j._;
import scala.math.min; 

object minTemperatures {
  
  def parseLines(s: String) = {
    
    val fields : Array[String] = s.split(",");
    
    val workstation = fields(0);
    val measure = fields(2);
    val values = fields(3);
    
    (workstation,measure,values);
  }

  def main(args: Array[String]) {
    
    Logger.getLogger("org").setLevel(Level.ERROR);
    
    val sc = new SparkContext("local[*]", "mintemp");
    
    //read data from the text file
    val data = sc.textFile("../1800.csv");
    
    // convert into suitable format using parseLines function passing to map
    val requiredData = data.map(parseLines);
    
    //filtering for only TMIN values
    val minTempData = requiredData.filter(x => x._2 == "TMIN") 
    
    //removing extra column TMIN has all the values are related to TMIN
    val stationTemp = minTempData.map(x => (x._1,(x._3).toFloat));
    
    //finding minimum temp for that workstation. Used min function of scala.math.min utility;
    val minTempByStation = stationTemp.reduceByKey((x,y) => min(x,y) );
    
    //got results back to driver
    val results = minTempByStation.collect();
    
    //iterate and formatting as needed to print output
    for (result <- results.sorted) {
      
      val station = result._1;
      val temp = result._2;
      
      val formatedtemp = f"$temp%.2f F";
      
      println(s"$station minimum temperature : $formatedtemp");
      
    } 
  }
}