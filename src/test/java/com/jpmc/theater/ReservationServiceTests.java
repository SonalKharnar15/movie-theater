package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Shows;
import com.jpmc.theater.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class ReservationServiceTests {

    @Autowired
    ReservationService reservationService;

    @Test
    void totalFeeTest() {
        Customer customer = new Customer("John Doe", "unused-id");
        Shows showing = new Shows(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        Reservation reservation = new Reservation(customer, showing, 3);
        /*assertTrue(reservationService.reserve(customer, showing.getSequenceOfTheDay(), 3).totalFee() == 37.5);*/
        assertTrue(reservation.totalFee() == 37.5);
    }


    @Test
    void totalFeeForCustomerTest() {

        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = reservationService.reserve(john, 2, 4);
//        System.out.println("You have to pay " + reservationService.getTotalFee());
        assertEquals(reservation.totalFee(), 50);
    }

}
