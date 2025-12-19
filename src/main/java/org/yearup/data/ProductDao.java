package org.yearup.data;

import org.yearup.models.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Defines the contract for products access operations.
 * This interface specifies the methods that implementing classes must provide
 * for creating, updating, and retrieving products from a data source.
 */
public interface ProductDao
{
    // superclass methods to be overridden in child class
    List<Product> search(Integer categoryId, BigDecimal minPrice, BigDecimal maxPrice, String subCategory);
    List<Product> listByCategoryId(int categoryId);
    Product getById(int productId);
    Product create(Product product);
    void update(int productId, Product product);
    void delete(int productId);
}
