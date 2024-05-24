#!/bin/bash
# run this script from top level lucille-csv-example directory via ./scripts/run_ingest.sh
java -Dconfig.file=run/example.conf -cp "target/classes/lib/*:target/*" com.kmwllc.lucille.core.Runner -local