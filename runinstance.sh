#!/bin/bash

TARGET="${1?Specify 'service' or 'proxy'}"
PORT="${2?Specify a base port number}"
run=${3:-run} # specify "debug" to run in debug mode

cd "$(dirname $0)" && cd "$TARGET" &&
mvn -o tomee:$run \
    -Dtomee-plugin.http=$PORT \
    -Dtomee-plugin.ajp=$(($PORT+1)) \
    -Dtomee-plugin.shutdown=$(($PORT+2)) \
    -Dtomee-plugin.catalina-base='${project.build.directory}/server-'$PORT
