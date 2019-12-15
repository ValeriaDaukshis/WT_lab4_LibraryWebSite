package Beans;

public class User {
    private String name;
    private byte age;
    private byte gender;
    private String password;

    public User(String name, byte gender, byte age, String password) {
        this(name, gender, age);
        this.password = password;
    }

    public User(String name, byte gender, byte age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
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
