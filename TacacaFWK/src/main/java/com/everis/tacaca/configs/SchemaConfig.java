package com.everis.tacaca.configs;

import com.everis.tacaca.annotations.Column;
import org.apache.log4j.Logger;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchemaConfig {
	private static final Logger log = Logger.getLogger(SchemaConfig.class);
	private Class<?> objClass;
	private Field[] dfColumns;
	private String ddl = "";
	
	public String getDdl() {
		return ddl;
	}

	public void setDdl(String ddl) {
		this.ddl = ddl;
	}

	public SchemaConfig(Class<?> objClass) {
		this.objClass = objClass;
		setDfColumns(removeNonColumnFields());
	}

	public Field[] getDfColumns() {
		return dfColumns;
	}

	private void setDfColumns(Field[] dfColumns) {
		this.dfColumns = dfColumns;
	}

	private Field[] removeNonColumnFields() {
		ArrayList<Field> newFields = new ArrayList<>();
		log.info("Criando Field[] apenas com campos que possuem anotacao de Column");
		for (Field field : objClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(Column.class))
				newFields.add(field);
		}
		Field[] columns = new Field[newFields.size()];
		columns = newFields.toArray(columns);
		return columns;
	}

	public StructType getSchema() {
		StructType structType = new StructType();
		Map<String, String> fields = new LinkedHashMap<String, String>();

		log.info("Criando StructType do Spark");
		for (Field field : getDfColumns()) {
			Column column = field.getAnnotation(Column.class);
			fields.put(column.columnName(), String.valueOf(column.nullable()));
			structType.add(column.columnName(), DataTypes.StringType, column.nullable());
		}

		setDdl(new DDLConfig().generateRawZoneDDL(structType, "HIVE"));

		log.info(getDdl());
		log.info("StructType criado: " + fields);
		return structType;
	}

}
