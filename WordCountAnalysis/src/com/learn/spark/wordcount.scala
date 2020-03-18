package com.learn.spark


import org.apache.spark._;
import org.apache.spark.SparkContext._;
import org.apache.log4j._;



object wordcount {
 
  
  def main(args:Array[String]) {
    
    Logger.getLogger("org").setLevel(Level.ERROR);
    
    
    val sc = new SparkContext("local[*]","WordCount");
    
    val data = sc.textFile("../book.txt");
    
    
    val formatedData = data.flatMap(x => x.split("\\W+"));
    
    val lowercase = formatedData.map(x=> x.toLowerCase());
    
    val mappedData = lowercase.map(x => (x,1)).reduceByKey((x,y) => (x+y));
    
    val rotateData = mappedData.map(x =>(x._2.toInt,x._1));
    val results = rotateData.sortByKey();
    
   for( result <- results) {
     
     val count = result._1;
     val word = result._2;
     println(s"$word : $count");
   }
  }
}
