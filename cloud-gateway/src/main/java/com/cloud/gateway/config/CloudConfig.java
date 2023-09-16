package com.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig {

	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder) {
	       return builder.routes()
	      .route("payment", r->r.path("/api/payment/**").uri("lb://PAYMENT-SERVICE"))
	      .route("order", r->r.path("/api/order/**").uri("lb://ORDER-SERVICE")) //dynamic routing -> because we are specifying applicationName
	      .build();
	    }
}
