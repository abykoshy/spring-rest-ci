FROM centos:centos6

MAINTAINER aby.koshy@gmail.com

# install java
RUN sudo apt install openjdk-8-jre-headless

# Install Node...
RUN sudo apt-get install maven
RUN chmod 755 mvnm

EXPOSE 8080

CMD mvnw spring-boot:run