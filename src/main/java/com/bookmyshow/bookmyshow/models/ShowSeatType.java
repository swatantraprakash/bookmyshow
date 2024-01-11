package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    //ShowSeatType = Show + SeatType

    private Show show;
    private SeatType seatType;
    private int price;
}
/*
                         1
ShowSeatType            show
1                        1
 */