import java.util.*;

public class PhoneBookSet {
    private static final Map<String, TreeSet<String>> mapPhoneBook = new TreeMap<>();
    private static final String NAME_REGEX = "[А-Яа-я]+";
    private static final String NUMBER_REGEX = "[\\d]{11}";

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите номер,имя или команду:");
            String text = new Scanner(System.in).nextLine();
            if (text.toLowerCase().startsWith("list")) {
                printAllContacts();
            } else if (text.toLowerCase().matches(NUMBER_REGEX)) {
                addContactByPhone(text);
            } else if (text.toLowerCase().matches(NAME_REGEX)) {
                addContactByName(text);
            } else if(text.toLowerCase().matches("удалить "+NUMBER_REGEX)){
                removeContactByPhone(text.split(" ",2)[1]);
            } else if(text.toLowerCase().matches("удалить "+NAME_REGEX)){
                removeContactByName(text.split(" ",2)[1]);
            } else if (text.toLowerCase().matches("изменить "+NAME_REGEX+" "+NAME_REGEX)){
                String[] s = text.split(" ", 3);
                editContact(s[1],s[2]);
            } else {
                System.out.println("Неверный формат ввода");
                return;
            }
        }
    }

    public static void addContactByPhone(String phone) {
        if (checkPhoneDuplicat(phone)) {
            return;
        }

        System.out.println("Такого номера нет в телефонной книге.Введите имя контакта для номера " + phone);
        String name = new Scanner(System.in).nextLine();
        if (name.matches(NAME_REGEX)) {
            if (mapPhoneBook.containsKey(name)) {
                mapPhoneBook.get(name).add(phone);
            } else {
                mapPhoneBook.put(name, new TreeSet<>());
                mapPhoneBook.get(name).add(phone);
            }
            System.out.println("Контакт сохранен");
        } else {
            System.out.println("Неправильно введено имя");
        }
    }

    private static boolean checkPhoneDuplicat(String phone) {
        for (Map.Entry<String, TreeSet<String>> entry : mapPhoneBook.entrySet()) {
            if (entry.getValue() != null && entry.getValue().contains(phone)) {
                System.out.println("Такой номер уже есть у другого контакта");
                System.out.println(entry.getKey());
                System.out.println(phone);
                return true;
            }
        }
        return false;
    }


    public static void addContactByName(String name) {
        if (mapPhoneBook.containsKey(name)) {
            System.out.print("Найден контакт с таким именем: ");
            for (String s : mapPhoneBook.get(name)) {
                System.out.println(s + " ");
            }
            return;
        }

        System.out.println("Такого имени в телефонной книге нет.\n" + "Введите номер телефона для контакта " + name + ":");
        String phone = new Scanner(System.in).nextLine();
        if (checkPhoneDuplicat(phone)) {
            return;
        }

        if (phone.matches(NUMBER_REGEX)) {
            mapPhoneBook.put(name, new TreeSet<>());
            mapPhoneBook.get(name).add(phone);
            System.out.println("Контакт сохранен");
        } else {
            System.out.println("Неправильно введен номер");
        }
    }
    public static void editContact(String oldName,String newName) {
        if (!mapPhoneBook.containsKey(oldName)) {
            System.out.println("Изменяемый контакт не найден");
            return;
        }
        if(mapPhoneBook.containsKey(newName)){
            System.out.println("Такое имя уже существует у другого контакта");
            return;
        }
        TreeSet<String> phons = mapPhoneBook.get(oldName);
        mapPhoneBook.remove(oldName);
        mapPhoneBook.put(newName,phons);
        System.out.println("Контакт изменен");
    }
    public static void printAllContacts() {
        if (mapPhoneBook.isEmpty()) {
            System.out.println("Книга контактов пуста");
            return;
        }
        mapPhoneBook.forEach((key, value) -> System.out.println(key + " - " + value));
    }
    public static void removeContactByName(String name){
        if (!mapPhoneBook.containsKey(name)) {
            System.out.println("Такого контакта нет");
            return;
        }
        mapPhoneBook.remove(name);
        System.out.println("Контакт успешно удален");
    }
    public static void removeContactByPhone(String phone){
        boolean flag = false;
        for (Map.Entry<String, TreeSet<String>> entry : mapPhoneBook.entrySet()) {
            if (entry.getValue() != null && entry.getValue().contains(phone)) {
                entry.getValue().remove(phone);
                System.out.println("Номер из контакта удален");
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Такого номера нет в списке контактов");
        }
    }
    }




