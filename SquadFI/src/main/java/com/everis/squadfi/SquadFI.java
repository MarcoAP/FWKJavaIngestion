package com.everis.squadfi;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.everis.squadfi.rawzone.BI03DC71;
import com.everis.squadfi.rawzone.BI03DC72;
import com.everis.squadfi.rawzone.BI03DC73;
import com.everis.squadfi.rawzone.BI03DC74;
import com.everis.squadfi.rawzone.BI03DC75;
import com.everis.squadfi.rawzone.BI03DC76;
import com.everis.squadfi.rawzone.BI03DC77;
import com.everis.squadfi.rawzone.BI03DC78;
import com.everis.squadfi.rawzone.BI03DC79;
import com.everis.squadfi.rawzone.BI03DC80;

public class SquadFI {

	private static final Logger log = Logger.getLogger(SquadFI.class);

	public static void main(String[] args) {

		if (args.length != 1) {
			log.error("\n[ Necessario especificar o JOB ID ]\n");
			throw new RuntimeException("\n\n[ >> Nenhum job especificado ]\n");
		}

		Map<String, Object> jobList = new HashMap();

		jobList.put("BI03DC71", new BI03DC71());
		jobList.put("BI03DC72", new BI03DC72());
		jobList.put("BI03DC73", new BI03DC73());
		jobList.put("BI03DC74", new BI03DC74());
		jobList.put("BI03DC75", new BI03DC75());
		jobList.put("BI03DC76", new BI03DC76());
		jobList.put("BI03DC77", new BI03DC77());
		jobList.put("BI03DC78", new BI03DC78());
		jobList.put("BI03DC79", new BI03DC79());
		jobList.put("BI03DC80", new BI03DC80());

		if (jobList.containsKey(args[0])) {
			jobList.get(args[0]).getClass();
		} else {
			log.error("\n[ JOB nao encontrado na aplicacao ]\n");
			throw new RuntimeException();
		}
	}
}
