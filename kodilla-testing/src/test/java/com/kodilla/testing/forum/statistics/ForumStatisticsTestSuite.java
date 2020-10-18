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
        when(statisticsMock.getPostsCount()).thenReturn(10);
        when(statisticsMock.getUsersName()).thenReturn(generateListOfNUsers(10));
        when(statisticsMock.getCommentsCount()).thenReturn(1000);
    }

    @Test
    public void test0PostsCount(){
        //Given
        when(statisticsMock.getPostsCount()).thenReturn(0);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock.getUsersName(),statisticsMock.getPostsCount(),statisticsMock.getCommentsCount());

        //When
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(0,forumStatistics.getPostsPerUser());
        Assertions.assertEquals(100,forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(0,forumStatistics.getCommentsPerPost());
    }

    @Test
    public void test1000PostsCount(){
        //Given
        when(statisticsMock.getPostsCount()).thenReturn(1000);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock.getUsersName(),statisticsMock.getPostsCount(),statisticsMock.getCommentsCount());

        //When
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(100,forumStatistics.getPostsPerUser());
        Assertions.assertEquals(100,forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(1,forumStatistics.getCommentsPerPost());
    }

    @Test
    public void test0CommentsCount(){
        //Given
        when(statisticsMock.getCommentsCount()).thenReturn(0);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock.getUsersName(),statisticsMock.getPostsCount(),statisticsMock.getCommentsCount());

        //When
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(1,forumStatistics.getPostsPerUser());
        Assertions.assertEquals(0,forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(0,forumStatistics.getCommentsPerPost());
    }

    @Test
    public void testMorePostsThanComments(){
        //Given
        when(statisticsMock.getCommentsCount()).thenReturn(100);
        when(statisticsMock.getPostsCount()).thenReturn(1000);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock.getUsersName(),statisticsMock.getPostsCount(),statisticsMock.getCommentsCount());

        //When
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(100,forumStatistics.getPostsPerUser());
        Assertions.assertEquals(10,forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(0.1,forumStatistics.getCommentsPerPost());
    }

    @Test
    public void testMoreCommentsThanPosts(){
        //Given
        when(statisticsMock.getCommentsCount()).thenReturn(1000);
        when(statisticsMock.getPostsCount()).thenReturn(100);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock.getUsersName(),statisticsMock.getPostsCount(),statisticsMock.getCommentsCount());

        //When
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(10,forumStatistics.getPostsPerUser());
        Assertions.assertEquals(100,forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(10,forumStatistics.getCommentsPerPost());
    }

    @Test
    public void test0UsersCount(){
        //Given
        when(statisticsMock.getUsersName()).thenReturn(generateListOfNUsers(0));
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock.getUsersName(),statisticsMock.getPostsCount(),statisticsMock.getCommentsCount());

        //When
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(0,forumStatistics.getPostsPerUser());
        Assertions.assertEquals(0,forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(100,forumStatistics.getCommentsPerPost());
    }

    @Test
    public void test100UsersCount(){
        //Given
        when(statisticsMock.getUsersName()).thenReturn(generateListOfNUsers(100));
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock.getUsersName(),statisticsMock.getPostsCount(),statisticsMock.getCommentsCount());

        //When
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assertions.assertEquals(0.1,forumStatistics.getPostsPerUser());
        Assertions.assertEquals(10,forumStatistics.getCommentsPerUser());
        Assertions.assertEquals(100,forumStatistics.getCommentsPerPost());
    }
}
