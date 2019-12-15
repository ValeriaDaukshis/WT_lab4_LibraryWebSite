package Beans;

public class User {
    private String name;
    private byte age;
    private String password;

    public User(String name, byte age, String password) {
        this(name, age);
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, byte age) {
        this.name = name;
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
}
