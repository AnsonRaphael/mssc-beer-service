package com.nanos.msscbeerservice.services.brewing;

import com.nanos.msscbeerservice.config.JmsConfig;
import com.nanos.msscbeerservice.domain.Beer;
import com.nanos.common.events.BrewBeerEvent;
import com.nanos.msscbeerservice.repositories.BeerRepository;
import com.nanos.msscbeerservice.services.inventory.BeerInventoryService;
import com.nanos.msscbeerservice.web.mappers.BeerMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
@Service
public class BrewingService {
    private JmsTemplate jmsTemplate;
    private BeerRepository beerRepository;
    private BeerInventoryService beerInventoryService;
    private BeerMapper beerMapper;
    // check for low inventory and send jms message to brew new bear
    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory(){
        List<Beer> beers =beerRepository.findAll();
        for (Beer beer : beers){
            Integer quantityOnHand= beerInventoryService.getOnhandInventory(beer.getBeerId());
            Integer minOnHand=beer.getMinOnHand();
            log.debug("Min Onhand is: " + minOnHand);
            log.debug("Inventory is: "  + quantityOnHand);

            if(quantityOnHand<=minOnHand){
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE,new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        }
    }
}
