package com.everis.tacaca.adapters.squads;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.spark.launcher.SparkLauncher;

import com.everis.tacaca.properties.Property;
import com.everis.utils.Quotation;

public class SquadFIAdapter {
	
	private static final Logger log = Logger.getLogger(SquadFIAdapter.class);
	Property property = new Property();
	Map<String, String> mapSquadFIResources = new HashMap<>();
	
	public Map<String, String> getSquadFI(Map<String, String> mapSquadFIResources) {
		this.mapSquadFIResources.put("master", property.getProperty("squad.financeira.spark.default.master"));
		this.mapSquadFIResources.put("appName", String.format(new Quotation().marks(property.getProperty("squad.financeira.spark.default.name")), mapSquadFIResources.get("job"), mapSquadFIResources.get("description")));
		this.mapSquadFIResources.put(SparkLauncher.DRIVER_MEMORY, property.getProperty("squad.financeira.spark.default.driver-memory"));
		this.mapSquadFIResources.put(SparkLauncher.EXECUTOR_MEMORY, property.getProperty("squad.financeira.spark.default.executor-memory"));
		this.mapSquadFIResources.put(SparkLauncher.EXECUTOR_CORES, property.getProperty("squad.financeira.spark.default.executor-cores"));
		//this.mapSquadFIResources.put("proxy-user", property.getProperty("squad.financeira.spark.default.proxy-user"));
		this.mapSquadFIResources.put("spark.driver.maxResultSize", property.getProperty("squad.financeira.spark.default.conf.spark.driver.maxResultSize"));
		this.mapSquadFIResources.put("spark.dynamicAllocation.enabled", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.enabled"));
		this.mapSquadFIResources.put("spark.shuffle.service.port", property.getProperty("squad.financeira.spark.default.conf.spark.shuffle.service.port"));
		this.mapSquadFIResources.put("spark.dynamicAllocation.initialExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.initialExecutors"));
		this.mapSquadFIResources.put("spark.dynamicAllocation.minExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.minExecutors"));
		this.mapSquadFIResources.put("spark.dynamicAllocation.maxExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.maxExecutors"));
		this.mapSquadFIResources.put("spark.yarn.driver.memoryOverhead", property.getProperty("squad.financeira.spark.default.conf.spark.yarn.driver.memoryOverhead"));
		this.mapSquadFIResources.put("spark.yarn.executor.memoryOverhead", property.getProperty("squad.financeira.spark.default.conf.spark.yarn.executor.memoryOverhead"));
		//this.mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.financeira.spark.default.Djavax.security.auth.useSubjectCredsOnly"));
		this.mapSquadFIResources.put("spark.sql.parquet.compression.codec", property.getProperty("squad.financeira.spark.sql.parquet.compression.codec"));
		this.mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.financeira.spark.log4j.configuration"));
		
		log.info("\n\n[ 1. Configuracoes para execucao do JOB ]\n\n" + mapSquadFIResources + "\n");
		
		return this.mapSquadFIResources;
	}
	
	public Map<String, String> getSquadFI(String job, String description, String key, String value) {
		mapSquadFIResources.put("master", property.getProperty("squad.financeira.spark.default.master"));
		mapSquadFIResources.put("appName", String.format(new Quotation().marks(property.getProperty("squad.financeira.spark.default.name")), job, description));
		mapSquadFIResources.put(SparkLauncher.DRIVER_MEMORY, property.getProperty("squad.financeira.spark.default.driver-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_MEMORY, property.getProperty("squad.financeira.spark.default.executor-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_CORES, property.getProperty("squad.financeira.spark.default.executor-cores"));
		mapSquadFIResources.put("proxy-user", property.getProperty("squad.financeira.spark.default.proxy-user"));
		mapSquadFIResources.put("spark.driver.maxResultSize", property.getProperty("squad.financeira.spark.default.conf.spark.driver.maxResultSize"));
		mapSquadFIResources.put("spark.dynamicAllocation.enabled", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.enabled"));
		mapSquadFIResources.put("spark.shuffle.service.port", property.getProperty("squad.financeira.spark.default.conf.spark.shuffle.service.port"));
		mapSquadFIResources.put("spark.dynamicAllocation.initialExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.initialExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.minExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.minExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.maxExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.maxExecutors"));
		mapSquadFIResources.put("spark.yarn.driver.memoryOverhead", property.getProperty("squad.financeira.spark.default.conf.spark.yarn.driver.memoryOverhead"));
		mapSquadFIResources.put("spark.yarn.executor.memoryOverhead", property.getProperty("squad.financeira.spark.default.conf.spark.yarn.executor.memoryOverhead"));
		mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.financeira.spark.default.Djavax.security.auth.useSubjectCredsOnly"));
		mapSquadFIResources.put("spark.sql.parquet.compression.codec", property.getProperty("squad.financeira.spark.sql.parquet.compression.codec"));
		this.mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.financeira.spark.log4j.configuration"));
		mapSquadFIResources.put(key, value);
		
		log.info("\n\n[ 2. Configuracoes para execucao do JOB ]\n\n" + mapSquadFIResources + "\n");
		
		return mapSquadFIResources;
	}
	
	public Map<String, String> getSquadFI(String job, String description, Map<String, String> newKeyValue) {
		mapSquadFIResources.put("master", property.getProperty("squad.financeira.spark.default.master"));
		mapSquadFIResources.put("appName", String.format(new Quotation().marks(property.getProperty("squad.financeira.spark.default.name")), job, description));
		mapSquadFIResources.put(SparkLauncher.DRIVER_MEMORY, property.getProperty("squad.financeira.spark.default.driver-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_MEMORY, property.getProperty("squad.financeira.spark.default.executor-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_CORES, property.getProperty("squad.financeira.spark.default.executor-cores"));
		mapSquadFIResources.put("proxy-user", property.getProperty("squad.financeira.spark.default.proxy-user"));
		mapSquadFIResources.put("spark.driver.maxResultSize", property.getProperty("squad.financeira.spark.default.conf.spark.driver.maxResultSize"));
		mapSquadFIResources.put("spark.dynamicAllocation.enabled", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.enabled"));
		mapSquadFIResources.put("spark.shuffle.service.port", property.getProperty("squad.financeira.spark.default.conf.spark.shuffle.service.port"));
		mapSquadFIResources.put("spark.dynamicAllocation.initialExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.initialExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.minExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.minExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.maxExecutors", property.getProperty("squad.financeira.spark.default.conf.spark.dynamicAllocation.maxExecutors"));
		mapSquadFIResources.put("spark.yarn.driver.memoryOverhead", property.getProperty("squad.financeira.spark.default.conf.spark.yarn.driver.memoryOverhead"));
		mapSquadFIResources.put("spark.yarn.executor.memoryOverhead", property.getProperty("squad.financeira.spark.default.conf.spark.yarn.executor.memoryOverhead"));
		mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.financeira.spark.default.Djavax.security.auth.useSubjectCredsOnly"));
		mapSquadFIResources.put("spark.sql.parquet.compression.codec", property.getProperty("squad.financeira.spark.sql.parquet.compression.codec"));
		this.mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.financeira.spark.log4j.configuration"));
		
		for(String key : newKeyValue.keySet()) {
			mapSquadFIResources.put(key, newKeyValue.get(key));	
		}
				
		log.info("\n\n[ 3. Configuracoes para execucao do JOB ]\n\n" + mapSquadFIResources + "\n");
		
		return mapSquadFIResources;
	}

}
