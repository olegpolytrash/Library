package com.soft.library.dataBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Database entry that represents a reader - the library's client.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames={"name", "surname"})
})
public class Reader extends StandardEntity {
    /**
     * The reader's name
     */
    @Column(nullable = false)
    private String name;

    /**
     * The reader's surname
     */
    @Column(nullable = false)
    private String surname;

    /**
     * The reader's mobile phone
     */
    private String mobilePhone;

    /**
     * The reader's address
     */
    private String address;

    /**
     * The reader's birth date
     */
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Reader() {
    }

    public Reader(String name, String surname, String mobilePhone, String address, Date birthDate) {
        this.setName(name);
        this.setSurname(surname);
        this.setMobilePhone(mobilePhone);
        this.setAddress(address);
        this.setBirthDate(birthDate);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Reader)) return false;

        Reader reader = (Reader) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getName(), reader.getName())
                .append(getSurname(), reader.getSurname())
                .append(getMobilePhone(), reader.getMobilePhone())
                .append(getAddress(), reader.getAddress())
                .append(getBirthDate(), reader.getBirthDate())
                .isEquals();
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
        this.birthDate = getCorrectDate(birthDate);
    }

    private Date getCorrectDate(Date date) {
        Calendar originalDate = Calendar.getInstance();
        originalDate.setTime(date);

        Calendar correctDate = Calendar.getInstance();
        correctDate.clear();
        correctDate.set(Calendar.YEAR, originalDate.get(Calendar.YEAR));
        correctDate.set(Calendar.MONTH, originalDate.get(Calendar.MONTH));
        correctDate.set(Calendar.DAY_OF_MONTH, originalDate.get(Calendar.DAY_OF_MONTH));

        return correctDate.getTime();
    }
}
