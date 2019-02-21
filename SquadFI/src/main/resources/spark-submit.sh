#!/bin/bash
export pwd=`pwd`
spark-submit \
--class com.everis.squadfi.SquadFI \
--jars TacacaFWK-1.0.0-jar-with-dependencies.jar, \
SquadFI-0.0.1-jar-with-dependencies.jar "BI03DC78"