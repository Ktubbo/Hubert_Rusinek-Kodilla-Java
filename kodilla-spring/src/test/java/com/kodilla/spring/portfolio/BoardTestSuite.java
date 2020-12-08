package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        TaskList toDoList = board.getToDoList();
        TaskList inProgressList = board.getInProgressList();
        TaskList doneList = board.getDoneList();

        //When
        toDoList.getTasks().add("Clean your code");
        inProgressList.getTasks().add("Finish module from last week");
        doneList.getTasks().add("Half of module is already done");

        //Then

        Assertions.assertEquals("Clean your code",board.getToDoList().getTasks().get(0));
        Assertions.assertEquals("Finish module from last week",board.getInProgressList().getTasks().get(0));
        Assertions.assertEquals("Half of module is already done",board.getDoneList().getTasks().get(0));

    }
}
