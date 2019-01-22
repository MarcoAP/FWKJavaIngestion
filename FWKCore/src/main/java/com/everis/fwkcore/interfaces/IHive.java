package com.everis.fwkcore.interfaces;

import com.everis.fwkcore.models.HiveModel;

import spark.*;

public interface IHive {

	public boolean ingestionParquet(HiveModel hive);
	public boolean ingestionTextFile(HiveModel hive);
	public boolean ingestionKuduToHive(HiveModel hive);
	public Spark createDataframeFromHive(HiveModel hive);
	
	
}
