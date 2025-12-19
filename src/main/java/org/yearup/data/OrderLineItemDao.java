package org.yearup.data;

import org.yearup.models.OrderLineItem;

/**
 * Defines the contract for order line items access operations.
 * This interface specifies the methods that implementing classes must provide
 * for creating, updating, and retrieving order line items from a data source.
 */
public interface OrderLineItemDao {
    // superclass methods to be overridden in child class
    OrderLineItem create(OrderLineItem orderLineItem);
}
