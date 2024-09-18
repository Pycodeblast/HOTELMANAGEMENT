package org.kaviya.hotel.services;


import org.kaviya.hotel.model.Guest;
import org.kaviya.hotel.model.Reservation;
import org.kaviya.hotel.model.Room;
import org.kaviya.hotel.model.ReservationStatus;
import org.kaviya.hotel.repository.ReservationRepo;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class Reservationservice {

    private final ReservationRepo reservationRepo;

    public Reservationservice(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    // Book a room for a guest
    public boolean bookRoom(Room room, Guest guest, LocalDate checkin, LocalDate checkout) {
        if (isRoomAvailable(room, checkin, checkout)) {
            String id = generateReservationId();
            Reservation reservation = new Reservation(id, ReservationStatus.BOOKED, room, guest, checkin, checkout) {
                // No additional methods or overrides needed
            };
            reservationRepo.addReservation(reservation);
            return true;
        }
        return false;
    }

    // Check if a room is available
    public boolean isRoomAvailable(Room room, LocalDate checkin, LocalDate checkout) {
        return reservationRepo.isRoomAvailable(room, checkin, checkout);
    }

    // Check-in a guest
    public boolean checkIn(String reservationId) {
        Optional<Reservation> reservationOpt = reservationRepo.getReservationById(reservationId);
        if (reservationOpt.isPresent()) {
            Reservation reservation = reservationOpt.get();
            if (reservation.getStatus() == ReservationStatus.BOOKED) {
                reservation.setStatus(ReservationStatus.CHECKED_IN);
                return reservationRepo.updateReservation(reservation);
            }
        }
        return false;
    }

    // Check-out a guest
    public boolean checkOut(String reservationId) {
        Optional<Reservation> reservationOpt = reservationRepo.getReservationById(reservationId);
        if (reservationOpt.isPresent()) {
            Reservation reservation = reservationOpt.get();
            if (reservation.getStatus() == ReservationStatus.CHECKED_IN) {
                return reservationRepo.removeReservation(reservationId);
            }
        }
        return false;
    }

    // Retrieve a reservation by its ID
    public Optional<Reservation> getReservationById(String reservationId) {
        return reservationRepo.getReservationById(reservationId);
    }

    // Retrieve all reservations
    public Map<String, Reservation> getAllReservations() {
        return reservationRepo.getAllReservations();
    }

    // Generate a unique reservation ID
    private String generateReservationId() {
        return java.util.UUID.randomUUID().toString();
    }
}

