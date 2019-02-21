package com.everis.tacaca.enums;

import org.apache.log4j.Logger;

public enum IngestionType {
	
	FILE("FILE"),
	SQL("QUERY");
	
	private final String type;
	private static final Logger log = Logger.getLogger(IngestionType.class);
	
	IngestionType(String type) {
		this.type = type;
	}
 
	public String get() {
		try {
			return this.type;
		} catch (EnumConstantNotPresentException e) {
			log.error("\n[ Tipo de ingestao escolhido invalido! Por favor escolha FILE para arquivo ou SQL para query ] \n");
			throw new EnumConstantNotPresentException(getDeclaringClass(), null);
		}
	}
}
