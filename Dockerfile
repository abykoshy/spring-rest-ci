FROM ubuntu:16.04

MAINTAINER aby.koshy@gmail.com

# install java
RUN apt-get update && \
    apt-get install -y openjdk-8-jre-headless && \
    apt-get install -y maven && \
    apt-get clean all

RUN chmod 755 mvnm

EXPOSE 8080

CMD mvnw spring-boot:run