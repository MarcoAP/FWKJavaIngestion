package com.everis.fwkcore.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class FieldsDataframeModel {
	
	private Map<String, String> column = new LinkedHashMap<>();

	public Map<String, String> getColumn() {
		return column;
	}

	public void setColumn(Map<String, String> column) {
		this.column = column;
	}
}
