package Beans;

public class Librarian {

    private String name;
    private byte age;
    private byte gender;
    private String password;

    public Librarian(String name, byte gender, byte age, String password) {
        this(name, gender, age);
        this.password = password;
    }

    public Librarian(String name, byte gender, byte age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public byte getAge() {
        return age;
    }

    public byte getGender() {
        return gender;
    }
}
