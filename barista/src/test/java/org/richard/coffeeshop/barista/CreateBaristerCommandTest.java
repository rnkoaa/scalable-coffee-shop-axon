package org.richard.coffeeshop.barista;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;


/**
 * Created by 2019-02-10.
 */
class CreateBaristerCommandTest {
    private FixtureConfiguration<BaristaAggregate> fixture;

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(BaristaAggregate.class);
    }

    @Test
    public void applyingCreateCommand() {
//        String orderId = UUID.randomUUID().toString();
//        String product = "Deluxe Chair";
//        fixture.givenNoPriorActivity()
//                .when(new PlaceOrderCommand(orderId, product))
//                .expectEvents(new OrderPlacedEvent(orderId, product));

        CreateBaristerCommand command = CreateBaristerCommand.builder()
                .id(UUID.randomUUID().toString())
                .firstName("Richard")
                .lastName("Agyei")
                .build();

        fixture.givenNoPriorActivity()
                .when(command)
                .expectEvents(new BaristaCreatedEvent(command));
    }
}