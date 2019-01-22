package com.everis.fwkcore.configurations;

import static spark.Spark.get;

import org.apache.log4j.Logger;

public class HBase {

	private static final Logger log = Logger.getLogger(HBase.class);

	public static void main(String[] args) {
		log.warn("Acessando...");
		get("/hello", (req, res) -> "Hello World");
		log.error("Acessando...");
	}

}
