package tech.nautilus.beer.inventory.failover.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.nautilus.brewery.model.BeerInventoryDto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-05-31.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    public static final int QUANTITY_ON_HAND = 999;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId){
        log.debug("Failover Inventory Response for beerId:" + beerId);

        return List.of(BeerInventoryDto.builder()
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .beerId(beerId)
                .quantityOnHand(QUANTITY_ON_HAND)
                .build());
    }
}
