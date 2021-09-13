package Controller;

import Controller.ContactManagement;
import Model.Contact;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindContactFunctions {
    private ContactManagement contactManagement = new ContactManagement();
    private static InputValidator validator = new InputValidator();
    public static Scanner scanner = new Scanner(System.in);

    public static void findByNumber(){
        System.out.println("Input number");
        String number = scanner.nextLine();
        while (!validator.isValidFindNumber(number)){
            number = scanner.nextLine();
        }

        List<Contact> contactList = ContactManagement.getContactList();
        Pattern pattern = Pattern.compile(number);
        for (Contact contact:contactList){
            String phoneNumber = contact.getPhoneNumber();
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.find(0)){
                System.out.println(contact);
            }
        }
    }
}
