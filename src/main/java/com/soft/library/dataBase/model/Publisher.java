package com.soft.library.dataBase.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Database entry.
 */
@Entity
public class Publisher extends StandardEntity {
    @Column(nullable = false, unique = true)
    private String name;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
