package com.learn.spark

import org.apache.spark.SparkContext._;
import org.apache.spark._;
import org.apache.log4j._; 


object RatingsCount {
  
  
  
  def main(args : Array[String]) {
    
    Logger.getLogger("org").setLevel(Level.ERROR); 
    
    val sc = new SparkContext("local[*]","RatingsCount");
    
    val data = sc.textFile("../ml-100k/u.data");
    
    val ratings = data.map(x => x.toString().split("\t")(2)); 
    
    val countRatings = ratings.countByValue();
    countRatings.foreach(println);
    
    
    
  }
}