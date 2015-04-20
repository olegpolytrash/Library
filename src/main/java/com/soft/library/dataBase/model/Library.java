package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Objects;

/**
 * Database entry.
 */
@Entity
public class Library extends StandardDBEntity  {
    private Integer pages;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer quantity;
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Book book;
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Publisher publisher;

    public Library() {
    }

    public Library(Integer pages, Integer year, Integer quantity) {
        this.pages = pages;
        this.year = year;
        this.quantity = quantity;
    }

    public Library(Integer pages, Integer year, Integer quantity, Book book, Publisher publisher) {
        this.pages = pages;
        this.year = year;
        this.quantity = quantity;
        this.book = book;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + getId() +
                ", pages=" + pages +
                ", year=" + year +
                ", quantity=" + quantity +
                ", book=" + book +
                ", publisher=" + publisher +
                '}';
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
