package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Database entry.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames={"name", "surname"})
})
public class Reader extends StandardDBEntity  {
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String surname;
    
    private String mobilePhone;
    
    private String address;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Reader() {
    }

    public Reader(String name, String surname, String mobilePhone, String address, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
