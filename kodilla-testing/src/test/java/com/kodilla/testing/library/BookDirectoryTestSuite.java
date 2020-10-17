package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionsReturnList() {

        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {

        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListBooksInHandsOfInBookLibrary0Books(){
        //Given
        LibraryUser libraryUserWith0Books = new LibraryUser("First","User","90121305612");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> user0BookList = new ArrayList<>();

        //When
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWith0Books)).thenReturn(user0BookList);
        List<Book> result0UserBookList = bookLibrary.listBooksInHandsOf(libraryUserWith0Books);

        //Then
        assertEquals(0,result0UserBookList.size());
    }

    @Test
    void testListBooksInHandsOfInBookLibrary1Book(){
        //Given
        LibraryUser libraryUserWith1Book = new LibraryUser("Second","User","96081223512");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> user1BookList = generateListOfNBooks(1);

        //When
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWith1Book)).thenReturn(user1BookList);
        List<Book> result1UserBookList = bookLibrary.listBooksInHandsOf(libraryUserWith1Book);

        //Then
        assertEquals(1,result1UserBookList.size());
    }

    @Test
    void testListBooksInHandsOfInBookLibrary5Books(){
        //Given
        LibraryUser libraryUserWith0Books = new LibraryUser("First","User","90121305612");
        LibraryUser libraryUserWith1Book = new LibraryUser("Second","User","96081223512");
        LibraryUser libraryUserWith5Books = new LibraryUser("Third","User","89010173632");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> user0BookList = new ArrayList<>();
        List<Book> user1BookList = generateListOfNBooks(1);
        List<Book> user5BookList = generateListOfNBooks(5);

        //When
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWith0Books)).thenReturn(user0BookList);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWith1Book)).thenReturn(user1BookList);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWith5Books)).thenReturn(user5BookList);
        List<Book> result0UserBookList = bookLibrary.listBooksInHandsOf(libraryUserWith0Books);
        List<Book> result1UserBookList = bookLibrary.listBooksInHandsOf(libraryUserWith1Book);
        List<Book> result5UserBookList = bookLibrary.listBooksInHandsOf(libraryUserWith5Books);

        //Then
        assertEquals(0,result0UserBookList.size());
        assertEquals(1,result1UserBookList.size());
        assertEquals(5,result5UserBookList.size());
    }
}