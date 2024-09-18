package org.kaviya.hotel.repository;

import org.kaviya.hotel.model.Guest;
import org.kaviya.hotel.model.Reservation;
import org.kaviya.hotel.model.Room;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public interface ReservationRepo {

    // Add a new reservation to the repository
    void addReservation(Reservation reservation);

    // Remove a reservation from the repository by its ID
    boolean removeReservation(String id);

    // Retrieve a reservation from the repository by its ID
    Optional<Reservation> getReservationById(String id);

    // Update an existing reservation's details
    boolean updateReservation(Reservation reservation);

    // Retrieve all reservations
    Map<String, Reservation> getAllReservations();

    // Check if a room is available for the given date range
    boolean isRoomAvailable(Room room, LocalDate checkin, LocalDate checkout);

    // Book a room for a guest
    boolean bookRoom(Room room, Guest guest, LocalDate checkin, LocalDate checkout);

    // Check-in a guest
    boolean checkIn(String reservationId);

    // Check-out a guest
    boolean checkOut(String reservationId);
}
