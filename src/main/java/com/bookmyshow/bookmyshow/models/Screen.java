package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private List<Seat>seats;
    private List<Feature> features;
}
