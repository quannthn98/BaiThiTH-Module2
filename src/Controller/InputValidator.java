package Controller;

import Controller.ContactManagement;
import Model.Contact;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private final String EMAILREGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private final String PHONEREGEX = "^[0][1-9]([0-9]{8})$";
    private final String NUMBERTOFINE = "^[0-9]{2,}$";


    public boolean isEmailValidated(String email){
        Pattern pattern = Pattern.compile(EMAILREGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()){
            System.out.println("Email format is not valid, example: 'abcxyz@gmail.com' ");
        }
        return matcher.matches();
    }

    public boolean isPhoneValidated(String phoneNumber){
        Pattern pattern = Pattern.compile(PHONEREGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()){
            System.out.println("Phone number must have 10 numbers and start with 0");
        }
        return matcher.matches();
    }

    public boolean isPhoneNumberDuplicated(String phoneNumber){
        List<Contact> contactList = ContactManagement.getContactList();
        for (Contact contact: contactList){
            if (contact.getPhoneNumber().equals(phoneNumber)){
                System.out.println("This number is already in your Model.Contact list");
                return true;
            }
        }
        return false;
    }

    public boolean isValidFindNumber(String findNumber){
        Pattern pattern = Pattern.compile(NUMBERTOFINE);
        Matcher matcher = pattern.matcher(findNumber);
        if (!matcher.matches()){
            System.out.println("Please input atleast 2 number to find");
        }
        return matcher.matches();
    }
}
