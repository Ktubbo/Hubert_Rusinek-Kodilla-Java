package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskQueueTestSuite {

    @Test
    public void testUpdate() {

        // Given
        TaskQueue codeReviews = new TaskQueue("Code Reviews");
        TaskQueue someNewClasses = new TaskQueue("New Classes");
        TaskQueue someNewTests = new TaskQueue("New Tests");
        Mentor mariuszKuryla = new Mentor("Mariusz Kuryła");
        Mentor wojciechMichniewicz = new Mentor("Wojciech Michniewicz");
        codeReviews.registerObserver(mariuszKuryla);
        someNewClasses.registerObserver(mariuszKuryla);
        codeReviews.registerObserver(wojciechMichniewicz);
        someNewClasses.registerObserver(wojciechMichniewicz);
        someNewTests.registerObserver(mariuszKuryla);

        // When
        codeReviews.addTask("New code review 1");
        codeReviews.addTask("New code review 2");
        someNewClasses.addTask("TaskQueue class added");
        codeReviews.addTask("New code review 3");
        someNewClasses.addTask("Mentor class added");
        someNewTests.addTask("TaskQueue test suite added");

        // Then
        assertEquals(6, mariuszKuryla.getUpdateCount());
        assertEquals(5, wojciechMichniewicz.getUpdateCount());
    }

}