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
public class Author {
    @Id @GeneratedValue
    private Integer id;
    
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return new EqualsBuilder()
                .append(getId(), author.getId())
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
