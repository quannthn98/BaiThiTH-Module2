package Controller;

import Controller.ContactManagement;
import Model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    public static final String filePath = "src/contacts.txt";
    public static ContactManagement contactManagement = new ContactManagement();
    public static void writeToFile() {
        try {
            List<Contact> contactList = ContactManagement.getContactList();
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contactList);
            oos.close();
            fos.close();
        } catch (IOException e) {
        }
    }

    public static void readDataFromFile() {
        List<Contact> contactList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contactList = (List<Contact>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
        }
        ContactManagement.setContactList(contactList);
    }
}
