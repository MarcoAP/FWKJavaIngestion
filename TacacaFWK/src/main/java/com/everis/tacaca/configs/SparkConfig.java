package com.everis.tacaca.configs;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SQLContext;

public class SparkConfig {

	private static final Logger log = Logger.getLogger(SparkConfig.class);

	public static SQLContext getSQLContext(SparkContext sc) {
		return new SQLContext(sc);
	}

	public static SparkContext getSparkContext(Map<String, String> defaultSquadConfiguration) {

		SparkConf sparkConf = new SparkConf();

		for (String key : defaultSquadConfiguration.keySet()) {
			if (defaultSquadConfiguration.containsKey("master"))
				sparkConf.setMaster(defaultSquadConfiguration.get("master"));
			else if (defaultSquadConfiguration.containsKey("appName"))
				sparkConf.setAppName(defaultSquadConfiguration.get("appName"));
			else
				sparkConf.set(key, defaultSquadConfiguration.get(key));
		}

		defaultSquadConfiguration.remove("master");
		defaultSquadConfiguration.remove("appName");

		return new SparkContext(sparkConf).getOrCreate();

	}
}
