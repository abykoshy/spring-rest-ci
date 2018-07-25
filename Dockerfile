FROM maven:latest AS build
COPY . /src
RUN cd /src; mvn -DskipTests package

FROM java:8-jdk-alpine AS prod
MAINTAINER aby.koshy@gmail.com
RUN adduser -Dh /home/builder builder
WORKDIR /app
COPY --from=build /src/target/spring-rest-ci.jar .
ENTRYPOINT ["java","-jar","/app/spring-rest-ci.jar"]
EXPOSE 8080
