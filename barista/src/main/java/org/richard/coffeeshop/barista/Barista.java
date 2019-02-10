package org.richard.coffeeshop.barista;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Created by 2019-02-10.
 */
public class Barista {
    @JsonIgnore
    private final OffsetDateTime createdAt;
    private final String id;
    private final String firstName;
    private final String lastName;

    public Barista(BaristaCreatedEvent event) {
        this.id = event.getId();
        this.firstName= event.getFirstName();
        this.lastName= event.getLastName();
        this.createdAt = event.getCreatedAt();
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barista)) return false;
        Barista barista = (Barista) o;
        return Objects.equals(createdAt, barista.createdAt) &&
                Objects.equals(id, barista.id) &&
                Objects.equals(firstName, barista.firstName) &&
                Objects.equals(lastName, barista.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, id, firstName, lastName);
    }
}
