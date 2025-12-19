package org.yearup.data;

import org.yearup.models.OrderLineItem;

public interface OrderLineItemDao {
    // superclass methods to be overridden in child class
    OrderLineItem create(OrderLineItem orderLineItem);
}
