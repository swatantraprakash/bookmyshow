package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.models.ShowSeat;
import com.bookmyshow.bookmyshow.models.ShowSeatStatus;
import com.bookmyshow.bookmyshow.models.ShowSeatType;
import com.bookmyshow.bookmyshow.repositories.ShowSeatRepository;
import com.bookmyshow.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    public int calculatePrice(List<ShowSeat> showSeats, Show show ){
        int amount=0;
        List<ShowSeatType> showSeatTypeList = showSeatTypeRepository.findAllByShow(show);
        for(ShowSeat showSeat:showSeats) {
            for (ShowSeatType showSeatType : showSeatTypeList) {
              if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                  amount+=showSeatType.getPrice();
              }
            }
        }
        return amount;
    }
}
