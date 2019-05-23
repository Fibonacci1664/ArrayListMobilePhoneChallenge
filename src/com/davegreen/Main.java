package com.davegreen;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone(528644);

    public static void main(String[] args)
    {
	   boolean quit = false;
	   startPhone();
	   printAction();
	   
	   while(!quit)
       {
           System.out.println("\n> Enter action: (Press 6 to print options again).");
           int action = scanner.nextInt();
           scanner.nextLine();
           
           switch (action)
           {
               case 0:
                   System.out.println("\n Shutting Down.....");
                   quit = true;
                   break;
               case 1:
                   mobilePhone.printContacts();
                   break;
               case 2:
                   addNewContact();
                   break;
               case 3:
                   updateContact();
                   break;
               case 4:
                   removeContact();
                   break;
               case 5:
                   queryContact();
                   break;
               case 6:
                   printAction();
                   break;
               default:
                   System.out.println("Invalid input");
           }
       }
    }
    
    private static void addNewContact()
    {
        System.out.println("Enter new contact new: ");
        String name = scanner.nextLine();
    
        System.out.println("Enter phone number: ");
        int phoneNumber = scanner.nextInt();
        
        Contact newContact = Contact.createContact(name, phoneNumber);
        
        if (mobilePhone.addNewContact(newContact))
        {
            System.out.println("New contact has been added: name = " + name + ", phone = " + phoneNumber);
        }
        else
        {
            System.out.println("Cannot add, " + name + " as contact already exists on file.");
        }
    }
    
    private static void updateContact()
    {
        System.out.println("Enter the name of the contact you wish to update: ");
        String name = scanner.nextLine();
        
        Contact existingContactRecord = mobilePhone.queryContact(name);
        
        if(existingContactRecord == null)
        {
            System.out.println("Contact not found.");
            return;
        }
    
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
    
        System.out.println("Enter new contact phone number: ");
        int newNumber = scanner.nextInt();
        
        Contact newContact = Contact.createContact(newName, newNumber);
        
        if(mobilePhone.updateContact(existingContactRecord, newContact))
        {
            System.out.println("Successfully updated record.");
        }
        else
        {
            System.out.println("Error updating record.");
        }
    }
    
    private static void removeContact()
    {
        System.out.println("Enter the name of the contact you wish to remove: ");
        String name = scanner.nextLine();
    
        Contact existingContactRecord = mobilePhone.queryContact(name);
    
        if (existingContactRecord == null)
        {
            System.out.println("Contact not found.");
            return;
        }
        
        if (mobilePhone.removeContact(existingContactRecord))
        {
            System.out.println("Successfully deleted contact.");
        }
        else
        {
            System.out.println("Error deleting contact.");
        }
    }
    
    private static void queryContact()
    {
        System.out.println("Enter the name of the contact you wish to search for: ");
        String name = scanner.nextLine();
        
        Contact existingContactRecord = mobilePhone.queryContact(name);
        
        if (existingContactRecord == null)
        {
            System.out.println("Contact not found.");
            return;
        }
    
        System.out.println("Name: " + existingContactRecord.getName() + "'s phone number is " + existingContactRecord.getPhoneNumber());
    }
    
    private static void startPhone()
    {
        System.out.println("Starting Phone.....");
    }
    
    private static void printAction()
    {
        System.out.println("\n > Available Options: " +
                "\n\t 0 - Quit Application." +
                "\n\t 1 - Print Contacts." +
                "\n\t 2 - Add a New Contact." +
                "\n\t 3 - Update an Existing Contact." +
                "\n\t 4 - Remove a Contact." +
                "\n\t 5 - Search/Find Contacts." +
                "\n\t 6 - Print Available Options.");
    
        System.out.println("> Please Choose:");
    }
}
