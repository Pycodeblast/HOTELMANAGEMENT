package org.kaviya.hotel.services;


import org.kaviya.hotel.model.Room;
import org.kaviya.hotel.model.RoomStatus;
import org.kaviya.hotel.model.RoomType;
import org.kaviya.hotel.repository.Roomrepo;

import java.util.Map;
import java.util.Optional;

public class RoomService {

    private final Roomrepo roomRepository;

    public RoomService(Roomrepo roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Add a new room to the repository
    public void addRoom(Room room) {
        roomRepository.addRoom(room);
    }

    // Remove a room from the repository by its ID
    public boolean removeRoom(int id) {
        return roomRepository.removeRoom(id);
    }

    // Retrieve a room from the repository by its ID
    public Optional<Room> getRoomById(int id) {
        return roomRepository.getRoomById(id);
    }

    // Update an existing room's details
    public boolean updateRoom(Room room) {
        return roomRepository.updateRoom(room);
    }

    // Retrieve rooms by type
    public Map<Integer, Room> getRoomsByType(RoomType type) {
        return roomRepository.getRoomsByType(type);
    }

    // Retrieve rooms by status
    public Map<Integer, Room> getRoomsByStatus(RoomStatus status) {
        return roomRepository.getRoomsByStatus(status);
    }

    // Get the total number of rooms
    public int getTotalRooms() {
        return roomRepository.getTotalRooms();
    }
}

