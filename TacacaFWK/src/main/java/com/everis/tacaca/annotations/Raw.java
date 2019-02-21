package com.everis.tacaca.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.everis.tacaca.enums.IngestionType;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Raw {

	String database() default "";

	String tableName() default "";
	
	String file() default "";

	String separator() default ";";

	IngestionType type() default IngestionType.FILE;

	boolean header() default false;
	
	String job() default "";
	
	String description() default "";

}
