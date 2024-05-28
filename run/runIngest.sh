#!/bin/bash
# run this script from top level lucille-example-mvn directory via ./run/runIngest.sh
java -Dconfig.file=run/example-os.conf -cp "target/classes/lib/*:target/*" com.kmwllc.lucille.core.Runner -local