package org.kaviya.hotel.model;

import java.util.Date;

public abstract class Payment {
    private int paymentid;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private Date paymentdate;

    public Payment(int paymentid, double amount, PaymentMethod method, PaymentStatus status,Date paymentdate){
        this.paymentid = paymentid;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.paymentdate = paymentdate;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public double getAmount() {
        return amount;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
