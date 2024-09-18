package org.kaviya.hotel.repository;



import org.kaviya.hotel.model.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InmemoryPaymentRepo implements Paymentrepo {

    private final Map<Integer, Payment> payments = new HashMap<>();

    @Override
    public void addPayment(Payment payment) {
        payments.put(payment.getPaymentid(), payment);
    }

    @Override
    public boolean removePayment(int paymentId) {
        return payments.remove(paymentId) != null;
    }

    @Override
    public Optional<Payment> getPaymentById(int paymentId) {
        return Optional.ofNullable(payments.get(paymentId));
    }

    @Override
    public boolean updatePayment(Payment payment) {
        if (payments.containsKey(payment.getPaymentid())) {
            payments.put(payment.getPaymentid(), payment);
            return true;
        }
        return false;
    }

    @Override
    public Map<Integer, Payment> getAllPayments() {
        return new HashMap<>(payments);
    }
}

