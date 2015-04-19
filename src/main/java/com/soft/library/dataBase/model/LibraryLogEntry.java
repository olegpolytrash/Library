package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.sql.Date;

/**
 * Database entry.
 */
@Entity
public class LibraryLogEntry {
    @Id @GeneratedValue
    private Integer id;
    
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Book book;
    
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Reader reader;
    
    @Column(nullable = false)
    private Date taken;
    
    @Column(nullable = false)
    private Date returned;

    public LibraryLogEntry() {
    }

    public LibraryLogEntry(Book book, Reader reader, Date taken, Date returned) {
        this.book = book;
        this.reader = reader;
        this.taken = taken;
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "LibraryLogEntry{" +
                "id=" + id +
                ", books=" + book +
                ", readers=" + reader +
                ", taken=" + taken +
                ", returned=" + returned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        LibraryLogEntry that = (LibraryLogEntry) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
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
        this.taken = taken;
    }

    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        this.returned = returned;
    }
}
