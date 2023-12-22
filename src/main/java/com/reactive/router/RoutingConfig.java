package com.reactive.router;

import com.reactive.handler.CustomerHandler;
import com.reactive.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutingConfig {
    @Autowired
    private CustomerHandler customerHandler;
    @Autowired
    private CustomerStreamHandler customerStreamHandler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
            return RouterFunctions.route()
                    .GET("/router/customers",customerHandler::loadCustomers)
                    .GET("/router/customers/stream",customerStreamHandler::getCustomers)
                    .GET("/router/customers/{input}",customerHandler::findCustomer)
                    .POST("/router/customers/save",customerHandler::saveCustomer)
                    .build();

}


}
