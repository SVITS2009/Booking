package com.booking.dto;

public class BookingRequest {
    private String firstName;
    private String lastName;
    private String emailId;
    private String contactNumber;

    private int tableSize;

    public BookingRequest(String firstName, String lastName, String emailId,
                          String contactNumber, Integer tableSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.tableSize = tableSize;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", tableSize=" + tableSize +
                '}';
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmailId() {
        return emailId;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public int getTableSize() {
        return tableSize;
    }
}
