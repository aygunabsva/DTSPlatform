package com.example.dtsplatform.configuration;

public class SecUrls {
    static String[] whiteList = {
            "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/admin/log-in"
    };

    static String[] adminUrls = {
            "/admin/register"
    };
}
