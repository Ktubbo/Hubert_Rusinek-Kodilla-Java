package com.kodilla.testing.forum.statistics;


import java.util.ArrayList;
import java.util.List;

public class CalculateStatistics{
    private Statistics statistics;
    List<String> usersNames = new ArrayList<>();
    int postsCount;
    int commentsCount;

    public CalculateStatistics(List<String> usersNames, int postsCount, int commentsCount) {
        this.usersNames = usersNames;
        this.postsCount = postsCount;
        this.commentsCount = commentsCount;
    }

    public List<String> getUsersNames() {
        return usersNames;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public ForumStatistics calculateAdvStatistics(Statistics statistics) {

        int usersCount = getUsersNames().size();
        int postsCount = getPostsCount();
        int commentsCount = getCommentsCount();

        double postsPerUser = 0;
        if (usersCount != 0) {
            postsPerUser = (double)postsCount / (double)usersCount;
        }

        double commentsPerUser = 0;
        if (usersCount != 0) {
            commentsPerUser = (double)commentsCount / (double)usersCount;
        }

        double commentsPerPost = 0;
        if (postsCount != 0) {
            commentsPerPost = (double)commentsCount / (double)postsCount;
        }
        return new ForumStatistics(usersCount,postsCount,commentsCount,postsPerUser,commentsPerUser,commentsPerPost);
    }

    public void showStatistics() {
        CalculateStatistics calculateStatistics = new CalculateStatistics(usersNames,postsCount,commentsCount);
        ForumStatistics forumStatistics = calculateStatistics.calculateAdvStatistics(statistics);

        System.out.println("Users count: " + forumStatistics.getUsersCount() + "\n" +
                "Posts count: " + forumStatistics.getPostCount() + "\n" +
                "Comments count: " + forumStatistics.getCommentsCount() + "\n" +
                "Posts per User: " + forumStatistics.getPostsPerUser() + "\n" +
                "Comments per User: " + forumStatistics.getCommentsPerUser() + "\n" +
                "Comments per Post: " + forumStatistics.getCommentsPerPost());

    }
}
