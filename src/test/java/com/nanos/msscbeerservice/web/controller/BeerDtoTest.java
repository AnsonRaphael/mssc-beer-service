package com.nanos.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanos.msscbeerservice.bootstrap.BeerLoader;
import com.nanos.msscbeerservice.web.model.BeerDto;
import com.nanos.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.math.BigDecimal;
//@ActiveProfiles("snake")
@JsonTest
public class BeerDtoTest {
    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto beerDto = getValidBeerDto();
        String json = objectMapper.writeValueAsString(beerDto);
        System.out.println(json);
    }

}
