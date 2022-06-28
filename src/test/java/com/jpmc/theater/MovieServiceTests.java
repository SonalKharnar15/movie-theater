package com.jpmc.theater;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Shows;
import com.jpmc.theater.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MovieServiceTests {
    @Autowired
    MovieService movieService;

    @Test
    void specialMovieWith50PercentDiscountTest() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Shows shows = new Shows(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10, movieService.calculateTicketPrice(shows));

        System.out.println(Duration.ofMinutes(90));
    }
}
