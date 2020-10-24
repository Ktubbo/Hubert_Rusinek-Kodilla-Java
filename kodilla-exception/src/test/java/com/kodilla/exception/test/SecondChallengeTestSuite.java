package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    public void probablyIWillThrowExceptionTest(){
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When&&Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2,1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1,1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1,1))
        );
    }
}
