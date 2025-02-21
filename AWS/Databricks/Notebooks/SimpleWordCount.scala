// Databricks notebook source
println("Hello World")

// COMMAND ----------

val list = List(
  "Hello World!",
  "Hello How are you?",
  "Hello Again",
  "Hello one last time",
  "Hello Hello."
)

// COMMAND ----------

import spark.implicits._

// COMMAND ----------

val df1 = list.toDF("sentence")

// COMMAND ----------

import org.apache.spark.sql.functions._

// COMMAND ----------

val df2 = df1.withColumn("word", explode(split(col("sentence"), "\\W+")))
val df3 = df2.groupBy("word").agg(count("*").as("word_count"))
df3.show()