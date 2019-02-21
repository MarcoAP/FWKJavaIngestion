package com.everis.squadfi.rawzone;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.everis.tacaca.annotations.Column;
import com.everis.tacaca.annotations.Partitioned;
import com.everis.tacaca.annotations.Positional;
import com.everis.tacaca.annotations.Raw;
import com.everis.tacaca.configs.RawConfig;

@Partitioned(daily = true, columnName = "datamovto")
@Raw(database = "rwzd_ac34", tableName = "ext_td_ac34_ac34rd55_senhas01", header = false, job = "BI03DC78", description = "Teste Teste", file = "rwzd_ac34.ext_td_ac34_ac34rd55_senhas01.YYYYMMDD.csv")
public class BI03DC72 {

	public BI03DC72() {
		log.info("\n [ Iniciando JOB - BI03DC78 ]\n");
		Class<BI03DC72> bi03dc78 = BI03DC72.class;
		RawConfig r = new RawConfig(bi03dc78);
		r.submit(r.getOption(bi03dc78));
	}

	private static final Logger log = Logger.getLogger(BI03DC72.class);

	@Positional(startPosition = 0, endPosition = 10)
	@Column(columnName = "plu", order = 2, nullable = true)
	private String campo1;

	@Positional(startPosition = 11, endPosition = 13)
	@Column(columnName = "cod_loja", order = 1, nullable = false)
	private int campo2;

	@Positional(startPosition = 13, endPosition = 89)
	@Column(columnName = "cod_estrutura", order = 3, nullable = true)
	private int campo3;

	public static void main(String[] args) {
		for (Field f : BI03DC72.class.getDeclaredFields()) {
			if (f.isAnnotationPresent(Column.class)) {
				Column c = f.getAnnotation(Column.class);
				System.out.println(c.columnName());
			}
		}
	}

	@Column(columnName = "datamovto", order = 3, nullable = true)
	private int campo4;

}