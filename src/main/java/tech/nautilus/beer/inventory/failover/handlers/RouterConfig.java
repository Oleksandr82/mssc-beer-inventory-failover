package tech.nautilus.beer.inventory.failover.handlers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static tech.nautilus.beer.inventory.failover.ApiConstants.GET_BEER_INVENTORY;

@Configuration
@ConditionalOnProperty(name = "controller.reactive.enabled", havingValue = "true")
public class RouterConfig {

    @Bean
    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler) {
        return route(GET(GET_BEER_INVENTORY).and(accept(MediaType.APPLICATION_JSON)), inventoryHandler::handle);
    }
}
