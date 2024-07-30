#!/bin/bash
# run this script from top level lucille-example-mvn directory via ./lucille.sh
java -Dlog4j.configurationFile=log4j2.xml -Dconfig.file=conf/example.conf -cp "target/lib/*:target/*" com.kmwllc.lucille.core.Runner