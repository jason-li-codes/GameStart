package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import java.math.BigDecimal;

/**
 * Defines the contract for shopping cart operations.
 * This interface specifies the methods that implementing classes must provide
 * for creating, updating, and retrieving shopping carts from a data source.
 */
public interface ShoppingCartDao {

    // superclass methods to be overridden in child class
    ShoppingCart getByUserId(int userId);
    ShoppingCart getByOrderId(int orderId);
    ShoppingCart addItem(int userId, ShoppingCartItem item);
    void updateItem(int userId, ShoppingCartItem item);
    void deleteShoppingCart(int userId);
    BigDecimal getShoppingCartTotal(ShoppingCart shoppingCart);

}
