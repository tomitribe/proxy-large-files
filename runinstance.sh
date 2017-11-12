#!/bin/bash

PORT="${1?Specify a base port number}"

cd "$(dirname $0)" &&
mvn -o tomee:run \
    -Dtomee-plugin.http=$PORT \
    -Dtomee-plugin.ajp=$(($PORT+1)) \
    -Dtomee-plugin.shutdown=$(($PORT+2)) \
    -Dtomee-plugin.catalina-base='${project.build.directory}/server-'$PORT
