package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Booking extends BaseModel{
private BookingStatus bookingStatus;

@ManyToMany
private List<ShowSeat> showSeats;
@ManyToOne
private User user;
@ManyToOne
private Show show;
@OneToMany
private List<Payment> payments;
private Date bookDate;
private int amount;
}

/*
booking_id    show_id   screen_id   status
1     barbie     1234       cancelled
2     barbie     1234       Booked

M                1        because booking might cancelled but we need keep track of it also
Booking         showSeat
1               M

  M                          1
Booking                   User
1                          1

M:1


 M                          1
  Booking                  Show
  1                          1



   1                        1
Booking               Payments
1                       M

 */