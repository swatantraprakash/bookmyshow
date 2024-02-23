package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.BookMovieRequestDto;
import com.bookmyshow.bookmyshow.dtos.BookMovieResponseDto;
import com.bookmyshow.bookmyshow.dtos.ResponseStatus;
import com.bookmyshow.bookmyshow.models.Booking;
import com.bookmyshow.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto) {
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();
        Booking booking;
        try {
            booking = bookingService.bookMovie(requestDto.getUserId(), requestDto.getShowSeatId(), requestDto.getShowId());
            bookMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setAmount(booking.getAmount());
        } catch (Exception e) {
            bookMovieResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }

        return bookMovieResponseDto;
    }
}
