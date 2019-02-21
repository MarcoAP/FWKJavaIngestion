package com.everis.tacaca.configs;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SQLContext;

import com.everis.tacaca.adapters.CMD;
import com.everis.tacaca.adapters.squads.SquadFIAdapter;
import com.everis.tacaca.annotations.Partitioned;
import com.everis.tacaca.annotations.Raw;
import com.everis.tacaca.enums.ResourceConfig;
import com.everis.tacaca.properties.Property;
import com.everis.utils.Quotation;

public class RawConfig {

	private static final Logger log = Logger.getLogger(RawConfig.class);
	private static SparkContext sc = null;
	private static SQLContext sqlC = null;
	private Class<?> objClass;
	private Map<String, String> option = new HashMap<>();

	public Map<String, String> getOptions() {
		return option;
	}

	public void setOption(Map<String, String> option) {
		this.option = option;
	}

	public void setObjClass(Class<?> objClass) {
		this.objClass = objClass;
	}

	public Class<?> getObjClass() {
		return objClass;
	}

	public RawConfig(Class<?> class_) {
		setObjClass(class_);
		setOption(getOptionDataframe(getObjClass()));

		try {
			sc = SparkConfig.getSparkContext(new SquadFIAdapter().getSquadFI(getOptionDataframe(getObjClass())));
			sqlC = SparkConfig.getSQLContext(sc);
		} catch (Exception e) {
			e.getMessage();
			log.error("\n [ Necessario informar o nome do Job e a Descricao ] \n");
			throw new RuntimeException("\n [ Erro ao obter informacoes sobre o JOB a ser executado ] \n");
		}
	}

	public String getPartitionColumnName(){
		String columnName = "";
		if(objClass.isAnnotationPresent(Partitioned.class)) {
			columnName = objClass.getAnnotation(Partitioned.class).columnName();
		}
		return columnName;
	}

	public Map<String, String> getOptionDataframe(Class<?> class_) {
		Map<String, String> options = new LinkedHashMap<>();
		if (class_.isAnnotationPresent(Raw.class)) {
			options.put("separator", new Quotation().marks(class_.getAnnotation(Raw.class).separator()));
			options.put("header", new Quotation().marks(String.valueOf(class_.getAnnotation(Raw.class).header())));
			options.put("database", class_.getAnnotation(Raw.class).database());
			options.put("table", class_.getAnnotation(Raw.class).tableName());
			options.put("file", class_.getAnnotation(Raw.class).file());
			options.put("job", class_.getAnnotation(Raw.class).job());
			options.put("description", class_.getAnnotation(Raw.class).description());
		}

		log.info("\n[ Configuracoes de Raw ]\n"+ options +"\n");

		return options;
	}

	public void submit(Map<String, String> option) {
		new CMD().generateDefaultPathProject(option.get("database"), option.get("table"));

		new CMD().defaultTransferFile(option.get("database"), option.get("table"), option.get("file"));

		String source=String.format("%s%s%s%s/%s/%s/%s",
				ResourceConfig.HDFS.get(),
				new Property().getProperty("hdfs.location.main"),
				new Property().getProperty("hdfs.location.raw"),
				new Property().getProperty("hdfs.location.raw.stg"),
				String.valueOf(new Property().getProperty("hdfs.location.database")).replace(new Property().getProperty("hdfs.location.database"), option.get("database")),
				String.valueOf(new Property().getProperty("hdfs.location.table")).replace(new Property().getProperty("hdfs.location.table"), option.get("table")),
				option.get("file"));

		String target=String.format("%s%s%s/%s/%s/",
				ResourceConfig.HDFS.get(),
				new Property().getProperty("hdfs.location.main"),
				new Property().getProperty("hdfs.location.raw"),
				String.valueOf(new Property().getProperty("hdfs.location.database")).replace(new Property().getProperty("hdfs.location.database"), option.get("database")),
				String.valueOf(new Property().getProperty("hdfs.location.table")).replace(new Property().getProperty("hdfs.location.table"), option.get("table")));

		SchemaConfig schemaConfig = new SchemaConfig(objClass);

		Field[] dfColumns = schemaConfig.getDfColumns();

//		if(dfColumns[0].isAnnotationPresent(Positional.class)){
//			DataFrame df = new File().parsePositionalFile(sqlC.read().format(FormatFile.CSV.getFormat()).load(source), sqlC, dfColumns);
//			//DataFrame df = new File().parsePositionalFile(null, sqlC, dfColumns);
//		}
//		else {
			option.remove("database");
			option.remove("table");
			option.remove("file");
			option.remove("job");
			option.remove("description");

			log.info("\n\n[ SCHEMA >> ]\n" + schemaConfig.getSchema());

			log.info("\n\n[ OPTION >> ]\n" + option);

			//DataFrame df = sqlC.read().format(FormatFile.CSV.getFormat()).schema(schemaConfig.getSchema()).options(option).load(source);
//		}

		//df.write().format("parquet").save(target);
		//df.write().format("parquet").mode(SaveMode.Append).saveAsTable(db + "." + tb);
	}

}