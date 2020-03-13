package com.learn.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._;


/** Count up how many of each star rating exists in the MovieLens 100K data set. */
object Ratings {
  
  def main(args :Array[String]) {
    
    Logger.getLogger("org").setLevel(Level.ERROR);
    val sc = new SparkContext("local[*]","Ratings");
    
    val rdd = sc.textFile("../ml-100k/u.data",4)
    println(rdd)
    
    val lines = rdd.map(x => x.toString.split("\\s")(2))   
   
    
    val ratings = lines.countByValue();
    
    val sortedresults = ratings.toSeq.sortBy(_._1)
    sortedresults.foreach(println)
   
    
  }
}