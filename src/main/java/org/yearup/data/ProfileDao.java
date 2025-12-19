package org.yearup.data;


import org.yearup.models.Profile;

public interface ProfileDao {
    // superclass methods to be overridden in child class
    Profile create(Profile profile);
    Profile update(int userId, Profile profile);
    Profile getProfileByUserId(int id);
}
