package com.jpmc.theater.service;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Shows;
import com.jpmc.theater.utility.LocalDateProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowsService {
    private static final Logger log = LogManager.getLogger(ShowsService.class);
    @Autowired
    LocalDateProvider provider;
    public List<Shows> getSchedule(){



        List<Shows> schedule = new ArrayList<>();;

        try{
            Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
            Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
            Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);

            schedule.add(new Shows(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))));
            schedule.add(new Shows(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))));
            schedule.add(new Shows(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))));
            schedule.add(new Shows(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))));
            schedule.add(new Shows(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))));
            schedule.add(new Shows(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))));
            schedule.add(new Shows(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))));
            schedule.add(new Shows(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))));
            schedule.add(new Shows(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0))));
        }catch(Exception ex){
            log.error("Error while getting shows detaisl : "  +ex.getMessage());
            ex.printStackTrace();
        }

        return schedule;

    }

}
