import java.util.*;
public class PhoneBook {
    public static Map<String, String> mapPhoneBook = new TreeMap<>();
    public static void main(String[] args) {
        System.out.println("Введите номер,имя или команду:");
        while (true){
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();

            if (text.toLowerCase().startsWith("list")) {
                System.out.println(getAllContacts());
            }
            addContactByPhone(text);
            addContactByName(text);
        }
    }
    public static void addContactByPhone(String phone) {
        Scanner scanner = new Scanner(System.in);
        if (phone.matches("[\\d]{11}")) {
            if (mapPhoneBook.containsKey(phone)) {
                System.out.println(phone+" "+mapPhoneBook.get(phone));
            } else {
                System.out.println("Такого номера нет в телефонной книге.Введите имя абонента для номера "+phone);
                String name = scanner.nextLine();
                mapPhoneBook.put(phone, name);
                System.out.println("Контакт сохранен");
            }
        }
    }
    public static Set<String> getAllContacts() {

        Set<String> setPhoneBook = new TreeSet<>();

        for (String key : mapPhoneBook.keySet()) {
            setPhoneBook.add(mapPhoneBook.get(key) + " - " + key);
        }
        return setPhoneBook;
    }
    public static void addContactByName(String name) {
        Scanner scanner = new Scanner(System.in);
        if (name.matches("[А-Яа-я]+")) {
            if (mapPhoneBook.containsValue(name)) {
                for (String tel : mapPhoneBook.keySet()) {
                    if (mapPhoneBook.get(tel).equals(name)) {
                        System.out.println(tel+" "+name);
                    }
                }
            } else {
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента "+name+":");
                String phone = scanner.nextLine();
                mapPhoneBook.put(phone, name);
                System.out.println("Контакт сохранен");
            }
        }
    }
}
