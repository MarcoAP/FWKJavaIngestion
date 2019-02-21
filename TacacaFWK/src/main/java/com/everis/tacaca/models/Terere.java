//package com.everis.tacaca.models;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.apache.derby.tools.sysinfo;
//import org.apache.hadoop.hive.serde2.objectinspector.StructField;
//import org.apache.spark.SparkConf;
//import org.apache.spark.SparkContext;
//import org.apache.spark.sql.DataFrame;
//import org.apache.spark.sql.SQLContext;
//import org.apache.spark.sql.types.DataTypes;
//import org.apache.spark.sql.types.StructType;
//
//import scala.tools.nsc.typechecker.ContextErrors.SymbolTypeError;
//
//public class Terere {
//
//	public static void main2(String[] args) {
//		SparkConf sc = new SparkConf()
//				.setMaster("local")
//				.setAppName("[Squad FI] Motor de ingestao - Carga Diaria Secao");
//
//		SparkContext sContext = new SparkContext(sc).getOrCreate();
//		 
//		SQLContext sqlContext = new SQLContext(sContext); 	
//		
//		Map<String, String> mOption = new LinkedHashMap<>();
//		mOption.put("delimiter", ";");
//		mOption.put("header", "true");
//		mOption.put("spark.sql.caseSensitive", "false");
//		
//		StructType schema = new StructType();
//		schema.add("nome", DataTypes.StringType, false);
//		schema.add("idade", DataTypes.IntegerType, false);
//		schema.add("sigla", DataTypes.StringType, false);
//		
//		DataFrame df = sqlContext.read().format("com.databricks.spark.csv").options(mOption).load("hdfs:///tmp/terere.txt"); 
//		System.out.println("\n\n---------------------------------------");
////		System.out.println(df.count());
////		System.out.println(df.schema()); //StructType(StructField(value,StringType,true))
////		df.printSchema(); 
////		df.show();
////		df.filter(df.col("idade").gt(30)).show(); //where
////		df.groupBy("nome").count().show();
//		df.select("nome","sigla").show();
//		
//		df.write().format("parquet").save("hdfs:///tmp/vixi/show.parquet");
//		
//		System.out.println("---------------------------------------\n\n");
//
//	}
// 
//	
//	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
////		Class<HiveModel> hm = HiveModel.class;
////		for(Field f : hm.getDeclaredFields()) {
////			System.out.println(f.getName() + " --- " + f.getType() + " --- " + f.getDeclaringClass());
////			
////		}
////		for(Method m : hm.getDeclaredMethods()) {
////			System.out.println(m.getName() + " --- " + m.getGenericReturnType());
////			System.err.println(m.invoke(hm));
////		}
//	}
//
//}
