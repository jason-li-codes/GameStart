package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import java.math.BigDecimal;

public interface ShoppingCartDao {


    ShoppingCart getByUserId(int userId);
    ShoppingCart getByProductId(int productId);
    ShoppingCart getByOrderId(int orderId);
    ShoppingCart updateShoppingCart(ShoppingCartItem item);
    BigDecimal getShoppingCartTotal(ShoppingCart shoppingCart);
    void deleteShoppingCart(ShoppingCart shoppingCart);

}
