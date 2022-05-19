package com.imit.task.seventh;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private static final long serialVersionUID = 2;
    private String firstname;
    private String surname;
    private String lastName;
    private Date date;

    Person(){}
    public Person(String firstname, String surname, String lastName, Date date) {
        this.setFirstname(firstname);
        this.setSurname(surname);
        this.setLastName(lastName);
        this.date = date;
    }

    public Person(Person person) {
        this(person.getFirstname(), person.getSurname(), person.getLastName(), person.getDate());
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname == null) throw new IllegalArgumentException("Firstname must be not null!");
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null) throw new IllegalArgumentException("Surname must be not null!");
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName must be not null!");
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname)
                && Objects.equals(surname, person.surname)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(date, person.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, surname, lastName, date);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                '}';
    }
}
