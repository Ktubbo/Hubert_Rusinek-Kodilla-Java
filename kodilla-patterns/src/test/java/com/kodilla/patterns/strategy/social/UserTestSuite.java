package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User mariusz = new Millenials("Mariusz Kuryła");
        User wojtek = new YGeneration("Wojciech Wojciechowski");
        User maciek = new ZGeneration("Maciej Maciejewski");

        //When
        String mariuszPost = mariusz.sharePost();
        String wojtekPost = wojtek.sharePost();
        String maciekPost = maciek.sharePost();

        //Then
        assertEquals("Post is shared on Facebook.", mariuszPost);
        assertEquals("Post is shared on Twitter.", wojtekPost);
        assertEquals("Post is shared on Snapchat.", maciekPost);

    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User mariusz = new Millenials("Mariusz Kuryła");
        //When
        mariusz.setSocialPublisher(new TwitterPublisher());
        //Then
        assertEquals("Post is shared on Twitter.",mariusz.sharePost());
    }

}
