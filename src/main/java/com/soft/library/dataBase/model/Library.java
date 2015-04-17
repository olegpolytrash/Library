package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Database entry.
 */
@Entity
public class Library {
    @Id @GeneratedValue
    private Integer id;
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

    public Library(int pages, int year, int quantity) {
        this.pages = pages;
        this.year = year;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
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

        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        return new EqualsBuilder()
                .append(getId(), library.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
