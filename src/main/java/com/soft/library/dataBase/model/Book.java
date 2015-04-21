package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Database entry that represents a book.
 */
@Entity
public class Book extends StandardEntity {
    /**
     * The book's name
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Authors that wrote this book
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthor",
            joinColumns = {@JoinColumn(name = "Author_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Book_ID")})
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String name) {
        this.setName(name);
    }

    public Book(String name, Set<Author> authors) {
        this.setName(name);
        this.setAuthors(authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                //", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getName(), book.getName())
                .append(getAuthors().size(), book.getAuthors().size())
                .isEquals();
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
