package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Seat;
import com.bookmyshow.bookmyshow.models.ShowSeat;
import com.bookmyshow.bookmyshow.models.ShowSeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
@Repository
public interface ShowSeatRepository extends JpaRepository <ShowSeat,Long>{
    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);

    @Override
     ShowSeat  save(ShowSeat entity);
}
