package com.sky.library.service;

import com.sky.library.dao.Book;
import com.sky.library.exception.BookNotFoundException;
import com.sky.library.repository.BookRepository;
import com.sky.library.util.WordProcessor;
import org.apache.log4j.Logger;

import static com.sky.library.util.WordProcessor.*;

public class BookServiceImpl implements BookService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class);

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book retrieveBook(String bookReference) throws BookNotFoundException {
        log.info("Get Book details for book reference, "+  bookReference);
        validateBookReference(bookReference);

        Book book = bookRepository.retrieveBook(bookReference);

        if (null == book) {
            throw new BookNotFoundException(ERR_BOOK_NOT_FOUND);
        }
        return book;
    }


    @Override
    public String getBookSummary(String bookReference) throws BookNotFoundException {
        log.info("Get Book Summary for book reference, "+  bookReference);
        Book book = retrieveBook(bookReference);
        StringBuilder sb = new StringBuilder(OPEN_BRACKETS)
                .append(book.getReference())
                .append(CLOSE_BRACKETS)
                .append(SPACE)
                .append(book.getTitle())
                .append(SPACE)
                .append(HYPHEN)
                .append(SPACE);

        String ss = WordProcessor.getFirstNWordsFromString(book.getReview(), SUMMARY_WORD_LIMIT);

        sb.append(ss);
        if (!ss.equals(book.getReview())) {
            sb.append(ELLIPSIS);
        }
        return sb.toString();
    }

    /**
     * Validate BookReference
     * @param bookReference
     *      Given reference of the book
     */
    private void validateBookReference(String bookReference) {
        if ((null == bookReference) || (bookReference.trim().length() == 0) || (!bookReference.startsWith(BOOK_REFIX))) {
            throw new IllegalArgumentException(ERR_INVALID_BOOK_REFERENCE);
        }
    }


}
