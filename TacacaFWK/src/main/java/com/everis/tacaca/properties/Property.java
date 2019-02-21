package com.everis.tacaca.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Property {

	private static final Logger log = Logger.getLogger(Property.class);

	public String getProperty(String key) {
		try {
			Properties property = new Properties();
			InputStream streamFile = (InputStream) getClass().getClassLoader()
					.getResourceAsStream("tacaca.properties");
			property.load(streamFile);
			return property.getProperty(key);
		} catch (IOException io) {
			log.error("\n\n[ Arquivo de PROPERTIES [fwkcore.properties]  nao encontrado ]\n\n");
			System.out.println(io.getMessage());
		} catch (Exception e) {
			log.error("\n\n[ Ocorreu um erro desconhecido, provavelmente o arquivo de PROPERTIES nao foi localizado ]\n\n");
			System.out.println(e.getMessage());
		}
		return null;
	}

}
