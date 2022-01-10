package com.nanos.brewery.model.events;

import com.nanos.msscbeerservice.web.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
