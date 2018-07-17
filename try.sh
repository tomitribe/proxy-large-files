#!/bin/bash

function local_get {
    size=${1:-3567mb}
    curl -v "http://localhost:7000/color/send/$size" > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function local_hash {
    file="${1?Specify a file name}"
    curl -v "http://localhost:7000/color/hash" --data-binary "@$file"
}

function proxy_hash {
    file="${1?Specify a file name}"
    curl -v "http://localhost:8080/proxy/color/hash" --data-binary "@$file"
}

function local_echo {
    size=${1:-1234567890}
    perl -e "print 'A'x$size" | curl -v --data-binary "@-" http://localhost:7000/color/echo > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_get {
    size=${1:-3567mb}
    curl -v "http://localhost:8080/proxy/color/send/$size?foo=bar" > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_echo {
    size=${1:-1234567890}
    perl -e "print 'A'x$size" | curl -v --data-binary "@-"  http://localhost:8080/proxy/color/echo > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_slow {
    size=${1?Specify a size}
    time=${2?Specify a time}
    curl -v "http://localhost:8080/proxy/color/slow/$size/$time" > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function proxy_sleep {
    time=${1?Specify a time}
    curl -v "http://localhost:8080/proxy/color/sleep/$time"
}

function proxy_slowdown {
    time=${1?Specify a time}
    curl -v "http://localhost:8080/proxy/color/slowdown/$time"
}

function tag_get {
    size=${1:-3567mb}
    curl -v "http://localhost:8080/color/send/$size" > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

function tag_echo {
    size=${1:-1234567890}
    perl -e "print 'A'x$size" | curl -v --data-binary "@-" http://localhost:8080/color/echo > /tmp/foo.txt && ls -lh /tmp/foo.txt
}

"$@"
