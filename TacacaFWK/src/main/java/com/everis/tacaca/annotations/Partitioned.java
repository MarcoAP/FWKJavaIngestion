package com.everis.tacaca.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Partitioned {

	String columnName() default "dt_processamento";

	boolean daily() default false;

	boolean weekly() default false;

	boolean biweekly() default false;

	boolean monthly() default false;

	boolean bimonthly() default false;

	boolean quarterly() default false;

	boolean semiannual() default false;

	boolean yearly() default false;

}
