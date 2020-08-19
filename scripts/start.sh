#!/usr/bin/env bash

echo 'Starting my app'
nohup java -jar ResourcingService-0.0.1-SNAPSHOT.jar > resourcing-service.log
exit 0
