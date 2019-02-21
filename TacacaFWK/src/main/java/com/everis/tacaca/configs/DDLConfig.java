package com.everis.tacaca.configs;

import org.apache.log4j.Logger;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class DDLConfig {
	private static final Logger log = Logger.getLogger(DDLConfig.class);

	public String generateRawZoneDDL(final StructType structType, final String type) {

		try {
			StringBuilder ddl = new StringBuilder();
			if (type.length() > 0) {
				ddl.append(String.format("CREATE TABLE IF NOT EXISTS %s (", ""));
				for (StructField field : structType.fields()) {
					ddl.append(String.format(",%s %s", field.name(), "STRING"));
				}
				ddl.append(")");
				ddl.append(" STORED as parquet ");
				ddl.append(" LOCATION %s ");
				ddl.append(";");
				
				log.info(ddl.toString());
				
				return ddl.toString().replace("(,", "(");
			}
		} catch (Exception e) {
			log.info("\n[ Formato para geracao de DDL incompreendido ]\n");
			e.getMessage();
		}
		return null;
	}

}
