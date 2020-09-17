#!/usr/bin/env bash

echo 'Starting my app'
nohup java -jar /home/ec2-user/server/target/ResourcingService-0.0.1-SNAPSHOT.jar > /dev/my-service-logs/serviceLog.txt 2>&1 &
echo $! > /dev/my-service-logs/pid.file
echo 'app started'
exit 0
