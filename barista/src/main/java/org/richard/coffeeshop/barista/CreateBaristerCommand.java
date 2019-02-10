package org.richard.coffeeshop.barista;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Created by 2019-02-09.
 */
public class CreateBaristerCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String firstName;
    private final String lastName;
    private final OffsetDateTime createdAt = OffsetDateTime.now();

    CreateBaristerCommand(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CreatebaristaCommandBuilder builder() {
        return new CreatebaristaCommandBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateBaristerCommand)) return false;
        CreateBaristerCommand that = (CreateBaristerCommand) o;
        return id.equals(that.id) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public String toString() {
        return "CreateBaristerCommand(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", createdAt=" + this.getCreatedAt() + ")";
    }

    public CreatebaristaCommandBuilder toBuilder() {
        return new CreatebaristaCommandBuilder().id(this.id).firstName(this.firstName).lastName(this.lastName);
    }

    public static class CreatebaristaCommandBuilder {
        private String id;
        private String firstName;
        private String lastName;

        CreatebaristaCommandBuilder() {
        }

        public CreateBaristerCommand.CreatebaristaCommandBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CreateBaristerCommand.CreatebaristaCommandBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CreateBaristerCommand.CreatebaristaCommandBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CreateBaristerCommand build() {
            return new CreateBaristerCommand(id, firstName, lastName);
        }

        public String toString() {
            return "CreateBaristerCommand.CreatebaristaCommandBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ")";
        }
    }
}
