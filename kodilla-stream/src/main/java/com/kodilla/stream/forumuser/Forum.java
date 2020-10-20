package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theList = new ArrayList<>();

    public Forum() {
        theList.add(new ForumUser(73463001, "John Smith", 'm', LocalDate.of(1990, 12, 31), 57));
        theList.add(new ForumUser(61234002, "Dorothy Newman", 'f', LocalDate.of(1982, 4, 12), 102));
        theList.add(new ForumUser(12346003, "John Wolkowitz", 'm', LocalDate.of(1979, 10, 30), 36));
        theList.add(new ForumUser(78456004, "Lucy Riley", 'f', LocalDate.of(1996, 9, 18), 13));
        theList.add(new ForumUser(42318005, "Owen Rogers", 'm', LocalDate.of(1991, 2, 4), 75));
        theList.add(new ForumUser(56781006, "Matilda Davies", 'f', LocalDate.of(1989, 3, 5), 0));
        theList.add(new ForumUser(97462007, "Declan Booth", 'm', LocalDate.of(2002, 10, 27), 0));
        theList.add(new ForumUser(19374008, "Corinne Foster", 'f', LocalDate.of(2003, 11, 2), 0));
        theList.add(new ForumUser(53167009, "Khloe Fry", 'f', LocalDate.of(2005, 12, 1), 187));
        theList.add(new ForumUser(87564010, "Martin Valenzuela", 'm', LocalDate.of(1989, 7, 8), 14));
    }

    public List<ForumUser> getTheList(){
        return new ArrayList<>(theList);
    }
}
