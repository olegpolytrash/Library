package com.soft.library.dataBase.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Database entry.
 */
@Entity
public class LibraryLogEntry extends StandardEntity {
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Book book;
    
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Reader reader;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date taken;

    @Temporal(TemporalType.DATE)
    private Date returned;

    public LibraryLogEntry() {
    }

    public LibraryLogEntry(Book book, Reader reader, Date taken, Date returned) {
        this.book = book;
        this.reader = reader;
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
            this.taken = new Date(taken.getYear(), taken.getMonth(), taken.getDate());
        }
    }

    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        if (returned == null) {
            this.returned = null;
        } else {
            this.returned = new Date(returned.getYear(), returned.getMonth(), returned.getDate());
        }
    }
}
