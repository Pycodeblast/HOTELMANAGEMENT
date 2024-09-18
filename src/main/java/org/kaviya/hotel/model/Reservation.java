package org.kaviya.hotel.model;

import java.time.LocalDate;

public abstract class Reservation {
    private String id;
    private ReservationStatus status;
    private Room room;
    private Guest guest;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation(String id, ReservationStatus status, Room room, Guest guest, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.status = status;
        this.room = room;
        this.guest = guest;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public Room getRoom() {
        return room;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
