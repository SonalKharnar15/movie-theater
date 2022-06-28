package com.jpmc.theater.service.discountRules;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Shows;
import org.springframework.stereotype.Component;


public class StartTimeDiscount implements IDiscountSelectionRule {


    private IDiscountSelectionRule nextInChain;

    @Override
    public void setNextRule(IDiscountSelectionRule nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void process(Shows shows) {
        double startTimeDiscount = 0;
        Movie movie = shows.getMovie();
        if(shows.getStartTime().getHour() == 11 || shows.getStartTime().getHour() == 16){
            startTimeDiscount = movie.getTicketPrice() * 0.25;
        }

        shows.setMaxDiscount(Math.max(shows.getMaxDiscount(),startTimeDiscount));
        nextInChain.process(shows);
    }
}

