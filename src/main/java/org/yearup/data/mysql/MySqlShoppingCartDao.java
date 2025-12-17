package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {

        String sql = """
                SELECT
                    *
                FROM
                    shoppingcart
                WHERE
                    user_id = ?""";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public ShoppingCart getByProductId(int productId) {
        return null;
    }

    @Override
    public ShoppingCart getByOrderId(int orderId) {
        return null;
    }

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCartItem item) {
        return null;
    }

    @Override
    public BigDecimal getShoppingCartTotal(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public void deleteShoppingCart(ShoppingCart shoppingCart) {

    }
}
