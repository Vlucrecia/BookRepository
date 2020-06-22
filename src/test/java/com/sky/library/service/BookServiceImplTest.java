package com.sky.library.service;

import com.sky.library.BookRepositoryStub;
import com.sky.library.exception.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookServiceImplTest {

    private BookService bookService;

    static Stream<Arguments> getDataForInvalidBooks() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("INVALID-TEXT"));
    }

    static Stream<Arguments> getDataForValidBooks() {
        return Stream.of(
                Arguments.of("BOOK-GRUFF472", "The Gruffalo Book"),
                Arguments.of("BOOK-POOH222", "Winnie The Pooh Book"),
                Arguments.of("BOOK-WILL987", "The Wind In The Willows Book"));
    }

    static Stream<Arguments> getDataForValidBookSummary() {
        return Stream.of(
                Arguments.of("BOOK-GRUFF472", "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods."),
                Arguments.of("BOOK-POOH222", "[BOOK-POOH222] Winnie The Pooh - In this first volume, we meet all the friends..."),
                Arguments.of("BOOK-WILL987", "[BOOK-WILL987] The Wind In The Willows - With the arrival of spring and fine weather outside..."));
    }

    @BeforeEach
    public void init() {
        bookService = new BookServiceImpl(new BookRepositoryStub());
    }

    @ParameterizedTest
    @MethodSource("getDataForInvalidBooks")
    void Given_InvalidBookReference_When_RetrieveBook_Then_Exception(String bookReference) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.retrieveBook(bookReference);
        });
        assertEquals(BookService.ERR_INVALID_BOOK_REFERENCE, exception.getMessage());
    }

    @Test
    void Given_BookReferenceDoesNotExist_When_RetrieveBook_Then_BookNotFoundException() {
        Exception exception = assertThrows(BookNotFoundException.class, () -> {
            bookService.retrieveBook("BOOK-999");
        });
        assertEquals(BookService.ERR_BOOK_NOT_FOUND, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getDataForValidBooks")
    void Given_validBookReference_When_RetrieveBook_Then_Return_Book(String bookReference, String book) throws BookNotFoundException {
        assertEquals(book, bookService.retrieveBook(bookReference).toString());
    }

    @ParameterizedTest
    @MethodSource("getDataForInvalidBooks")
    void Given_InvalidBookReference_When_GetSummary_Then_Exception(String bookReference) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBookSummary(bookReference);
        });
        assertEquals(BookService.ERR_INVALID_BOOK_REFERENCE, exception.getMessage());
    }

    @Test
    void Given_BookReferenceDoesNotExist_When_GetSummary_Then_BookNotFoundException() {
        Exception exception = assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookSummary("BOOK-999");
        });
        assertEquals(BookService.ERR_BOOK_NOT_FOUND, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getDataForValidBookSummary")
    void Given_validBookReference_When_GetSummary_Then_Return_Book(String bookReference, String book) throws BookNotFoundException {
        assertEquals(book, bookService.getBookSummary(bookReference));
    }

}