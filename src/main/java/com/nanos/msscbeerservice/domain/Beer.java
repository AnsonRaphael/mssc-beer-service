package com.nanos.msscbeerservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 30,columnDefinition = "varchar(36)",nullable = false,updatable = false)
    private UUID beerId;
    @Version
    private Long version;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    private String beerStyle;
    private String beerName;
    @Column(unique = true)
    private String upc;
    private BigDecimal price;

    private Integer minOnHand;
    private Integer quantityToBrew;
}
