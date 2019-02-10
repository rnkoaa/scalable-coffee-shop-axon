package org.richard.coffeeshop.orders;

import java.time.OffsetDateTime;

/**
 * Created by 2019-02-09.
 */
public class CreateOrderCommand {
    private final String id;
    private final String customerId;
    private final OffsetDateTime createdAt = OffsetDateTime.now();

    public CreateOrderCommand(String id, String customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
