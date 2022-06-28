package com.jpmc.theater.service;

import com.jpmc.theater.model.Shows;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.service.discountRules.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private static final Logger log = LogManager.getLogger(MovieService.class);
    public double calculateTicketPrice(Shows shows) {
        try{
            Movie movie = shows.getMovie();
            applyDiscount(shows);
            return movie.getTicketPrice() -shows.getMaxDiscount();
        }catch(Exception ex){
           log.error("Error while calculating ticket price : " +  ex.getMessage());
           ex.printStackTrace();
        }
        return  0;

    }

    private void applyDiscount(Shows shows) {

        IDiscountSelectionRule spacialDiscount = new SpecialDiscount();
        IDiscountSelectionRule sequenceDiscount = new SequenceDiscount();
        IDiscountSelectionRule startTimeDiscount = new StartTimeDiscount();
        IDiscountSelectionRule startDateDiscount = new StartDateDiscount();
        spacialDiscount.setNextRule(sequenceDiscount);
        sequenceDiscount.setNextRule(startTimeDiscount);
        startTimeDiscount.setNextRule(startDateDiscount);
        spacialDiscount.process(shows);
       // return shows.getMaxDiscount();
    }

}
