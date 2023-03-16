package com.ecommerce.ProductsMicroservice;

import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import com.ecommerce.ProductsMicroservice.Domain.Commands.Interceptors.CreateProductCommandInterceptor;

@EnableDiscoveryClient
@SpringBootApplication
public class App {

    public static void main(String[ ] args) {
        SpringApplication.run(App.class, args);}

    @Autowired
    // register the command dispatch interceptor to the command bus
    public void registerCreateProductCommandInterceptor(ApplicationContext context, CommandBus commandBus) {

        commandBus.registerDispatchInterceptor(
            context.getBean(CreateProductCommandInterceptor.class)
        );
    }

}