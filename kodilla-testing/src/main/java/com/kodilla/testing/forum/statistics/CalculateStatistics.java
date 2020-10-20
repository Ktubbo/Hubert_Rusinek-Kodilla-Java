package com.kodilla.testing.forum.statistics;


import java.util.ArrayList;
import java.util.List;

public class CalculateStatistics{
    private Statistics statistics;
    List<String> usersNames = new ArrayList<>();
    int postsCount;
    int commentsCount;
    double postPerUser;
    double commentsPerUser;
    double commentsPerPost;


    public void calculateAdvStatistics(Statistics statistics) {

        usersNames = statistics.usersNames();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        double resultPostsPerUser = 0;
        if (usersNames.size() != 0) {
            resultPostsPerUser = (double) postsCount / (double) usersNames.size();
        }
        postPerUser = resultPostsPerUser;

        double resultCommentsPerUser = 0;
        if (usersNames.size() != 0) {
            resultCommentsPerUser = (double)commentsCount / (double)usersNames.size();
        }
        commentsPerUser = resultCommentsPerUser;

        double resultCommentsPerPost = 0;
        if (postsCount != 0) {
            resultCommentsPerPost = (double)commentsCount / (double)postsCount;
        }
        commentsPerPost = resultCommentsPerPost;
    }


    public void showStatistics() {
        System.out.println("Users count: " + usersNames.size() + "\n" +
                "Posts count: " + postsCount + "\n" +
                "Comments count: " + commentsCount + "\n" +
                "Posts per User: " + postPerUser + "\n" +
                "Comments per User: " + commentsPerUser + "\n" +
                "Comments per Post: " + commentsPerPost);

    }
}
