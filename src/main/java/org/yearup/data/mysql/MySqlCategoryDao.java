package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {

    // constructor injects the DataSource and passes it to the base DAO class
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        // list to store all categories
        List<Category> categories = new ArrayList<>();
        // SQL to select all categories
        String sql = """
                SELECT
                    *
                FROM
                    categories;""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // execute query
            ResultSet row = statement.executeQuery();
            // iterate through each row
            while (row.next()) {
                // map row to Category object
                Category category = mapCategoryRow(row);
                // add each category to list
                categories.add(category);
            }

        } catch (SQLException e) { // check for SQLException
            throw new RuntimeException(e);
        }
        // return list of categories
        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        // parameterized SQL to prevent SQL injection
        String sql = """
                SELECT
                    *
                FROM
                    categories
                WHERE
                    category_id = ?""";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // set correct categoryId
            preparedStatement.setInt(1, categoryId);
            // execute query
            ResultSet resultSet = preparedStatement.executeQuery();
            // iterate through the row
            if (resultSet.next()) {
                // map row to Category object
                return mapCategoryRow(resultSet);
            }
        } catch (SQLException e) { // check for SQLException
            throw new RuntimeException(e);
        }
        // return null if not found
        return null;
    }

    @Override
    public Category create(Category category) {
        // parameterized SQL to prevent SQL injection
        String sql = """
                INSERT INTO
                    categories (name, description)
                VALUES
                    (?, ?);""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // set correct parameters
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            // execute insert
            int rowsAffected = statement.executeUpdate();
            // check if insert succeeded
            if (rowsAffected > 0) {
                // get auto-incremented key
                ResultSet generatedKeys = statement.getGeneratedKeys();
                // retrieve generated key
                if (generatedKeys.next()) {
                    int categoryId = generatedKeys.getInt(1);
                    // return Category object
                    return getById(categoryId);
                }
            }
        } catch (SQLException e) { // check for SQLException
            throw new RuntimeException(e);
        }
        // return null if not found
        return null;
    }

    @Override
    public void update(int categoryId, Category category) {
        // parameterized SQL to prevent SQL injection
        String sql = """
                UPDATE
                    categories
                SET
                    name = ?,
                    description = ?
                WHERE
                    category_id = ?;""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // set correct parameters
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.setInt(3, categoryId);
            // execute update
            statement.executeUpdate();
        } catch (SQLException e) { // check for SQLException
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int categoryId) {
        // parameterized SQL to prevent SQL injection
        String sql = """
                DELETE FROM
                    categories
                WHERE
                    category_id = ?;""";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // set correct parameters
            statement.setInt(1, categoryId);
            // execute update
            statement.executeUpdate();
        } catch (SQLException e) { // check for SQLException
            throw new RuntimeException(e);
        }
    }

    protected static Category mapCategoryRow(ResultSet row) throws SQLException {
        // get correct Category values by using getters for ResultSet
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");
        // create and return Category based on parameters
        return new Category(categoryId, name, description);
    }

}
