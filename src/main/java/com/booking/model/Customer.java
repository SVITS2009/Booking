package com.booking.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private String emailId;
    private String contactNumber;

    private Integer tableSize;
    private LocalDate bookingDate;
    private LocalTime bookingTime;

    public Customer(String firstName, String lastName, String emailId,
                    String contactNumber, Integer tableSize, LocalDate bookingDate, LocalTime bookingTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.tableSize = tableSize;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", tableSize=" + tableSize +
                ", bookingDate=" + bookingDate +
                ", bookingTime=" + bookingTime +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getTableSize() {
        return tableSize;
    }

    public void setTableSize(Integer tableSize) {
        this.tableSize = tableSize;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(emailId, customer.emailId) && contactNumber.equals(customer.contactNumber) && tableSize.equals(customer.tableSize) && Objects.equals(bookingDate, customer.bookingDate) && Objects.equals(bookingTime, customer.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, emailId, contactNumber, tableSize, bookingDate, bookingTime);
    }
}
