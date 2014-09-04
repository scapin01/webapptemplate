#!/bin/sh
cd $(dirname $0)
cd ..
mvn clean install war:war
#scp target/dtv.war root@10.20.100.93:/opt/tomcat/webapps/dtv.war
scp target/dtv.war root@10.20.100.93:/tmp/dtv.war
ssh root@10.20.100.93 cp /tmp/dtv.war /opt/tomcat/webapps/dtv.war
