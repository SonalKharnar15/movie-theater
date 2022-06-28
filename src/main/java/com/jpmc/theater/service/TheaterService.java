package com.jpmc.theater.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jpmc.theater.model.Shows;
import com.jpmc.theater.model.Movie;
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
import java.util.concurrent.TimeUnit;

@Service
public class TheaterService {
    private static final Logger log = LogManager.getLogger(TheaterService.class);
    @Autowired
    ShowsService showsService;


    @Autowired
    LocalDateProvider provider;

    public void printScheduleInJSONFormat(){
        List<Shows> schedules = showsService.getSchedule();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(schedules);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            log.error("Error while printing shows in JSON format :" +  e.getMessage());
            e.printStackTrace();
        }

    }

    public void printSchedule() {
        System.out.println(provider.currentDate());
        System.out.println("===================================================");
        List<Shows> schedules = showsService.getSchedule();
        schedules.forEach(s ->
                System.out.println(s.getSequenceOfTheDay() + ": " + s.getStartTime() + " " + s.getMovie().getTitle() + " " + humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee())
        );
        System.out.println("===================================================");
    }

    public String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }

}
