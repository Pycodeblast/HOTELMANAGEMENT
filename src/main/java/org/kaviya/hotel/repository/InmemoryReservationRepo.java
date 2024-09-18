package org.kaviya.hotel.repository;

import org.kaviya.hotel.model.Guest;
import org.kaviya.hotel.model.Reservation;
import org.kaviya.hotel.model.Room;
import org.kaviya.hotel.model.ReservationStatus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InmemoryReservationRepo implements ReservationRepo {

    private final Map<String, Reservation> reservations = new HashMap<>();

    @Override
    public void addReservation(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    @Override
    public boolean removeReservation(String id) {
        return reservations.remove(id) != null;
    }

    @Override
    public Optional<Reservation> getReservationById(String id) {
        return Optional.ofNullable(reservations.get(id));
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        if (reservations.containsKey(reservation.getId())) {
            reservations.put(reservation.getId(), reservation);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Reservation> getAllReservations() {
        return new HashMap<>(reservations);
    }

    @Override
    public boolean isRoomAvailable(Room room, LocalDate checkin, LocalDate checkout) {
        return reservations.values().stream()
                .noneMatch(reservation -> reservation.getRoom().equals(room) &&
                        reservation.getCheckin().isBefore(checkout) &&
                        reservation.getCheckout().isAfter(checkin));
    }

    @Override
    public boolean bookRoom(Room room, Guest guest, LocalDate checkin, LocalDate checkout) {
        if (isRoomAvailable(room, checkin, checkout)) {
            String id = generateReservationId();
            Reservation reservation = new Reservation(id, ReservationStatus.BOOKED, room, guest, checkin, checkout) {
                // No additional methods or overrides needed
            };
            addReservation(reservation);
            return true;
        }
        return false;
    }


    @Override
    public boolean checkIn(String reservationId) {
        Optional<Reservation> reservationOpt = getReservationById(reservationId);
        if (reservationOpt.isPresent()) {
            Reservation reservation = reservationOpt.get();
            if (reservation.getStatus() == ReservationStatus.BOOKED) {
                reservation.setStatus(ReservationStatus.CHECKED_IN);
                updateReservation(reservation);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkOut(String reservationId) {
        Optional<Reservation> reservationOpt = getReservationById(reservationId);
        if (reservationOpt.isPresent()) {
            Reservation reservation = reservationOpt.get();
            if (reservation.getStatus() == ReservationStatus.CHECKED_IN) {
                removeReservation(reservationId);
                return true;
            }
        }
        return false;
    }

    private String generateReservationId() {
        return UUID.randomUUID().toString();
    }
}
