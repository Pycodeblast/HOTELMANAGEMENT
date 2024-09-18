package org.kaviya.hotel.repository;

import org.kaviya.hotel.model.Guest;

import java.util.Map;
import java.util.Optional;

public interface GuestRepo{

    // Add a new guest to the repository
    void addGuest(Guest guest);

    // Remove a guest from the repository by their ID
    boolean removeGuest(String id);

    // Retrieve a guest from the repository by their ID
    Optional<Guest> getGuestById(String id);

    // Update an existing guest's details
    boolean updateGuest(Guest guest);

    // Retrieve all guests
    Map<String, Guest> getAllGuests();
}

