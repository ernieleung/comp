import java.util.*;
import java.io.*;

public class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String username, String displayName) {
        contacts.add(new Contact(username, displayName));
        saveToCSV("contacts.csv");
    }

    public void removeContact(String username) {
        contacts.removeIf(c -> c.getUsername().equals(username));
        saveToCSV("contacts.csv");
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts.");
        } else {
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }

    public void saveToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Contact c : contacts) {
                writer.println(c.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filename) {
        File file = new File(filename);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Contact c = Contact.fromCSV(scanner.nextLine());
                if (c != null) {
                    contacts.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}
