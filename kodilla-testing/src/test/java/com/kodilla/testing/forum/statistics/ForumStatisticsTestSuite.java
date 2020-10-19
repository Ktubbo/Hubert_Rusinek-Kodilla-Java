package com.kodilla.testing.forum.statistics;


import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("TDD: Forum Statistics Test Suite")
@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite{

    private static int testCounter = 0;

    @Mock
    private Statistics statisticsMock;

    private List<String> generateListOfNUsers(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        if(usersQuantity==0){ return  resultList; }
        for (int n = 1; n <= usersQuantity; n++){
            String userName = ("User"+n);
            resultList.add(userName);
        }
        return resultList;
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEachTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(10));
        when(statisticsMock.commentsCount()).thenReturn(1000);
    }

    @Test
    public void test0PostsCount(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics();
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(0,calculateStatistics.postPerUser);
        Assertions.assertEquals(100,calculateStatistics.commentsPerUser);
        Assertions.assertEquals(0,calculateStatistics.commentsPerPost);
    }

    @Test
    public void test1000PostsCount(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(100,calculateStatistics.postPerUser);
        Assertions.assertEquals(100,calculateStatistics.commentsPerUser);
        Assertions.assertEquals(1,calculateStatistics.commentsPerPost);
    }

    @Test
    public void test0CommentsCount(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(1,calculateStatistics.postPerUser);
        Assertions.assertEquals(0,calculateStatistics.commentsPerUser);
        Assertions.assertEquals(0,calculateStatistics.commentsPerPost);
    }

    @Test
    public void testMorePostsThanComments(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(1000);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(100,calculateStatistics.postPerUser);
        Assertions.assertEquals(10,calculateStatistics.commentsPerUser);
        Assertions.assertEquals(0.1,calculateStatistics.commentsPerPost);
    }

    @Test
    public void testMoreCommentsThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(100);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(10,calculateStatistics.postPerUser);
        Assertions.assertEquals(100,calculateStatistics.commentsPerUser);
        Assertions.assertEquals(10,calculateStatistics.commentsPerPost);
    }

    @Test
    public void test0UsersCount(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(0));
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(0,calculateStatistics.postPerUser);
        Assertions.assertEquals(0,calculateStatistics.commentsPerUser);
        Assertions.assertEquals(100,calculateStatistics.commentsPerPost);
    }

    @Test
    public void test100UsersCount(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(100));
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(0.1,calculateStatistics.postPerUser);
        Assertions.assertEquals(10,calculateStatistics.commentsPerUser);
        Assertions.assertEquals(100,calculateStatistics.commentsPerPost);
    }
}
