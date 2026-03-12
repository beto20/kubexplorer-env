package com.gateway.demo;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.stripPrefix;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    RouterFunction<ServerResponse> gatewayRoutes() {
//localhost:8080/java1/api/full
        return route("java1_route")
                .GET("/java1/api/**", http())
                // Nota: primero setea URI target y luego stripPrefix (ejemplo oficial)
                .before(uri("http://localhost:8081"))
                .before(stripPrefix(1))
                .build()
//localhost:8080/java2/api/**
                .and(route("java2_route")
                        .GET("/java2/api/**", http())
                        .before(uri("http://localhost:8082"))
                        .before(stripPrefix(1))
                        .build()
                        .and(
                        route("java4_route")
                                .GET("/java4/api/**", http())
                                .before(uri("http://localhost:8083"))
                                .before(stripPrefix(1))
                                .build()
                        )
                );
    }
}