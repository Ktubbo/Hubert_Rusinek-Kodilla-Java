package com.kodilla.testing.forum.statistics;

import java.util.Objects;

class ForumStatistics {
    public int usersCount;
    public int postCount;
    public int commentsCount;
    public double postsPerUser;
    public double commentsPerUser;
    public double commentsPerPost;

    public ForumStatistics(int usersCount, int postCount, int commentsCount, double postsPerUser, double commentsPerUser, double commentsPerPost) {
        this.usersCount = usersCount;
        this.postCount = postCount;
        this.commentsCount = commentsCount;
        this.postsPerUser = postsPerUser;
        this.commentsPerUser = commentsPerUser;
        this.commentsPerPost = commentsPerPost;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public void setPostsPerUser(double postsPerUser) {
        this.postsPerUser = postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public void setCommentsPerUser(double commentsPerUser) {
        this.commentsPerUser = commentsPerUser;
    }

    public double getCommentsPerPost() { return commentsPerPost; }

    public void setCommentPerPost(double postsPerComment) {
        this.commentsPerPost = postsPerComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumStatistics that = (ForumStatistics) o;
        return usersCount == that.usersCount &&
                postCount == that.postCount &&
                commentsCount == that.commentsCount &&
                Double.compare(that.postsPerUser, postsPerUser) == 0 &&
                Double.compare(that.commentsPerUser, commentsPerUser) == 0 &&
                Double.compare(that.commentsPerPost, commentsPerPost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersCount, postCount, commentsCount, postsPerUser, commentsPerUser, commentsPerPost);
    }
}
