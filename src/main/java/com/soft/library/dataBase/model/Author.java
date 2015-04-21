package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Database entry that represents an author of a book.
 */
@Entity
public class Author extends StandardEntity {
    /**
     * The author's name
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Set of books that the author wrote
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthor",
            joinColumns = { @JoinColumn(name = "Book_ID") },
            inverseJoinColumns = {@JoinColumn(name = "Author_ID")})
    private Set<Book> books = new HashSet<>(0);

    public Author() {
    }

    public Author(String name) {
        this.setName(name);
    }

    public Author(String name, Set<Book> books) {
        this.setName(name);
        this.setBooks(books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getName(), author.getName())
                .append(getBooks().size(), author.getBooks().size())
                .isEquals();
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
