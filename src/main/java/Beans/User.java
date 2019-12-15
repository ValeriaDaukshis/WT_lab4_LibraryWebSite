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

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User listDao = (User) obj;

        if (age != listDao.age)
            return false;

        if (name == null && password == null)
            return (name == listDao.name) && (password == listDao.password);

        else if (!password.equals(listDao.password) || !name.equals(listDao.name))
            return false;
        return true;
    }

    public int hashCode() {
        return (int) (password.hashCode() + name.hashCode() + 23 * age + 58);
    }

}
