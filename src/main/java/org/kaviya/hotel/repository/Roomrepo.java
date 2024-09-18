package org.kaviya.hotel.repository;




import org.kaviya.hotel.model.Room;
import org.kaviya.hotel.model.RoomType;
import org.kaviya.hotel.model.RoomStatus;

import java.util.Map;
import java.util.Optional;

public interface Roomrepo {

    void addRoom(Room room);

    boolean removeRoom(int id);

    Optional<Room> getRoomById(int id);

    Map<Integer, Room> getRoomsByType(RoomType type);

    Map<Integer, Room> getRoomsByStatus(RoomStatus status);

    boolean updateRoom(Room room);

    int getTotalRooms();
}


