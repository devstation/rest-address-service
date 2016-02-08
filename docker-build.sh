#!/bin/bash

cp target/rest-address-service.jar target/classes/docker
cd target/classes/docker
sudo docker rmi devstation/rest-address-service:latest
sudo docker build --rm -t devstation/rest-address-service:latest .
