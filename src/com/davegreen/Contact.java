package com.davegreen;

public class Contact
{
    private String name;
    private int phoneNumber;
    
    public Contact(String name, int phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public static Contact createContact(String name, int phoneNumber)
    {
        return new Contact(name, phoneNumber);
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getPhoneNumber()
    {
        return phoneNumber;
    }
}
