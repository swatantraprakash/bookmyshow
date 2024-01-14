package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    //ShowSeatType = Show + SeatType
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}
/*
 show_id    seat_type_id      One show belongs to multiple show seat type
 1             gold
 1             silver

 ===========================================================
 1             gold                 NOT POSSIBLE
 1             gold
 */
/*

/*
 show       seat_type
 1            gold
 2             gold
 */

/*
  M                       1
ShowSeatType            show
1                        1
 */