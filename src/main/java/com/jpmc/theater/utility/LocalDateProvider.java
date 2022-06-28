package com.jpmc.theater.utility;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
@Scope("singleton")
public class LocalDateProvider {
 /*   private static LocalDateProvider instance = null;

    *//**
     * @return make sure to return singleton instance
     *//*
    public static LocalDateProvider singleton() {
        if (instance == null) {
            instance = new LocalDateProvider();
        }
            return instance;
        }*/

    public LocalDate currentDate() {
            return LocalDate.now();
    }
}
