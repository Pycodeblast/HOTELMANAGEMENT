package org.kaviya.hotel.repository;



import org.kaviya.hotel.model.Room;
import org.kaviya.hotel.model.RoomType;
import org.kaviya.hotel.model.RoomStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InmemoryRoomrepo implements Roomrepo{

    private final Map<Integer, Room> roomMap = new HashMap<>();

    @Override
    public void addRoom(Room room) {
        roomMap.put(room.getId(), room);
    }

    @Override
    public boolean removeRoom(int id) {
        return roomMap.remove(id) != null;
    }
//    Optional is a container that may contain a non-null value or may be empty. It provides methods
//    to interact with the contained value, if present, or handle the absence of a value.

    @Override
    public Optional<Room> getRoomById(int id) {
        return Optional.ofNullable(roomMap.get(id));
    }

    @Override
    public Map<Integer, Room> getRoomsByType(RoomType type) {
        Map<Integer, Room> roomsByType = new HashMap<>();
        for (Room room : roomMap.values()) {
            if (room.getType() == type) {
                roomsByType.put(room.getId(), room);
            }
        }
        return roomsByType;
    }

    @Override
    public Map<Integer, Room> getRoomsByStatus(RoomStatus status) {
        Map<Integer, Room> roomsByStatus = new HashMap<>();
        for (Room room : roomMap.values()) {
            if (room.getStatus() == status) {
                roomsByStatus.put(room.getId(), room);
            }
        }
        return roomsByStatus;
    }

    @Override
    public boolean updateRoom(Room room) {
        if (roomMap.containsKey(room.getId())) {
            roomMap.put(room.getId(), room);
            return true;
        }
        return false;
    }

    @Override
    public int getTotalRooms() {
        return roomMap.size();
    }
}

