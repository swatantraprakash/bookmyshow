package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    @OneToMany
    private List<Seat>seats;

    private List<Feature> features;
}
/*
 1               1
Screen         Seat
1               m

  1                   1
Screen            Feature
1                   m

 */