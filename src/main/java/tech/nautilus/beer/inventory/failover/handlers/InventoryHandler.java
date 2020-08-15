package tech.nautilus.beer.inventory.failover.handlers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tech.nautilus.brewery.model.BeerInventoryDto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static tech.nautilus.beer.inventory.failover.ApiConstants.QUANTITY_ON_HAND;

@Component
@ConditionalOnProperty(name = "controller.reactive.enabled", havingValue = "true")
public class InventoryHandler implements HandlerFunction<ServerResponse> {

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(List.of(BeerInventoryDto.builder().
                        id(UUID.randomUUID())
                        .createdDate(OffsetDateTime.now())
                        .lastModifiedDate(OffsetDateTime.now())
                        .beerId(new UUID(0,0))
                        .quantityOnHand(QUANTITY_ON_HAND)
                        .build())),
                        List.class);
    }
}
