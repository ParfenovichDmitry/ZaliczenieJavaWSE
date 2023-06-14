import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberManager {
    private static final String FILE_NAME = "telefonbook.csv";
    private final Map<String, String> telefonBook;

    public NumberManager() {
        telefonBook = new HashMap<>();
        loadTelefonBook();
    }

    public void addContact(String name, String phoneNumber) {
        if (telefonBook.containsKey(name)) {
            System.out.println("Kontakt o podanej nazwie już istnieje.");
            return;
        }

        telefonBook.put(name, phoneNumber);
        saveTelefonBook();
        System.out.println("Kontakt dodany: " + name + " - " + phoneNumber);
    }

    public void searchByName(String name) {
        List<String> matchingContacts = new ArrayList<>();

        for (Map.Entry<String, String> entry : telefonBook.entrySet()) {
            if (entry.getKey().contains(name)) {
                matchingContacts.add(entry.getKey() + " - " + entry.getValue());
            }
        }

        if (matchingContacts.isEmpty()) {
            System.out.println("Brak pasujących kontaktów.");
        } else {
            System.out.println("Pasujące kontakty:");
            for (String contact : matchingContacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchByPhoneNumber(String phoneNumber) {
        List<String> matchingContacts = new ArrayList<>();

        for (Map.Entry<String, String> entry : telefonBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                matchingContacts.add(entry.getKey() + " - " + entry.getValue());
            }
        }

        if (matchingContacts.isEmpty()) {
            System.out.println("Brak pasujących kontaktów.");
        } else {
            System.out.println("Pasujące kontakty:");
            for (String contact : matchingContacts) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact(String name) {
        if (!telefonBook.containsKey(name)) {
            System.out.println("Kontakt o podanej nazwie nie istnieje.");
            return;
        }

        telefonBook.remove(name);
        saveTelefonBook();
        System.out.println("Kontakt usunięty: " + name);
    }

    private void loadTelefonBook() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                telefonBook.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania książki telefonicznej.");
        }
    }

    private void saveTelefonBook() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : telefonBook.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania książki telefonicznej.");
        }
    }
}

