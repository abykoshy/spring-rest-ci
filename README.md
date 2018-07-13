#### A simple Spring REST app to learn various monitoring and logging options and the deployment pipeline via CircleCI and Docker

For monitoring, there exists Actuator which has by default 2 services actuator/health and actuator/info enable just by adding the dependency in pom. 
This can be customized as shown in [HealthCheck.java](https://github.com/abykoshy/spring-rest-ci/blob/master/src/main/java/com/ak/spring/rest/monitor/HealthCheck.java)

For logging request, a standard CommonsRequestLoggingFilter is available and can be just configured as in [RestApplication.java](https://github.com/abykoshy/spring-rest-ci/blob/master/src/main/java/com/ak/spring/rest/RestApplication.java). 
Basic customization can be done as shown in [CustomRequestLoggingFilter](https://github.com/abykoshy/spring-rest-ci/blob/master/src/main/java/com/ak/spring/rest/logging/CustomRequestLoggingFilter.java)

For performance monitoring, a PerformanceMonitorInterceptor can be used as shown in [PerformanceMetricsConfiguration](https://github.com/abykoshy/spring-rest-ci/blob/master/src/main/java/com/ak/spring/rest/monitor/PerformanceMetricsConfiguration.java)

This app is then built automatically on any push on Git, using [CircleCI](https://circleci.com) using configuration in [config.yml](https://github.com/abykoshy/spring-rest-ci/blob/master/.circleci/config.yml) and then a Docker image is built on the [Docker Hub](https://hub.docker.com)

The generated Docker image can be run locally using the commands

`docker pull abykoshy/spring-rest-ci`

`docker run -d -p 8080:8080 abykoshy/spring-rest-ci`