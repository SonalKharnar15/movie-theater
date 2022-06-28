package com.jpmc.theater.service.discountRules;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Shows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class StartDateDiscount implements IDiscountSelectionRule {
    private IDiscountSelectionRule nextInChain;

    @Override
    public void setNextRule(IDiscountSelectionRule nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void process(Shows shows) {
        Movie movie = shows.getMovie();
        double startDateDiscount = 0;
        if(shows.getStartTime().getDayOfMonth() == 7){
            startDateDiscount = 1;
        }

        shows.setMaxDiscount(Math.max(shows.getMaxDiscount(),startDateDiscount));
      //   nextInChain.process(shows);
    }
}

