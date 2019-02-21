package com.everis.tacaca.adapters;

import com.everis.tacaca.annotations.Column;
import com.everis.tacaca.annotations.Positional;
import org.apache.log4j.Logger;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataTypes;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class File {
	private static final Logger log = Logger.getLogger(File.class);

	public DataFrame parsePositionalFile(DataFrame df, SQLContext sqlC, Field[] allFields){
		//sqlC.udf().register("udfFilter", (String line) -> line.length(), DataTypes.StringType);
		Arrays.sort(allFields, (Field f1, Field f2) -> Integer.compare(f1.getAnnotation(Column.class).order(), f2.getAnnotation(Column.class).order()));
		DataFrame df2 = null;
		//int sliceAux = 0;
		for (Field field : allFields) {
			Column column = field.getAnnotation(Column.class);
			Positional position = field.getAnnotation(Positional.class);
			sqlC.udf().register("sliceUDF", (String line) -> line.substring(position.startPosition(), position.endPosition()), DataTypes.StringType);
			df2 = df.withColumn(column.columnName(), functions.callUDF("sliceUDF", functions.col("col0")));
		}

		return df2;
	}

}
