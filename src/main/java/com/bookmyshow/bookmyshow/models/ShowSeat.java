package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
    private Date blockedAt;
}
