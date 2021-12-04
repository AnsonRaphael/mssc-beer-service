package com.nanos.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {

    private UUID beerId;


    private Integer version;



    private OffsetDateTime createdDate;


    private OffsetDateTime lastModifiedDate;


    private String beerName;


    private BeerStyleEnum beerStyle;


    private String upc;


    private BigDecimal price;

    private Integer quantityOnHand;
}
