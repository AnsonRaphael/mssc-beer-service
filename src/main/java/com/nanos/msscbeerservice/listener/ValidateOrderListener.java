package com.nanos.msscbeerservice.listener;

import com.nanos.brewery.model.events.BeerOrderDto;
import com.nanos.msscbeerservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValidateOrderListener {
    private final JmsTemplate jmsTemplate;
    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(@Payload BeerOrderDto beerOrderDto,
                       @Header MessageHeaders headers,
                       Message message){
        System.out.println(message);
    }
}
