package org.yearup.data;


import org.yearup.models.Profile;

/**
 * Defines the contract for profiles access operations.
 * This interface specifies the methods that implementing classes must provide
 * for creating, updating, and retrieving profiles from a data source.
 */
public interface ProfileDao {
    // superclass methods to be overridden in child class
    Profile create(Profile profile);
    Profile update(int userId, Profile profile);
    Profile getProfileByUserId(int id);
}
