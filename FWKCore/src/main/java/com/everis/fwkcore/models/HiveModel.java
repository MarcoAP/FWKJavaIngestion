package com.everis.fwkcore.models;

import java.util.List;

import org.apache.spark.sql.hive.HiveContext;

public class HiveModel {
	
	private FieldsDataframeModel dataframe;
	private List<FieldsDataframeModel> fields;
	private String mode;
	private String databaseFrom;
	private String databaseTo;
	private String tableFrom;
	private String tableTo;
	private StringBuilder query;
	private boolean partition;
	private String partitionName;
	private HiveContext hiveContext;
	private String partitionPath;
	private String partitionValue;
	
	

}
