package com.nanos.msscbeerservice.services.brewing;

import com.nanos.msscbeerservice.config.JmsConfig;
import com.nanos.msscbeerservice.domain.Beer;
import com.nanos.brewery.model.events.BrewBeerEvent;
import com.nanos.brewery.model.events.NewInventoryEvent;
import com.nanos.msscbeerservice.repositories.BeerRepository;
import com.nanos.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewBeerListener {
    private final JmsTemplate jmsTemplate;
    private final BeerRepository beerRepository;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event){
        BeerDto beerDto=event.getBeerDto();
        Optional<Beer> beer = beerRepository.findById(beerDto.getBeerId());
        beerDto.setQuantityOnHand(beer.get().getQuantityToBrew());
        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("Brewed beer " + beer.get().getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());
        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE,newInventoryEvent);

    }
}
