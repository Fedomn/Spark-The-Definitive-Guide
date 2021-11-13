//Spark SQL is a Spark module for structured data processing
//Spark SQL provide Spark with more information about the structure of both the data and the computation being performed

import org.apache.spark.sql.SparkSession

object StructuredAPI {
  def main(args: Array[String]): Unit = {
    println("Hello, StructuredAPI !")

    val spark = SparkSession
      .builder()
      .appName("StructuredAPI")
      .master("local[2]")
      .getOrCreate()

    val path = getClass.getResource("./data/flight-data/json/2015-summary.json").toString
    println(path)

    val df = spark.read.format("json").load(path)
    df.printSchema()
  }
}