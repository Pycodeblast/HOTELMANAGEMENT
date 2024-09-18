package org.kaviya.hotel.repository;

import org.kaviya.hotel.model.Guest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InmemoryGuestRepo implements GuestRepo {

    private final Map<String, Guest> guestMap = new HashMap<>();

    @Override
    public void addGuest(Guest guest) {
        guestMap.put(guest.getId(), guest);
    }

    @Override
    public boolean removeGuest(String id) {
        return guestMap.remove(id) != null;
    }

    @Override
    public Optional<Guest> getGuestById(String id) {
        return Optional.ofNullable(guestMap.get(id));
    }

    @Override
    public boolean updateGuest(Guest guest) {
        if (guestMap.containsKey(guest.getId())) {
            guestMap.put(guest.getId(), guest);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Guest> getAllGuests() {
        return new HashMap<>(guestMap);
    }
}

