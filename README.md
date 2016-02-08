[![Build Status](https://semaphoreci.com/api/v1/cpelka/rest-address-service/branches/master/badge.svg)](https://semaphoreci.com/cpelka/rest-address-service)

# RESt Address Service (Demo Project for Article)

This project is used to setup CI/CD systems for an article about *Continuous Delivery*.

## Build & Dockerize

To build the project just run:

    mvn clean package

Afterwards the service can be dockered calling

    ./docker-build.sh

To start the container just run

    ./docker.run.sh


## Start without Docker

    mvn clean compile spring-boot:run


## RESt API Endpoints & Usage

### cURL Examples

Following examples assume a local docker-machine ip of _192.168.99.100_ - you might want to change this.

#### get a specific address (here address id=1)

    curl http://192.168.99.100:8080/address/1

#### get a list of addresses for a specific user (here user id=1):

    curl http://192.168.99.100:8080/address/user/1

#### create a new address for an user

    curl -X POST -H 'Content-type:application/json' --data "{\"userId\":1,\"street\":\"A Street 123\",\"zip\":\"12345\", \"city\":\"A City\",\"Country\":\"A Country\"}" http://192.168.99.100:8080/address/create
