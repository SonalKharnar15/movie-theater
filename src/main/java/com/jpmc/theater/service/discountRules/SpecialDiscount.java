package com.jpmc.theater.service.discountRules;


import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Shows;
import org.springframework.stereotype.Component;

@Component
public class SpecialDiscount implements IDiscountSelectionRule {
    private static int MOVIE_CODE_SPECIAL = 1;

    private IDiscountSelectionRule nextInChain;


    @Override
    public void setNextRule(IDiscountSelectionRule nextInChain) {
        this.nextInChain = nextInChain;

    }


    @Override
    public void process(Shows shows) {
        Movie movie = shows.getMovie();
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
            specialDiscount = movie.getTicketPrice() * 0.2;  // 20% discount for special movie
        }
        shows.setMaxDiscount(Math.max(shows.getMaxDiscount(),specialDiscount));
        nextInChain.process(shows);
    }
}
