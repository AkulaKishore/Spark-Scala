package com.learn.spark


import org.apache.spark._;
import org.apache.spark.SparkContext._;
import org.apache.log4j._;



object wordcount {
 
  
  def main(args:Array[String]) {
    
    Logger.getLogger("org").setLevel(Level.ERROR);
    
    
    val sc = new SparkContext("local[*]","WordCount");
    
    val data = sc.textFile("../book.txt");
    
    
    val formatedData = data.flatMap(x => x.split(" "));
    
    val wordCounts = formatedData.countByValue();
    
    wordCounts.foreach(println); 
  }
}
