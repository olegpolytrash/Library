package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Database entry that represents the library.
 */
@Entity
public class Library extends StandardEntity {
    /**
     * The books that is in the library.
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Book book;

    /**
     * Publisher of the book.
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Publisher publisher;

    /**
     * The book's pages.
     */
    private Integer pages;

    /**
     * Year when he book was published.
     */
    @Column(nullable = false)
    private Integer year;

    /**
     * Year when he book was published.
     */
    @Column(nullable = false)
    private Integer quantity;

    public Library() {
    }

    public Library(Integer pages, Integer year, Integer quantity) {
        this.setPages(pages);
        this.setYear(year);
        this.setQuantity(quantity);
    }

    public Library(Integer pages, Integer year, Integer quantity, Book book, Publisher publisher) {
        this.setPages(pages);
        this.setYear(year);
        this.setQuantity(quantity);
        this.setBook(book);
        this.setPublisher(publisher);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Library)) return false;

        Library library = (Library) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getBook(), library.getBook())
                .append(getPublisher(), library.getPublisher())
                .append(getPages(), library.getPages())
                .append(getYear(), library.getYear())
                .append(getQuantity(), library.getQuantity())
                .isEquals();
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
