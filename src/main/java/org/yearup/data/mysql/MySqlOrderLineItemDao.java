package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.OrderLineItemDao;
import org.yearup.models.OrderLineItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlOrderLineItemDao extends MySqlDaoBase implements OrderLineItemDao {
    // constructor injects the datasource and passes it to the base dao
    public MySqlOrderLineItemDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public OrderLineItem create(OrderLineItem orderLineItem) {
        // parameterized SQL to prevent SQL injection
        String sql = """
                INSERT INTO
                    order_line_items (order_id, product_id, sales_price, quantity, discount)
                VALUES
                    (?, ?, ?, ?, ?)
                """;

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            // set parameters for the insert
            preparedStatement.setInt(1, orderLineItem.getOrderId());
            preparedStatement.setInt(2, orderLineItem.getProductId());
            preparedStatement.setBigDecimal(3, orderLineItem.getSalesPrice());
            preparedStatement.setInt(4, orderLineItem.getQuantity());
            preparedStatement.setBigDecimal(5, orderLineItem.getDiscount());
            // execute insert and check if any row was affected
            int affectedRows = preparedStatement.executeUpdate();
            // retrieve generated id for the order line item
            if (affectedRows == 0) throw new SQLException("Creating category failed, no rows affected.");
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    orderLineItem.setOrderLineItemId(resultSet.getInt(1));
                }
            }
            // return object with generated id
            return orderLineItem;
        } catch (Exception e) { // wrap any exception
            throw new RuntimeException(e);
        }
    }
}
