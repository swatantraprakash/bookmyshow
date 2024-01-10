package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Booking extends BaseModel{
private BookingStatus bookingStatus;
private List<ShowSeat> showSeats;
private User user;
private Show show;
private int amount;
private List<Payment> payments;
}
