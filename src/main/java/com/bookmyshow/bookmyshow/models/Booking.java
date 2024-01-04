package com.bookmyshow.bookmyshow.models;

import java.util.List;

public class Booking {
private BookingStatus bookingStatus;
private List<ShowSeat> showSeats;
private User user;
private Show show;
private int amount;
private List<Payment> payments;
}
