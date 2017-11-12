#!/bin/bash

function local_get {
    size=${1:-3567mb}
    curl -v "http://localhost:7000/tomee-grinder-starter-1.0-SNAPSHOT/color/send/$size" > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function local_echo {
    size=${1:-1234567890}
    perl -e "print 'A'x$size" | curl -v --data-binary "@-" http://localhost:7000/tomee-grinder-starter-1.0-SNAPSHOT/color/echo > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_get {
    size=${1:-3567mb}
    curl -v "http://localhost:8080/tomee-grinder-starter-1.0-SNAPSHOT/proxy/tomee-grinder-starter-1.0-SNAPSHOT/color/send/$size" > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_echo {
    size=${1:-1234567890}
    perl -e "print 'A'x$size" | curl -v --data-binary "@-"  http://localhost:8080/tomee-grinder-starter-1.0-SNAPSHOT/proxy/tomee-grinder-starter-1.0-SNAPSHOT/color/echo > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_slow {
    size=${1?Specify a size}
    time=${2?Specify a time}
    curl -v "http://localhost:8080/tomee-grinder-starter-1.0-SNAPSHOT/proxy/tomee-grinder-starter-1.0-SNAPSHOT/color/slow/$size/$time" > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_sleep {
    time=${1?Specify a time}
    curl -v "http://localhost:8080/tomee-grinder-starter-1.0-SNAPSHOT/proxy/tomee-grinder-starter-1.0-SNAPSHOT/color/sleep/$time"
}

function proxy_slowdown {
    time=${1?Specify a time}
    curl -v "http://localhost:8080/tomee-grinder-starter-1.0-SNAPSHOT/proxy/tomee-grinder-starter-1.0-SNAPSHOT/color/slowdown/$time"
}

"$@"
