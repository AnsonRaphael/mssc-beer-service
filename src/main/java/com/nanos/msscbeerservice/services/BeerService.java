package com.nanos.msscbeerservice.services;

import com.nanos.msscbeerservice.web.model.BeerDto;
import com.nanos.msscbeerservice.web.model.BeerPagedList;
import com.nanos.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest,Boolean showInventoryOnHand);
    BeerDto getBeerById(UUID beerId,Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerDto getByUpc(String upc);
}
