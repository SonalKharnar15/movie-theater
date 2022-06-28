package com.jpmc.theater.model;

public class Reservation {
    private Customer customer;
    private Shows shows;
    private int audienceCount;

    public Reservation(Customer customer, Shows shows, int audienceCount) {
        this.customer = customer;
        this.shows = shows;
        this.audienceCount = audienceCount;
    }

    public double totalFee() {
        return shows.getMovieFee() * audienceCount;
    }
}
