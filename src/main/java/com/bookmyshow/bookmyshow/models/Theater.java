package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private Region region;
    private List<Screen> screens;
}
