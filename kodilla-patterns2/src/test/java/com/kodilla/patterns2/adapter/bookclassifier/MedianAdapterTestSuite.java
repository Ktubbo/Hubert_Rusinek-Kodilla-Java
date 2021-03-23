package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        Book book1 = new Book("Stanisław Lem","Astronauci",1951,"123456");
        Book book2 = new Book("Stanisław Lem","Czas nieutracony",1955,"123456");
        Book book3 = new Book("Stanisław Lem","Solaris",1961,"123456");
        Book book4 = new Book("Stanisław Lem","Fiasko",1987,"123456");
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        //When
        MedianAdapter medianAdapter = new MedianAdapter();
        int result = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(1961,result);
    }
}