package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        System.out.println("Filter: Sex - male");
        Forum forum = new Forum();
        forum.getTheList().stream()
            .filter(forumUser -> forumUser.getSex() == 'm')
                .forEach(System.out::println);

        System.out.println("\nFilter: Age - more than 20yo");

        forum.getTheList().stream()
                .filter(forumUser -> (LocalDate.now().getYear() - forumUser.getBirthDate().getYear()) > 20)
                .forEach(System.out::println);

        System.out.println("\nFilter: Posts count - more than 1 post");

        forum.getTheList().stream()
                .filter(forumUser -> forumUser.getPostsCount() > 1)
                .forEach(System.out::println);

        System.out.println("\nMap of Forum Users");

        Map<Integer, ForumUser> theMapOfForumUsers = forum.getTheList().stream()
                .collect(Collectors.toMap(ForumUser::getUniqueUserID, forumUser -> forumUser));
        System.out.println("# elements: " + theMapOfForumUsers.size());
        theMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}