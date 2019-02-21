package com.everis.tacaca.enums;

import org.apache.log4j.Logger;

public enum ResourceConfig {

	HDFS("hdfs://"),
	LOCAL("file://");
	
	private String sourceConfig;
	private static final Logger log = Logger.getLogger(ResourceConfig.class);
	
	ResourceConfig(String sourceConfig) {
		setResourceConfig(sourceConfig);
	}
 
	protected void setResourceConfig(String sourceConfig) {
		this.sourceConfig = sourceConfig;
	}
	
	public String get() {
		try {
			return this.sourceConfig;
		} catch (EnumConstantNotPresentException e) {
			log.error("\n[ Estrutura de dados escolhido invalido! Por favor escolha HDFS ou FILE ] \n");
			throw new EnumConstantNotPresentException(getDeclaringClass(), null);
		}
	}
	
}
