package org.richard.coffeeshop.barista;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateRoot;

import java.time.OffsetDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by 2019-02-10.
 */
//@AggregateRoot
public class BaristaAggregate {

    @AggregateIdentifier
    private String id;
    private OffsetDateTime createdAt;
    private String firstName;
    private String lastName;

    /**
     * For Axon to be able to instantiate a new Aggregate root
     */
    protected BaristaAggregate() {
    }

    @CommandHandler
    public BaristaAggregate(CreateBaristerCommand command) {
        apply(new BaristaCreatedEvent(command));
    }

    @EventSourcingHandler
    public void on(BaristaCreatedEvent event) {
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.createdAt = event.getCreatedAt();
    }

    public String getId() {
        return id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
