package com.everis.tacaca.adapters.squads;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.launcher.SparkLauncher;

import com.everis.tacaca.properties.Property;
import com.everis.utils.Quotation;

public class SquadPricingAdapter {
	Property property = new Property();
	Map<String, String> mapSquadFIResources = new HashMap<>();
	
	public Map<String, String> getSquadFI(String job, String description) {
		mapSquadFIResources.put("master", "yarn");
		mapSquadFIResources.put("appName", String.format(new Quotation().marks(property.getProperty("squad.pricing.spark.default.name")), job, description));
		mapSquadFIResources.put(SparkLauncher.DRIVER_MEMORY, property.getProperty("squad.pricing.spark.default.driver-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_MEMORY, property.getProperty("squad.pricing.spark.default.executor-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_CORES, property.getProperty("squad.pricing.spark.default.executor-cores"));
		mapSquadFIResources.put("proxy-user", property.getProperty("squad.pricing.spark.default.proxy-user"));
		mapSquadFIResources.put("spark.driver.maxResultSize", property.getProperty("squad.pricing.spark.default.conf.spark.driver.maxResultSize"));
		mapSquadFIResources.put("spark.dynamicAllocation.enabled", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.enabled"));
		mapSquadFIResources.put("spark.shuffle.service.port", property.getProperty("squad.pricing.spark.default.conf.spark.shuffle.service.port"));
		mapSquadFIResources.put("spark.dynamicAllocation.initialExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.initialExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.minExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.minExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.maxExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.maxExecutors"));
		mapSquadFIResources.put("spark.yarn.driver.memoryOverhead", property.getProperty("squad.pricing.spark.default.conf.spark.yarn.driver.memoryOverhead"));
		mapSquadFIResources.put("spark.yarn.executor.memoryOverhead", property.getProperty("squad.pricing.spark.default.conf.spark.yarn.executor.memoryOverhead"));
		mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.pricing.spark.default.Djavax.security.auth.useSubjectCredsOnly"));

		return mapSquadFIResources;
	}
	
	public Map<String, String> getSquadFI(String job, String description, String key, String value) {
		mapSquadFIResources.put("master", "yarn");
		mapSquadFIResources.put("appName", String.format(new Quotation().marks(property.getProperty("squad.pricing.spark.default.name")), job, description));
		mapSquadFIResources.put(SparkLauncher.DRIVER_MEMORY, property.getProperty("squad.pricing.spark.default.driver-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_MEMORY, property.getProperty("squad.pricing.spark.default.executor-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_CORES, property.getProperty("squad.pricing.spark.default.executor-cores"));
		mapSquadFIResources.put("proxy-user", property.getProperty("squad.pricing.spark.default.proxy-user"));
		mapSquadFIResources.put("spark.driver.maxResultSize", property.getProperty("squad.pricing.spark.default.conf.spark.driver.maxResultSize"));
		mapSquadFIResources.put("spark.dynamicAllocation.enabled", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.enabled"));
		mapSquadFIResources.put("spark.shuffle.service.port", property.getProperty("squad.pricing.spark.default.conf.spark.shuffle.service.port"));
		mapSquadFIResources.put("spark.dynamicAllocation.initialExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.initialExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.minExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.minExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.maxExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.maxExecutors"));
		mapSquadFIResources.put("spark.yarn.driver.memoryOverhead", property.getProperty("squad.pricing.spark.default.conf.spark.yarn.driver.memoryOverhead"));
		mapSquadFIResources.put("spark.yarn.executor.memoryOverhead", property.getProperty("squad.pricing.spark.default.conf.spark.yarn.executor.memoryOverhead"));
		mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.pricing.spark.default.Djavax.security.auth.useSubjectCredsOnly"));
		mapSquadFIResources.put(key, value);
		
		return mapSquadFIResources;
	}
	
	public Map<String, String> getSquadFI(String job, String description, Map<String, String> newKeyValue) {
		mapSquadFIResources.put("master", "yarn");
		mapSquadFIResources.put("appName", String.format(new Quotation().marks(property.getProperty("squad.pricing.spark.default.name")), job, description));
		mapSquadFIResources.put(SparkLauncher.DRIVER_MEMORY, property.getProperty("squad.pricing.spark.default.driver-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_MEMORY, property.getProperty("squad.pricing.spark.default.executor-memory"));
		mapSquadFIResources.put(SparkLauncher.EXECUTOR_CORES, property.getProperty("squad.pricing.spark.default.executor-cores"));
		mapSquadFIResources.put("proxy-user", property.getProperty("squad.pricing.spark.default.proxy-user"));
		mapSquadFIResources.put("spark.driver.maxResultSize", property.getProperty("squad.pricing.spark.default.conf.spark.driver.maxResultSize"));
		mapSquadFIResources.put("spark.dynamicAllocation.enabled", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.enabled"));
		mapSquadFIResources.put("spark.shuffle.service.port", property.getProperty("squad.pricing.spark.default.conf.spark.shuffle.service.port"));
		mapSquadFIResources.put("spark.dynamicAllocation.initialExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.initialExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.minExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.minExecutors"));
		mapSquadFIResources.put("spark.dynamicAllocation.maxExecutors", property.getProperty("squad.pricing.spark.default.conf.spark.dynamicAllocation.maxExecutors"));
		mapSquadFIResources.put("spark.yarn.driver.memoryOverhead", property.getProperty("squad.pricing.spark.default.conf.spark.yarn.driver.memoryOverhead"));
		mapSquadFIResources.put("spark.yarn.executor.memoryOverhead", property.getProperty("squad.pricing.spark.default.conf.spark.yarn.executor.memoryOverhead"));
		mapSquadFIResources.put(SparkLauncher.DRIVER_EXTRA_JAVA_OPTIONS, property.getProperty("squad.pricing.spark.default.Djavax.security.auth.useSubjectCredsOnly"));
		
		for(String key : newKeyValue.keySet()) {
			mapSquadFIResources.put(key, newKeyValue.get(key));	
		}
				
		return mapSquadFIResources;
	}

}
