package com.kodilla.hibernate.tasklist.dao;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

@ComponentScan(basePackages = {"com.kodilla.hibernate.tasklist.dao"})
@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    private final static String DESCRIPTION = "TaskList Test";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("To do",DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        Optional<TaskList> readTaskList = taskListDao.findById(id);

        assertTrue(readTaskList.isPresent());

        //Clean up
        taskListDao.deleteById(id);
    }
}
