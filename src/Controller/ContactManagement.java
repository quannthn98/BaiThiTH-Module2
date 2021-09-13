package Controller;

import Model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManagement {
    private static List<Contact> contactList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public ContactManagement() {
    }

    public static List<Contact> getContactList() {
        return contactList;
    }

    public static void setContactList(List<Contact> contactList) {
        ContactManagement.contactList = contactList;
    }

    public void showContactList(){
        int count = 0;
        for (Contact contact : contactList) {
            System.out.println(contact);
            count++;
            if (count == 5) {
                count = 0;
                scanner.nextLine();
            }
        }
    }

    public void addNewContact(Contact contact){
        contactList.add(contact);
    }

    public void updateContact(Contact contact, int index){
        contactList.remove(index);
        contactList.add(contact);
    }

    public int findContactByPhoneNumber(String phoneNumber){
        int index = -1;
        for (int i = 0; i < contactList.size(); i++) {
            if (phoneNumber.equals(contactList.get(i).getPhoneNumber())){
                index = i;
                break;
            }
        }
        return index;
    }

    public Contact getContactByIndex(int index){
        return contactList.get(index);
    }

    public void removeContact(int index){
        contactList.remove(index);
    }
}
