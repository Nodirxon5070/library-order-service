package com.company.orderservice.constants;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedByOrdersBooksAPI(){
        String[] array = new String[]{"/ordersbooks/create","/ordersbooks/get/{id}","/ordersbooks/update/{id}","/ordersbooks/delete/{id}"};
        return GroupedOpenApi.builder()
                .group("OrdersBooks")
                .pathsToMatch(array)
                .build();
    }
    @Bean
    public GroupedOpenApi groupedByOrdersAPI(){
        String[] array = new String[]{"/orders/create","/orders/get/{id}","/orders/update/{id}","/orders/delete/{id}"};
        return GroupedOpenApi.builder()
                .group("Orders")
                .pathsToMatch(array)
                .build();
    }

}
