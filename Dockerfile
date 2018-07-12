FROM ubuntu:16.04

MAINTAINER aby.koshy@gmail.com

# install java
RUN apt-get update && \
    apt-get install openjdk-8-jre-headless && \
    apt-get install maven && \
    apt-get clean all

RUN chmod 755 mvnm

EXPOSE 8080

CMD mvnw spring-boot:run