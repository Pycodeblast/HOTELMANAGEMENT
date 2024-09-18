package org.kaviya.hotel.services;




import org.kaviya.hotel.model.Guest;
import org.kaviya.hotel.repository.GuestRepo;

import java.util.Map;
import java.util.Optional;

public class GuestService {

    private final GuestRepo guestRepository;

    public GuestService(GuestRepo guestRepository) {
        this.guestRepository = guestRepository;
    }

    // Add a new guest to the repository
    public void addGuest(Guest guest) {
        guestRepository.addGuest(guest);
    }

    // Remove a guest from the repository by their ID
    public boolean removeGuest(String id) {
        return guestRepository.removeGuest(id);
    }

    // Retrieve a guest from the repository by their ID
    public Optional<Guest> getGuestById(String id) {
        return guestRepository.getGuestById(id);
    }

    // Update an existing guest's details
    public boolean updateGuest(Guest guest) {
        return guestRepository.updateGuest(guest);
    }

    // Retrieve all guests
    public Map<String, Guest> getAllGuests() {
        return guestRepository.getAllGuests();
    }
}

