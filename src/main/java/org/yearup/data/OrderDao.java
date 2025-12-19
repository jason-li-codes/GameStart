package org.yearup.data;

import org.yearup.models.Order;

import java.util.List;

public interface OrderDao {
    // superclass methods to be overridden in child class
    Order create(Order order);
    List<Order> getOrdersByUserId(int userId);
}