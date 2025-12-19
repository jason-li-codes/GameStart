package org.yearup.data;

import org.yearup.models.Category;

import java.util.List;

/**
 * Defines the contract for orders access operations.
 * This interface specifies the methods that implementing classes must provide
 * for creating, updating, and retrieving orders from a data source.
 */
public interface CategoryDao
{
    // superclass methods to be overridden in child class
    List<Category> getAllCategories();
    Category getById(int categoryId);
    Category create(Category category);
    void update(int categoryId, Category category);
    void delete(int categoryId);
}
