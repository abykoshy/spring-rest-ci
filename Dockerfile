FROM ubuntu:16.04

MAINTAINER aby.koshy@gmail.com

# install java
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk-headless && \
    apt-get install -y maven && \
    apt-get clean all

# Copy app to /src
COPY . /src

RUN cd /src; mvn -DskipTests install

EXPOSE 8080

CMD cd /src/target && java -jar spring-rest-ci.jar
