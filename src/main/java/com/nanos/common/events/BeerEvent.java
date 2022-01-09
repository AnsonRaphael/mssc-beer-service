package com.nanos.common.events;

import com.nanos.msscbeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BeerEvent implements Serializable {
    static final long serialVersionUID= -4971759396032732949L;

    private BeerDto beerDto;
}
