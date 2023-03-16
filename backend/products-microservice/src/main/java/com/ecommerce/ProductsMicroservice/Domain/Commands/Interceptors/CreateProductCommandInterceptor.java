package com.ecommerce.ProductsMicroservice.Domain.Commands.Interceptors;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

import javax.annotation.Nonnull;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.ProductsMicroservice.Domain.Commands.CreateProductCommand;

public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    private static final Logger logger= LoggerFactory.getLogger(CreateProductCommandInterceptor.class);

    @Override
    @Nonnull
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
            @Nonnull List<? extends CommandMessage<?>> messages
    )
    {
        return (commandIndex, command) -> {
            logger.info("Intercepted command : " + command.getPayloadType( ));

            if(CreateProductCommand.class.equals(command.getPayloadType( ))) {
                CreateProductCommand createProductCommand= (CreateProductCommand)command.getPayload( );

                if(createProductCommand.getProductPrice( ).compareTo(BigDecimal.ZERO) <= 0)
                    throw new IllegalArgumentException("Product price should be greater than 0");

                if(createProductCommand.getProductName( ) == null || createProductCommand.getProductName( ).isBlank( ))
                    throw new IllegalArgumentException("Product name cannot be empty");
            }

            return command;
        };
    }

}