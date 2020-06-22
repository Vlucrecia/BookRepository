package com.sky.library.dao;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

public class Book {
    private String reference;
    private String title;
    private String review;

    public Book(String reference, String title, String description) {
        this.reference = reference;
        this.title = title;
        this.review = description;
    }

    public String getReview() {
        return review;
    }

    public String getReference() {
        return reference;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " Book";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!reference.equals(book.reference)) return false;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        int result = reference.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }
}
