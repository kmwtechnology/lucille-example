#!/bin/bash
# run this script from top level lucille-example-mvn directory via ./lucille.sh
java -Dconfig.file=example.conf -cp "target/classes/lib/*:target/*" com.kmwllc.lucille.core.Runner -local