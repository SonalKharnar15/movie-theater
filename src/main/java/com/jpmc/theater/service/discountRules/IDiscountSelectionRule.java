package com.jpmc.theater.service.discountRules;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Shows;
import org.springframework.stereotype.Component;

import java.util.List;


public interface IDiscountSelectionRule {

    void setNextRule(IDiscountSelectionRule nextInChain);
    void process(Shows shows) ;


}
