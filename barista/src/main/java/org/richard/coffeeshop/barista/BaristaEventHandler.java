package org.richard.coffeeshop.barista;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 2019-02-10.
 */
@Service
public class BaristaEventHandler {
    private Map<String,Barista> baristas = new HashMap<>();

    @EventHandler
    public void on(BaristaCreatedEvent event) {
        String orderId = event.getId();

        Barista barista = new Barista(event);
        baristas.put(orderId, barista);
    }

    @QueryHandler
    public List<Barista> findAllBaristas(FindAllBaristas findAllBaristas) {
        return new ArrayList<>(baristas.values());
    }
}
