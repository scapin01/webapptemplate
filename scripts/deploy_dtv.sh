#!/bin/sh
cd $(dirname $0)
cd ..
mvn clean install war:war

scp /target/webapptemplate
