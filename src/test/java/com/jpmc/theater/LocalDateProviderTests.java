package com.jpmc.theater;

import com.jpmc.theater.utility.LocalDateProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocalDateProviderTests {
    @Autowired
    LocalDateProvider  provider;
    @Test
    void makeSureCurrentTimeTest() {
        System.out.println("current time is - " + provider.currentDate());
    }
}
