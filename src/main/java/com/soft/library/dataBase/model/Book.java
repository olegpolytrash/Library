package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Database entry.
 */
@Entity
public class Book {
    @Id @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthor", 
            joinColumns = {@JoinColumn(name = "Author_ID")}, 
            inverseJoinColumns = {@JoinColumn(name = "Book_ID")})
    private Set<Author> authors = new HashSet<>(0);

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new EqualsBuilder()
                .append(getId(), book.getId())
                .isEquals();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
