/*import java.util.*;
public class PhoneBook {
    public static Map<String, String> mapPhoneBook = new TreeMap<>();
    private static final String NAME_REGEX = "[А-Яа-я]+";
    private static final String NUMBER_REGEX = "[\\d]{11}";
    public static void main(String[] args) {

        while (true){
            System.out.println("Введите номер,имя или команду:");
            String text = new Scanner(System.in).nextLine();
            if (text.toLowerCase().startsWith("list")) {
               printAllContacts();
            }

            else if (text.toLowerCase().matches(NUMBER_REGEX)){
                addContactByPhone(text);
            }

            else if (text.toLowerCase().matches(NAME_REGEX)){
                addContactByName(text);
            }else{
                System.out.println("Неверный формат ввода");
                  return;
            }
        }
    }
    public static void addContactByPhone(String phone) {

            if (mapPhoneBook.containsKey(phone)) {
                System.out.println(phone+" "+mapPhoneBook.get(phone));
                return;
            }
                System.out.println("Такого номера нет в телефонной книге.Введите имя абонента для номера "+phone);
                String name = new Scanner(System.in).nextLine();
                if(name.matches(NAME_REGEX)){
                    mapPhoneBook.put(phone, name);
                    System.out.println("Контакт сохранен");
                }else {
                    System.out.println("Неправильно введено имя");
                }

    }

    public static void addContactByName(String name) {

            if (mapPhoneBook.containsValue(name)) {
                System.out.print(name + ": ");
                for (String tel : mapPhoneBook.keySet()) {
                    if (mapPhoneBook.get(tel).equals(name)) {
                        System.out.print(tel + " ");
                    }
                }
                return;
            }
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента "+name+":");
                String phone = new Scanner(System.in).nextLine();
                if(phone.matches(NUMBER_REGEX)){
                    mapPhoneBook.put(phone, name);
                    System.out.println("Контакт сохранен");
                }else{
                    System.out.println("Неправильно введен номер");
                }

    }
    public static void printAllContacts() {

        if(mapPhoneBook.isEmpty()){
            System.out.println("Книга контактов пуста");
            return;
        }
        mapPhoneBook.forEach((key,value)-> System.out.println(value+" - "+key));
    }
}*/