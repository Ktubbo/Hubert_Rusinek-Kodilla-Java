package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    public int publicationYearMedian(Set<Book> bookSet) {
        Statistics statistics = new Statistics();
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> bookMap = new HashMap<>();
        bookSet.stream().forEach(book -> {bookMap.put(new BookSignature(book.getSignature()),
                new com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book(book.getAuthor(),book.getTitle(),book.getPublicationYear()));});
        return statistics.medianPublicationYear(bookMap);
    }
}
