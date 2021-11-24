package com.vishal.oauth.api.oauthapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RouteConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("myHeader", "myURI").addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/users/status/check").uri("lb://resourceserver"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion")).route(
						p -> p.path("/currency-conversion-new/**")
								.filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
										"/currency-conversion-feign/${segment}"))
								.uri("lb://currency-conversion"))
				.build();
	}
}
