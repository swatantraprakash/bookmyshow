package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String refNo;
    private int amount;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}
