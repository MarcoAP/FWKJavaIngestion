package com.everis.tacaca.adapters;

import org.apache.log4j.Logger;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.functions;
import scala.ScalaReflectionException;
import org.apache.spark.sql.SQLImplicits.*;
import scala.Tuple2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hive {
	private static final Logger log = Logger.getLogger(Hive.class);

	// TODO - Gravar append
	// TODO - Gravar em partição
	// TODO ---- Criar lógica para cada tipo de partição
	// TODO ---- Parametrizar o repartition

	public void tableAppended(DataFrame df) {
		df.write().format("parquet").mode(SaveMode.Append).saveAsTable("");
	}

	public void tablePartitionedByDay(DataFrame df, String columnName, String tableName) {
		Tuple2<String, String>[] dtypes = df.dtypes();
		boolean hasPartition = false;
		for(Tuple2<String, String> col : dtypes)
			hasPartition = (col._1.toLowerCase().equals(columnName.toLowerCase()));

		if(!hasPartition){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			String today = fmt.format(cal.getTime());
			df = df.withColumn(columnName, functions.lit(today));
		}
		df.write().format("parquet").partitionBy(columnName).mode(SaveMode.Append).saveAsTable(tableName);
	}

	public void tablePartitionedByWeek() {

	}

	public void tablePartitionedBy15Days() {

	}

	public void tablePartitionedByMonth(DataFrame df, String columnName, String tableName) {
		Tuple2<String, String>[] dtypes = df.dtypes();
		boolean hasPartition = false;
		for(Tuple2<String, String> col : dtypes)
			hasPartition = (col._1.toLowerCase().equals(columnName.toLowerCase()));

		if(!hasPartition){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM");
			String today = fmt.format(cal.getTime());
			df = df.withColumn(columnName, functions.lit(today));
		}
		df.write().format("parquet").partitionBy(columnName).mode(SaveMode.Append).saveAsTable(tableName);
	}
	
	public void tablePartitionedByBimester() {

	}
	
	public void tablePartitionedByTrimester() {

	}
	
	public void tablePartitionedBySemester() {

	}
	
	public void tablePartitionedByYear(DataFrame df, String columnName, String tableName) {
		Tuple2<String, String>[] dtypes = df.dtypes();
		boolean hasPartition = false;
		for(Tuple2<String, String> col : dtypes)
			hasPartition = (col._1.toLowerCase().equals(columnName.toLowerCase()));

		if(!hasPartition){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
			String today = fmt.format(cal.getTime());
			df = df.withColumn(columnName, functions.lit(today));
		}
		df.write().format("parquet").partitionBy(columnName).mode(SaveMode.Append).saveAsTable(tableName);
	}

}
