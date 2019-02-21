package com.everis.tacaca.adapters;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.hadoop.mapreduce.lib.input.InvalidInputException;
import org.apache.log4j.Logger;

import com.everis.tacaca.properties.Property;

public class CMD {

	private static final Logger log = Logger.getLogger(CMD.class);

	public String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(
					"\n[ Nao foi possivel executar o comando, verifique ]\n1) Permissionamento\n2)Usuario que esta utilizando para executar o comando \n");
		}

		return output.toString();
	}

	public void generateDefaultPathProject(String database, String table) {

		String edgenode = "";
		String hdfs = "";

		try {

			edgenode = String.format("%s%s", new Property().getProperty("squad.financeira.path"),
					String.valueOf(new Property().getProperty("squad.financeira.landingzone"))
							.replace("$database", database).replace("$table", table));

			log.info("[ EDGE NODE ] >> " + edgenode);

			new CMD().executeCommand(String.format("mkdir -p %s", edgenode));
			// new CMD().executeCommand(String.format("cd %s", edgenode));

			hdfs = String.format("%s%s/%s/%s", new Property().getProperty("hdfs.location.main"),
					new Property().getProperty("hdfs.location.raw"), database, table);

			log.info("[ HDFS TABLE ] >> " + hdfs);

			new CMD().executeCommand(String.format("hdfs dfs -mkdir -p %s", hdfs));

			hdfs = String.format("%s%s%s/%s/%s", new Property().getProperty("hdfs.location.main"),
					new Property().getProperty("hdfs.location.raw"),
					new Property().getProperty("hdfs.location.raw.stg"), database, table);

			log.info("[ HDFS STAGE ]>> " + hdfs);

			new CMD().executeCommand(String.format("hdfs dfs -mkdir -p %s", hdfs));

		} catch (Exception e) {
			e.printStackTrace();
			log.error(
					"\n[ Nao foi possivel executar o comando, verifique ]\n1) Permissionamento\n2)Usuario que esta utilizando para executar o comando \n");
		}
	}

	public void defaultTransferFile(String database, String table, String file) {

		String edgenode = "";
		String hdfs = "";

		try {

			edgenode = String.format("%s%s", new Property().getProperty("squad.financeira.path"),
					new Property().getProperty("squad.financeira.landingzone"));
			edgenode = edgenode.replace("$database", database);
			edgenode = edgenode.replace("$table", table);

			// new CMD().executeCommand(String.format("cd %s", edgenode));

			hdfs = String.format("%s%s%s/%s/%s", new Property().getProperty("hdfs.location.main"),
					new Property().getProperty("hdfs.location.raw"),
					new Property().getProperty("hdfs.location.raw.stg"), database, table);

			new CMD().executeCommand(String.format("hdfs dfs -put %s %s", edgenode.concat("/").concat(file), hdfs));

		} catch (Exception e) {
			e.printStackTrace();
			log.error(String.format(
					"\n[ Nao foi possivel executar o comando, verifique um dos seguintes abaixo ]\n1) Permissionamento utilizado;\n2)Usuario que esta utilizando para executar o comando\n3) Se o arquivo existe no diretorio origem: %s\n",
					edgenode));
		}

	}

}
