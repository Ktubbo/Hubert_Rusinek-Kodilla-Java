package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("New Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title "+ n,"Author " + n, LocalDate.of(2000+n,1,1))));
        Library shallowLibrary = null;
        Library deepLibrary = null;
        try {
            shallowLibrary = library.shallowCopy();
            shallowLibrary.setName("Shallow copied library");
        } catch(CloneNotSupportedException e) {
            System.out.println(e);
        }
        try {
            deepLibrary = library.deepCopy();
            deepLibrary.setName("Deep copied library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().clear();

        //Then
        System.out.println(library);
        System.out.println(shallowLibrary);
        System.out.println(deepLibrary);
        assertEquals(0,library.getBooks().size());
        assertEquals(0,shallowLibrary.getBooks().size());
        assertEquals(10,deepLibrary.getBooks().size());
        assertEquals(shallowLibrary.getBooks(),library.getBooks());
        assertNotEquals(library.getBooks(),deepLibrary.getBooks());
    }
}
