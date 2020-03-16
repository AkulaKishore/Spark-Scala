package com.learn.spark

import minTemperatures.parseLines;
import org.apache.spark._;
import org.apache.spark.SparkContext._;
import org.apache.log4j._;
import scala.math.max;

object maxTemperatures {
  
  def main(args:Array[String]) {
    
    Logger.getLogger("org").setLevel(Level.ERROR);
    
    //start spark context 
    val sc = new SparkContext("local[*]","maxTemp");
    //read data from the text file
    val data = sc.textFile("../1800.csv");
    //parsedata
    val formatedData = data.map(parseLines);
    
    //filter data to get max temperatures
    val filteredData = formatedData.filter(x => (x._2 =="TMAX"));
    
    //REMOVE tmax column
    val maxTemperatures = filteredData.map(x => (x._1,x._3.toFloat));
    
    //max tempeartures by workstation
    val maxTempByStation = maxTemperatures.reduceByKey((x,y) => max(x,y));
    
    //collect the data to driver
    val results = maxTempByStation.collect();
    
    for(result <- results) {
      val workstation = result._1;
      val temp = result._2;
      
      val formattedTemp = f"$temp%.2f F";
      println(s"$workstation maximum temperatures : $formattedTemp"); 
    }
    
    
  }
  
}