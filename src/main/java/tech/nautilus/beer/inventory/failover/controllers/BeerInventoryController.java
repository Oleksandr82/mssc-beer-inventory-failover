package tech.nautilus.beer.inventory.failover.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.nautilus.beer.inventory.service.repositories.BeerInventoryRepository;
import tech.nautilus.beer.inventory.service.web.mappers.BeerInventoryMapper;
import tech.nautilus.brewery.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by jt on 2019-05-31.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId){
        log.debug("Failover Inventory Response for beerId:" + beerId);

        return List.of(BeerInventoryDto.builder().build());
    }
}
