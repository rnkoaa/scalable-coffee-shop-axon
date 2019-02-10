package org.richard.coffeeshop.barista;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Created by 2019-02-10.
 */
public class BaristaCreatedEvent {

    private final OffsetDateTime createdAt;
    private final String firstName;
    private final String lastName;
    private final String id;

    public BaristaCreatedEvent(CreateBaristerCommand command) {
        this.createdAt = command.getCreatedAt();
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.id = command.getId();
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

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaristaCreatedEvent)) return false;
        BaristaCreatedEvent that = (BaristaCreatedEvent) o;
        return Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "BaristaCreatedEvent{" +
                "createdAt=" + createdAt +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
