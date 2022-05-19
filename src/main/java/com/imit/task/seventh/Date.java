package com.imit.task.seventh;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException();
        this.month = month;
    }

    private Date(){}
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if ((year % 100 == 0 && year % 400 == 0 || year % 4 == 0 && year % 100 != 0)  && (day < 1 || day > 366)) throw new IllegalArgumentException();
        else {
            if (day < 1 || day > 365) throw new IllegalArgumentException();
        }
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return getYear() == date.getYear() && getMonth() == date.getMonth() && getDay() == date.getDay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getMonth(), getDay());
    }

    @Override
    public String toString() {
        return "Date: " + day + " " + month + " " + year;
    }
}
