package com.nanos.common.events;

import com.nanos.msscbeerservice.web.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }

}
