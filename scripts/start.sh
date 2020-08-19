#!/usr/bin/env bash

echo 'Starting my app'
nohup java -jar ResourcingService-0.0.1-SNAPSHOT.jar > resourcing-service.log
echo 'app started'
exit 0
