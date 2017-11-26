package com.omalperera.generatenames


import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object App 
{
    def main(args: Array[String]):Unit={
      println( "Hello World!" );
      val logFile = "/Users/Omal/Desktop/inputtext.txt"
      val spark = SparkSession.builder.appName("Simple Application").config("spark.master", "local").getOrCreate()
      val logData = spark.read.textFile(logFile).cache()
      val numAs = logData.filter(line => line.contains("a")).count()
      val numBs = logData.filter(line => line.contains("b")).count()
      println(s"Lines with a: $numAs, Lines with b: $numBs")
      spark.stop()
    }
}
