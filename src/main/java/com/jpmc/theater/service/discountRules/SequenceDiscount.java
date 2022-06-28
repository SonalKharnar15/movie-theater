package com.jpmc.theater.service.discountRules;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Shows;
import org.springframework.stereotype.Component;


public class SequenceDiscount implements IDiscountSelectionRule {

    private IDiscountSelectionRule nextInChain;



    @Override
    public void setNextRule(IDiscountSelectionRule nextInChain) {
        this.nextInChain = nextInChain;

    }

    @Override
    public void process(Shows shows) {
        Movie movie = shows.getMovie();
        double sequenceDiscount = 0;
        int showSequence = shows.getSequenceOfTheDay();
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {

            sequenceDiscount = 2; // $2 discount for 2nd show
        }

        shows.setMaxDiscount(Math.max(shows.getMaxDiscount(),sequenceDiscount));
        nextInChain.process(shows);
    }

}
