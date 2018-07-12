package com.ak.spring.rest.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down()
                    .withDetail("Error Code", errorCode).build();
        }
        return Health.up().withDetail("DB Connection","UP").withDetail("DB sessions","10").build();
    }

    public int check() {
        /*
        Connect to DFC/DB and check
         */
        return 0;
    }
}
