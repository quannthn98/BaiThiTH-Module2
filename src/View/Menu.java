package View;

import Controller.ContactManagement;
import Controller.DataHandler;
import Controller.FindContactFunctions;
import Controller.InputValidator;
import Model.Contact;

import java.util.Scanner;

public class Menu {

    public Scanner scanner = new Scanner(System.in);
    public InputValidator validator = new InputValidator();
    private ContactManagement contactManagement = new ContactManagement();


    public void run() {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    contactManagement.showContactList();
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
                    FindContactFunctions.findByNumber();
                    break;
                case 6:
                    readDateFromFile();
                    break;
                case 7:
                    DataHandler.writeToFile();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (option != 0);
    }

    private void readDateFromFile() {
        System.out.println("All current contacts will be replaced, do you want to continue? (Y/N)");
        String confirm = scanner.nextLine();
        switch (confirm){
            case "Y":
                DataHandler.readDataFromFile();
                break;
            case "N":
                run();
                break;
        }
    }

    private void removeContact() {
        int index = getIndex();
        if (index == -1) {
            System.out.println("Can not find this contact, please try again");
            return;
        }
        Contact contact = contactManagement.getContactByIndex(index);
        System.out.println(contact);
        System.out.println("Do you want to delete this contact? (press Y/N or any key to exit)");
        String confirm = scanner.nextLine();
        switch (confirm) {
            case "Y":
                contactManagement.removeContact(index);
                System.out.println("Remove contact successfully");
            case "N":
            default:
                run();
                break;
        }
    }

    private void updateContact() {
        int index = getIndex();
        if (index == -1) {
            System.out.println("can not find this contact, please try again");
            return;
        }
        Contact updatedContact = getContactInfor();
        contactManagement.updateContact(updatedContact, index);
        System.out.println("Update contact successfully");
    }

    private void addNewContact() {
        Contact newContact = getContactInfor();
        contactManagement.addNewContact(newContact);
        System.out.println("Add new contact successfully");
    }

    private int getIndex() {
        System.out.println("Please input phone number ");
        String phoneNumber = scanner.nextLine();
        int index = contactManagement.findContactByPhoneNumber(phoneNumber);
        return index;
    }

    public Contact getContactInfor() {
        String phoneNumber;
        System.out.println("Please input phone Number");
        do {
            phoneNumber = scanner.nextLine();
        } while (!validator.isPhoneValidated(phoneNumber) || validator.isPhoneNumberDuplicated(phoneNumber));

        System.out.println("Please input contact Name");
        String name = scanner.nextLine();
        while (name.equals("")) {
            System.out.println("This is required field");
            name = scanner.nextLine();
        }

        System.out.println("Please input contact Email");
        String email;
        do {
            email = scanner.nextLine();
        } while (!validator.isEmailValidated(email));
        System.out.println("PLease input contact address (Optional)");
        String address = scanner.nextLine();

        return new Contact(name, address, email, phoneNumber);
    }

    public void menu() {
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tim kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng");
    }
}
