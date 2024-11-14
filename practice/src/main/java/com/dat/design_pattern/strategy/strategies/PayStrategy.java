package com.dat.design_pattern.strategy.strategies;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
