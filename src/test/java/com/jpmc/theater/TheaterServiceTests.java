package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.service.ReservationService;
import com.jpmc.theater.service.TheaterService;
import com.jpmc.theater.utility.LocalDateProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TheaterServiceTests {

    @Autowired
    private TheaterService theaterService;


    @Test
    void printMovieScheduleTest() {
        //TheaterService theaterService = new TheaterService(LocalDateProvider.singleton());
        theaterService.printSchedule();
    }

    @Test
    void printScheduleInJSONFormatTest() {
        //TheaterService theaterService = new TheaterService(LocalDateProvider.singleton());
        theaterService.printScheduleInJSONFormat();
    }

}
