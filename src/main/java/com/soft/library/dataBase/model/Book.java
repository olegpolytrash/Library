package com.soft.library.dataBase.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Database entry that represents a book.
 */
@Entity
public class Book extends StandardEntity {
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthor", 
            joinColumns = {@JoinColumn(name = "Author_ID")}, 
            inverseJoinColumns = {@JoinColumn(name = "Book_ID")})
    private Set<Author> authors = new HashSet<>(0);

    public Book() {
    }

    public Book(String name, Set<Author> authors) {
        this.name = name;
        this.authors = authors;
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                //", authors=" + authors +
                '}';
    }

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
