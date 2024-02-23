package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.exceptions.UserNotFoundException;
import com.bookmyshow.bookmyshow.models.*;
import com.bookmyshow.bookmyshow.repositories.BookingRepository;
import com.bookmyshow.bookmyshow.repositories.ShowRepository;
import com.bookmyshow.bookmyshow.repositories.ShowSeatRepository;
import com.bookmyshow.bookmyshow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculatorService, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public Booking bookMovie(Long userId, List<Long> seatIds, Long showId) {
        //1.Get the User with userId
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = userOptional.get();
        // 2.Get the show with ShowId
        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Show bookedShow = showOptional.get();
        //----------Start Transaction -----------
        //3.Get the seats with seatIds provided
        List<ShowSeat> showSeatList = showSeatRepository.findAllById(seatIds);
        for (ShowSeat showSeat : showSeatList) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED)) ||
                    (Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes() > 15
                    )) {
                throw new RuntimeException();
            }
        }
        //4.check if the seat are available
        //5.if no, return error
        //6.if yes,mark the status of seat as locked
        List<ShowSeat> saveShowSeats = new ArrayList<>();
        for (ShowSeat showSeat : showSeatList) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            saveShowSeats.add(showSeatRepository.save(showSeat));
        }
        //7.save the updated seat status in DB
        //----------End Transaction-----------
        //8.create corresponding booking object
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(saveShowSeats);
        booking.setUser(user);
        booking.setBookDate(new Date());
        booking.setShow(bookedShow);
        int price = priceCalculatorService.calculatePrice(saveShowSeats, bookedShow);
        booking.setAmount(price);
        bookingRepository.save(booking);
        return booking;
    }
}
