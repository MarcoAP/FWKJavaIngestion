package com.everis.tacaca.enums;

import org.apache.log4j.Logger;

public enum FormatFile {

	CSV("com.databricks.spark.csv");
	
	private String format; 
	private static final Logger log = Logger.getLogger(FormatFile.class);
	
	FormatFile(final String format) {
		setFormat(format);
	}
 	
	public String getFormat() {
		try {
			return this.format;
		} catch (EnumConstantNotPresentException e) {
			log.error("\n[ O formato informado para FormatFile esta incorreto ] \n");
			throw new EnumConstantNotPresentException(getDeclaringClass(), null);
		}
	}
	
	private void setFormat(String format) {
		this.format = format;
	}
	
}
