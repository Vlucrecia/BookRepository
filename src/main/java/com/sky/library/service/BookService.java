package com.sky.library.service;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

import com.sky.library.dao.Book;
import com.sky.library.exception.BookNotFoundException;

public interface BookService {
    String BOOK_REFIX = "BOOK-";

    int SUMMARY_WORD_LIMIT = 9;

    String ELLIPSIS = "...";

    String ERR_INVALID_BOOK_REFERENCE = "Invalid Book Reference, it must begin with BOOK-";

    String ERR_BOOK_NOT_FOUND = "Book Not Found";

    /**
     *
     * @param bookReference
     *          Given reference of the book
     * @return
     *           Return Book object , if it exists
     * @throws BookNotFoundException
     *          Throw Exception, if book is not found
     */
    Book retrieveBook(String bookReference) throws BookNotFoundException;

    /**
     *
     * @param bookReference
     *          Given reference of the book
     * @return
     *          Returns the summary of the book
     * @throws BookNotFoundException
     *          Throw Exception, if book is not found
     */
    String getBookSummary(String bookReference) throws BookNotFoundException;
}
