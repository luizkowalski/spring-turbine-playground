#!/usr/bin/env bash

set -e

cd hystrixdashboard; mvn clean package -DskipTests; cd -
cd turbine; mvn clean package -DskipTests; cd -
cd persona; mvn clean package -DskipTests; cd -

# docker-compose build;

cd hystrixdashboard; mvn clean; cd -
cd turbine; mvn clean; cd -
cd persona; mvn clean; cd -
