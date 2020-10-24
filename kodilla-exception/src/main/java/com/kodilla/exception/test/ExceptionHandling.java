package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        double x = 1.5;
        double y = 1;

        try {
            secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println("Error!");
        } finally {
            System.out.println("Finally!");
        }
    }
}
