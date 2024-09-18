package org.kaviya.hotel.repository;



import org.kaviya.hotel.model.Payment;

import java.util.Map;
import java.util.Optional;

public interface Paymentrepo {

    // Add a new payment to the repository
    void addPayment(Payment payment);

    // Remove a payment from the repository by its ID
    boolean removePayment(int paymentId);

    // Retrieve a payment from the repository by its ID
    Optional<Payment> getPaymentById(int paymentId);

    // Update an existing payment's details
    boolean updatePayment(Payment payment);

    // Retrieve all payments
    Map<Integer, Payment> getAllPayments();
}

