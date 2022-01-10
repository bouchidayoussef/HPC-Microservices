package org.sid.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class GetwayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GetwayApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route((r)->r.path("/customers/**").uri("http://localhost:8081/").id("r1"))
                .route((r)->r.path("/products/**").uri("http://localhost:8082/").id("r2"))
                .build();
    }
}
