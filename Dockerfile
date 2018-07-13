FROM ubuntu:16.04

MAINTAINER aby.koshy@gmail.com

# install java
RUN apt-get update && \
    apt-get install -y openjdk-8-jre-headless && \
    apt-get install -y maven && \
    apt-get clean all

# Copy app to /src
COPY . /src

RUN cd /src/target

EXPOSE 8080

CMD java -jar spring-rest-ci.jar
