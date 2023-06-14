import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberManager telefonBookManager = new NumberManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Dodaj nowy kontakt");
            System.out.println("2. Wyszukaj po części nazwy");
            System.out.println("3. Wyszukaj po części numeru telefonu");
            System.out.println("4. Usuń kontakt");
            System.out.println("0. Zakończ");

            int choice = sc.nextInt();
            sc.nextLine(); // konsumowanie znaku nowej linii po nextInt()

            switch (choice) {
                case 1 -> {
                    System.out.println("Podaj nazwę kontaktu:");
                    String name = sc.nextLine();
                    System.out.println("Podaj numer telefonu:");
                    String phoneNumber = sc.nextLine();
                    telefonBookManager.addContact(name, phoneNumber);
                }
                case 2 -> {
                    System.out.println("Podaj część nazwy:");
                    String partialName = sc.nextLine();
                    telefonBookManager.searchByName(partialName);
                }
                case 3 -> {
                    System.out.println("Podaj część numeru telefonu:");
                    String partialPhoneNumber = sc.nextLine();
                    telefonBookManager.searchByPhoneNumber(partialPhoneNumber);
                }
                case 4 -> {
                    System.out.println("Podaj nazwę kontaktu do usunięcia:");
                    String contactName = sc.nextLine();
                    telefonBookManager.deleteContact(contactName);
                }
                case 0 -> {
                    System.out.println("Zamykanie aplikacji...");
                    System.exit(0);
                }
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        }
    }
}