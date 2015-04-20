package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Database entry.
 */
@Entity
public class Author extends StandardDBEntity {

    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthor", 
            joinColumns = { @JoinColumn(name = "Book_ID") }, 
            inverseJoinColumns = {@JoinColumn(name = "Author_ID")})
    private Set<Book> books = new HashSet<>(0);

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
