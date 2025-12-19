package org.yearup.data;

import org.yearup.models.User;

import java.util.List;

/**
 * Defines the contract for user data access operations.
 * This interface specifies the methods that implementing classes must provide
 * for creating, updating, and retrieving user records from a data source.
 */
public interface UserDao {
    // superclass methods to be overridden in child class
    List<User> getAll();
    User getUserById(int userId);
    User getUserByUserName(String username);
    int getIdByUsername(String username);
    User create(User user);
    User update(User user);
    boolean exists(String username);
}
