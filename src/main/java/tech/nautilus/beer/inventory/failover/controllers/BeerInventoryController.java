package tech.nautilus.beer.inventory.failover.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.nautilus.brewery.model.BeerInventoryDto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static tech.nautilus.beer.inventory.failover.ApiConstants.GET_BEER_INVENTORY;
import static tech.nautilus.beer.inventory.failover.ApiConstants.QUANTITY_ON_HAND;

/**
 * Created by jt on 2019-05-31.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@ConditionalOnProperty(name = "controller.reactive.enabled", havingValue = "false")
public class BeerInventoryController {

    @GetMapping(GET_BEER_INVENTORY)
    List<BeerInventoryDto> listBeersById(){
        log.debug("Failover Inventory Response");

        return List.of(BeerInventoryDto.builder()
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .beerId(new UUID(0, 0))
                .quantityOnHand(QUANTITY_ON_HAND)
                .build());
    }
}
