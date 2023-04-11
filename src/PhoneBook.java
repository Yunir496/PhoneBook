import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        
    }
    Map<String, String> mapPhoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (phone.matches("[\\d]{11}") && name.matches("[А-Яа-я]+")) {
            if (mapPhoneBook.containsKey(phone)) {
                mapPhoneBook.replace(phone, mapPhoneBook.get(phone), name);
            } else {
                mapPhoneBook.put(phone, name);
            }
        }
    }


    public String getContactByPhone(String phone) {
        if (mapPhoneBook.containsKey(phone)) {
            return mapPhoneBook.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }


    public Set<String> getContactByName(String name) {

        Set<String> setPhoneBook = new TreeSet<>();
        String namePlusTel = "";
        if (mapPhoneBook.containsValue(name)) {
            namePlusTel = namePlusTel.concat(name) + " - ";
            for (String tel : mapPhoneBook.keySet()) {
                if (mapPhoneBook.get(tel).equals(name)) {
                    namePlusTel = namePlusTel.concat(tel) + ", ";
                }
            }
            setPhoneBook.add(namePlusTel.substring(0, namePlusTel.length() - 2));
            return setPhoneBook;
        } else {
            return new TreeSet<>();
        }
    }

    public Set<String> getAllContacts() {

        Set<String> setPhoneBook = new TreeSet<>();

        for (String key : mapPhoneBook.keySet()) {
            setPhoneBook.add(mapPhoneBook.get(key) + " - " + key);
        }
        return setPhoneBook;
    }
}

