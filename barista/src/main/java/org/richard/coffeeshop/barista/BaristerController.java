package org.richard.coffeeshop.barista;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by 2019-02-09.
 */
@RestController
@RequestMapping("/baristas")
public class BaristerController {


    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    Map<String, CreateBaristerCommand> commands = new HashMap<>();

    public BaristerController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping({"/", ""})
    public ResponseEntity<?> createBarister(@RequestBody Map<String, String> request) {
        CreateBaristerCommand createBaristerCommand
                = CreateBaristerCommand.builder()
                .id(UUID.randomUUID().toString())
                .firstName(request.get("first_name"))
                .lastName(request.get("last_name"))
                .build();

//        commands.put(createBaristerCommand.getId(), createBaristerCommand);
        commandGateway.send(commandGateway);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", "/barista/" + createBaristerCommand.getId());

        return ResponseEntity.accepted()
                .headers(responseHeaders)
                .build();
    }

    @GetMapping({"/", ""})
    public Collection<CreateBaristerCommand> getAllBaristas() {
        return commands.values();
    }
}
