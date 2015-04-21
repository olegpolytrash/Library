package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Database entry that represents a publisher.
 */
@Entity
public class Publisher extends StandardEntity {
    /**
     * The publisher's name
     */
    @Column(nullable = false, unique = true)
    private String name;

    public Publisher() {
    }

    public Publisher(String name) {
        this.setName(name);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Publisher)) return false;

        Publisher publisher = (Publisher) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getName(), publisher.getName())
                .isEquals();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
