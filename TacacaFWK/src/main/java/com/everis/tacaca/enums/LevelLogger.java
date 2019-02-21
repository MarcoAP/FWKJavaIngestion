package com.everis.tacaca.enums;

import org.apache.log4j.Logger;

public enum LevelLogger {

	OFF(0), FATAL(100), ERROR(200), WARN(300), INFO(400), DEBUG(500), TRACE(600), ALL(Integer.MAX_VALUE);

	private int level; 
	private static final Logger log = Logger.getLogger(LevelLogger.class);

	LevelLogger(final int level) {
		setLevel(level);
	}
 
	public int getLevel() {
		try {
			return this.level;
		} catch (EnumConstantNotPresentException e) {
			log.error("\n[ O level informado para LevelLogger esta incorreto ] \n");
			throw new EnumConstantNotPresentException(getDeclaringClass(), null);
		}
	}

	private void setLevel(int level) {
		this.level = level;
	}
}
