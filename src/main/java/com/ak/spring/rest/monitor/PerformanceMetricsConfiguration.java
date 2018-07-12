package com.ak.spring.rest.monitor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class PerformanceMetricsConfiguration {

    /**
     * Monitoring pointcut.
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void monitor() {
    }

    /**
     * Creates instance of performance monitor interceptor.
     *
     * @return performance monitor interceptor
     */
    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        /*
        setting to true was not logging it
         */
        PerformanceMonitorInterceptor performanceMonitorInterceptor =
             new PerformanceMonitorInterceptor(false);
        performanceMonitorInterceptor.setPrefix("Using PerformanceMonitorInterceptor...");
        return performanceMonitorInterceptor;
    }

    /**
     * Creates instance of performance monitor advisor.
     *
     * @return performance monitor advisor
     */
    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.ak.spring.rest.monitor.PerformanceMetricsConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }

}
