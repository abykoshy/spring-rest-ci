package com.ak.spring.rest.logging;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class CustomRequestLoggingFilter extends CommonsRequestLoggingFilter {

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        if (request.getRequestURI().matches(".*.ico|.*.png|.*.jpg|.*.htm")) {
            return false;
        }
        // remember to enable DEBUG logging for this new class, ref: application.properties
        return super.shouldLog(request);
    }
}
