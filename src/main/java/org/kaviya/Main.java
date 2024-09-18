package org.kaviya;
import org.kaviya.hotel.model.*;
import org.kaviya.hotel.repository.InmemoryReservationRepo;
import org.kaviya.hotel.repository.InmemoryPaymentRepo;
import org.kaviya.hotel.services.Reservationservice;
import org.kaviya.hotel.services.PaymentService;

import java.time.LocalDate;
import java.util.Date;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create in-memory repositories
        InmemoryReservationRepo reservationRepo = new InmemoryReservationRepo();
        InmemoryPaymentRepo paymentRepo = new InmemoryPaymentRepo();

        // Create service instances
        Reservationservice reservationService = new Reservationservice(reservationRepo);
        PaymentService paymentService = new PaymentService(paymentRepo);

        // Create a guest with all required details
        Guest guest = new Guest("1", "John Doe", "123 Elm Street", "555-1234");

        // Output guest information
        System.out.println("Guest ID: " + guest.getId());
        System.out.println("Guest Name: " + guest.getName());
        System.out.println("Guest Address: " + guest.getAddress());
        System.out.println("Guest Phone Number: " + guest.getPhoneno());

        // Create room instances with updated constructor parameters
        Room singleRoom = new Room(101, RoomType.SINGLE, RoomStatus.AVAILABLE, 100.00);
        Room deluxeSuite = new Room(202, RoomType.DELUXE, RoomStatus.AVAILABLE, 250.00);

        // Output room information
        System.out.println("Room 1: " + singleRoom);
        System.out.println("Room 2: " + deluxeSuite);

        // Book a room
        LocalDate checkinDate = LocalDate.now();
        LocalDate checkoutDate = checkinDate.plusDays(2);
        boolean bookingResult = reservationService.bookRoom(deluxeSuite, guest, checkinDate, checkoutDate);

        if (bookingResult) {
            System.out.println("Room booked successfully!");

            // Retrieve the reservation ID (assuming the ID is returned or generated)
            String reservationId = getReservationId(reservationRepo, guest, deluxeSuite, checkinDate, checkoutDate);

            // Check-in the guest
            boolean checkInResult = reservationService.checkIn(reservationId);
            if (checkInResult) {
                System.out.println("Guest checked in successfully!");

                // Create a payment using an anonymous inner class
                Payment payment = new Payment(1, 200.00, PaymentMethod.CREDIT_CARD, PaymentStatus.COMPLETED, new Date()) {
                    // No additional methods or overrides needed
                };

                // You can now use the 'payment' object
                System.out.println("Payment ID: " + payment.getPaymentid());
                System.out.println("Amount: " + payment.getAmount());
                System.out.println("Payment Method: " + payment.getMethod());
                System.out.println("Payment Status: " + payment.getStatus());
                System.out.println("Payment Date: " + payment.getPaymentdate());
                boolean paymentResult = paymentService.addPayment(payment);
                if (paymentResult) {
                    System.out.println("Payment processed successfully!");
                } else {
                    System.out.println("Failed to process payment.");
                }

                // Check-out the guest
                boolean checkOutResult = reservationService.checkOut(reservationId);
                if (checkOutResult) {
                    System.out.println("Guest checked out successfully!");
                } else {
                    System.out.println("Failed to check out guest.");
                }
            } else {
                System.out.println("Failed to check in guest.");
            }
        } else {
            System.out.println("Failed to book room.");
        }
    }

    private static String getReservationId(InmemoryReservationRepo reservationRepo, Guest guest, Room deluxeSuite, LocalDate checkinDate, LocalDate checkoutDate) {
        // Iterate over all reservations in the repository
        return reservationRepo.getAllReservations().values().stream()
                .filter(reservation -> reservation.getGuest().equals(guest) &&
                        reservation.getRoom().equals(deluxeSuite) &&  // Compare with the provided room
                        reservation.getCheckin().equals(checkinDate) &&
                        reservation.getCheckout().equals(checkoutDate))
                .findFirst()  // Find the first matching reservation
                .map(Reservation::getId)  // Extract the reservation ID
                .orElseThrow(() -> new RuntimeException("Reservation not found."));  // Throw an exception if no reservation is found
    }

}

