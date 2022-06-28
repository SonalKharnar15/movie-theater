package com.jpmc.theater.service;

import com.jpmc.theater.model.Shows;
import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private static final Logger log = LogManager.getLogger(ReservationService.class);
    @Autowired
    ShowsService showsService;
    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Shows show;
        try {
            List<Shows> shows = showsService.getSchedule();
            show = shows.get(sequence - 1);
        } catch (RuntimeException ex) {
            log.error("Error while getting reservation: "  + ex.getMessage());
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any shows for given sequence " + sequence);
        }


        return new Reservation(customer, show, howManyTickets);
    }

}