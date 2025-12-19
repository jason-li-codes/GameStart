package org.yearup.data;

import org.yearup.models.Order;

import java.util.List;

/**
 * Defines the contract for orders access operations.
 * This interface specifies the methods that implementing classes must provide
 * for creating, updating, and retrieving orders from a data source.
 */
public interface OrderDao {
    // superclass methods to be overridden in child class
    Order create(Order order);
    List<Order> getOrdersByUserId(int userId);
}