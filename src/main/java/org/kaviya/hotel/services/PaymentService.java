package org.kaviya.hotel.services;

import org.kaviya.hotel.model.Payment;
import org.kaviya.hotel.repository.Paymentrepo;

import java.util.Map;
import java.util.Optional;

public class PaymentService {

    private final Paymentrepo paymentRepo;

    public PaymentService(Paymentrepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    // Add a new payment
    public boolean addPayment(Payment payment) {
        try {
            paymentRepo.addPayment(payment);
            return true;
        } catch (Exception e) {
            // Handle exceptions as needed (e.g., log them)
            return false;
        }
    }

    // Remove a payment by its ID
    public boolean removePayment(int paymentId) {
        return paymentRepo.removePayment(paymentId);
    }

    // Retrieve a payment by its ID
    public Optional<Payment> getPaymentById(int paymentId) {
        return paymentRepo.getPaymentById(paymentId);
    }

    // Update an existing payment
    public boolean updatePayment(Payment payment) {
        return paymentRepo.updatePayment(payment);
    }

    // Retrieve all payments
    public Map<Integer, Payment> getAllPayments() {
        return paymentRepo.getAllPayments();
    }
}

