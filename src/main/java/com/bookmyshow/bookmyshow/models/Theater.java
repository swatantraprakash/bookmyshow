package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    @ManyToOne
    private Region region;
    @OneToMany
    private List<Screen> screens;
}
/*
M             1
Theater     Region
1            1

  1               1
Theater         Screen
1                M
 */