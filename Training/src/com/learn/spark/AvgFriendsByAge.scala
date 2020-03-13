package com.learn.spark
import org.apache.spark.SparkContext._;
import org.apache.spark._;
import org.apache.log4j._;

object AvgFriendsByAge {
  
  
 def parseLine(s : String) = {
   
   val field : Array[String]  = s.split(",");
   val age  : Int  = field(2).toInt;
   val friends : Int = field(3).toInt;
   (age,friends)
 }
 
 def main(args : Array[String]) {
   
   Logger.getLogger("org").setLevel(Level.ERROR);
   
   val sc = new SparkContext("local[*]","AvgFriendsByAge");
   
   val data = sc.textFile("../friendsByAge.txt");
   
   val rdd = data.map(parseLine);
   
   val ageTotals = rdd.mapValues(x => (x,1)).reduceByKey((x,y) => (x._1+y._1,x._2+y._2))
   
   val avgFriends = ageTotals.mapValues(x => (x._1/ x._2));
   
   val results = avgFriends.collect();
   
   results.foreach(println)
   
   
   
   
 }
}