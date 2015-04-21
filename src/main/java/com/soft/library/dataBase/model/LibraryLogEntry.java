package com.soft.library.dataBase.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Database entry that represents library log entry.
 */
@Entity
public class LibraryLogEntry extends StandardEntity {
    /**
     * The book that was taken by the reader
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Book book;

    /**
     * The reader who took some book from the library
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Reader reader;

    /**
     * The date when the book was taken from the library
     * by the reader
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date taken;

    /**
     * The date when the book was returned from the library
     * by the reader
     */
    @Temporal(TemporalType.DATE)
    private Date returned;

    public LibraryLogEntry() {
    }

    public LibraryLogEntry(Book book, Reader reader, Date taken, Date returned) {
        this.setBook(book);
        this.setReader(reader);
        this.setTaken(taken);
        this.setReturned(returned);
    }

    @Override
    public String toString() {
        return "LibraryLogEntry{" +
                "id=" + getId() +
                ", books=" + book +
                ", readers=" + reader +
                ", taken=" + taken +
                ", returned=" + returned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof LibraryLogEntry)) return false;

        LibraryLogEntry that = (LibraryLogEntry) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getBook(), that.getBook())
                .append(getReader(), that.getReader())
                .append(getTaken(), that.getTaken())
                .append(getReturned(), that.getReturned())
                .isEquals();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getTaken() {
        return taken;
    }

    public void setTaken(Date taken) {
        if (taken == null) {
            this.taken = null;
        } else {
            this.taken = getCorrectDate(taken);
        }
    }

    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        if (returned == null) {
            this.returned = null;
        } else {
            this.returned = getCorrectDate(returned);
        }
    }

    private Date getCorrectDate(Date date) {
        Calendar originalDate = Calendar.getInstance();
        originalDate.setTime(date);

        Calendar correctDate = Calendar.getInstance();
        correctDate.clear();
        correctDate.set(Calendar.YEAR, originalDate.get(Calendar.YEAR));
        correctDate.set(Calendar.MONTH, originalDate.get(Calendar.MONTH));
        correctDate.set(Calendar.DAY_OF_MONTH, originalDate.get(Calendar.DAY_OF_MONTH));

        return correctDate.getTime();
    }
}
