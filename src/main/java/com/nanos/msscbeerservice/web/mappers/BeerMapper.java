package com.nanos.msscbeerservice.web.mappers;

import com.nanos.msscbeerservice.domain.Beer;
import com.nanos.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
