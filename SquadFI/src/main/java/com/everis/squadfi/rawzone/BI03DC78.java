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
public class BI03DC78 {

	public BI03DC78() {
		log.info("\n [ Iniciando JOB - BI03DC78 ]\n");
		Class<BI03DC78> bi03dc78 = BI03DC78.class;
		RawConfig r = new RawConfig(bi03dc78);
		r.submit(r.getOption(bi03dc78));
	}

	private static final Logger log = Logger.getLogger(BI03DC78.class);

	@Positional(startPosition = 0, endPosition = 10)
	@Column(columnName = "data_validade", order = 1, nullable = true)
	private String data_validade;

	@Positional(startPosition = 10, endPosition = 28)
	@Column(columnName = "data_envio_email", order = 2, nullable = true)
	private int data_envio_email;

	@Positional(startPosition = 28, endPosition = 36)
	@Column(columnName = "cod_user", order = 3, nullable = true)
	private int cod_user;

	@Positional(startPosition = 36, endPosition = 86)
	@Column(columnName = "nome_usuario", order = 4, nullable = true)
	private int nome_usuario;

	@Positional(startPosition = 86, endPosition = 166)
	@Column(columnName = "desc_motivo", order = 5, nullable = true)
	private int desc_motivo;

	@Positional(startPosition = 166, endPosition = 171)
	@Column(columnName = "cod_ucbd", order = 6, nullable = true)
	private int cod_ucbd;

	@Positional(startPosition = 171, endPosition = 251)
	@Column(columnName = "nome_cplt_ucbd", order = 7, nullable = true)
	private int nome_cplt_ucbd;

	@Positional(startPosition = 251, endPosition = 264)
	@Column(columnName = "val_preco_definido_usuario", order = 8, nullable = true)
	private int val_preco_definido_usuario;

	@Positional(startPosition = 264, endPosition = 267)
	@Column(columnName = "num_dpto", order = 9, nullable = true)
	private int num_dpto;

	@Positional(startPosition = 267, endPosition = 302)
	@Column(columnName = "nome_dpto", order = 10, nullable = true)
	private int nome_dpto;

	@Positional(startPosition = 302, endPosition = 307)
	@Column(columnName = "num_unng", order = 11, nullable = true)
	private int num_unng;

	@Positional(startPosition = 307, endPosition = 337)
	@Column(columnName = "nome_unng", order = 12, nullable = true)
	private int nome_unng;

	@Positional(startPosition = 337, endPosition = 342)
	@Column(columnName = "num_sung", order = 13, nullable = true)
	private int num_sung;

	@Positional(startPosition = 342, endPosition = 372)
	@Column(columnName = "nome_sung", order = 14, nullable = true)
	private int nome_sung;

	@Positional(startPosition = 372, endPosition = 375)
	@Column(columnName = "num_seca", order = 15, nullable = true)
	private int num_seca;

	@Positional(startPosition = 375, endPosition = 405)
	@Column(columnName = "nome_seca", order = 16, nullable = true)
	private int nome_seca;

	@Positional(startPosition = 405, endPosition = 412)
	@Column(columnName = "idt_plu", order = 17, nullable = true)
	private int idt_plu;

	@Positional(startPosition = 412, endPosition = 492)
	@Column(columnName = "desc_cmpl_prod", order = 18, nullable = true)
	private int desc_cmpl_prod;

	@Positional(startPosition = 492, endPosition = 508)
	@Column(columnName = "desc_senha", order = 19, nullable = true)
	private int desc_senha;

//	public static void main(String[] args) {
//		for (Field f : BI03DC78.class.getDeclaredFields()) {
//			if (f.isAnnotationPresent(Column.class)) {
//				Column c = f.getAnnotation(Column.class);
//				System.out.println(c.columnName());
//			}
//		}
//	}

}