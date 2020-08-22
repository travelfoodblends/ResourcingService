#!/usr/bin/env bash

echo 'Starting my app'
nohup java -jar /home/ec2-user/server/target/ResourcingService-0.0.1-SNAPSHOT.jar &
echo 'app started'
exit 0
