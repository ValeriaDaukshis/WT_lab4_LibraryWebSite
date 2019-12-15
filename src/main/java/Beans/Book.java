package Beans;

public class Book {
    private int count;
    private String name;
    private String author;
    private String description;
    private int pages;

    public Book(String name, String author, int count, String description, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.count = count;
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Book() {

    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book listDao = (Book) obj;

        if (pages != listDao.pages || pages != listDao.pages || count != listDao.count)
            return false;

        if (name == null && author == null && description != null)
            return (name == listDao.name) && (author == listDao.author) && (description == listDao.description);

        else if (!author.equals(listDao.author) || !name.equals(listDao.name) || !description.equals(listDao.description))
            return false;
        return true;
    }

    public int hashCode() {
        return (int) (author.hashCode() + name.hashCode() + 23 * count + 58 * pages);
    }

}
