package com.kodilla.good.patterns.challenges.moviestore;

public class MovieStoreRunner {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        System.out.println(movieStore.getAllTitles(movieStore.getMovies()));

    }
}
