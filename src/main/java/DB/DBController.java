package DB;

import Beans.Book;
import Beans.Librarian;
import Beans.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.ResultSet;

public class DBController {
    private Statement statement;
    private Connection connection = DataBaseDao.connect();
    private static final Logger log = Logger.getLogger(DBController.class);

    public DBController() {
        try{
            this.statement = this.connection.createStatement();
        } catch (SQLException ex){
            log.error(ex.getMessage());
        }
    }

    public void InsertUser(User user){
        try {
            String str = "INSERT INTO users(name,gender,age,password) VALUES ('" + user.getName() + "', "+user.getAge()+", '"+user.getPassword()+"'); ";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public void InsertBook(Book b){
        try {
            String str = "INSERT INTO books(name,author,image,description,pages) VALUES ('" + b.getName() + "','" + b.getAuthor()+ "'," + b.getCount()+ ",'"+b.getDescription()+"'," + b.getPages() + "); ";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public boolean CompareUser(User user){
        try {
            ResultSet rs = this.statement.executeQuery("SELECT name, password FROM users;");
            while (rs.next()) {
                String name= rs.getString("name");
                String password= rs.getString("password");
                if(name.equals(user.getName()) && password.equals(user.getPassword())){
                    return true;
                }
            }
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        } catch (Exception ex) {
            log.warn("Error in database inserting: " + ex);
        }
        return false;
    }

    public boolean CompareLibrarian(Librarian lib){
        try {
            ResultSet rs = this.statement.executeQuery("SELECT name, password FROM librarians;");
            while (rs.next()) {
                String name= rs.getString("name");
                String password= rs.getString("password");
                if(name.equals(lib.getName()) && password.equals(lib.getPassword())){
                    return true;
                }
            }
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        } catch (Exception ex) {
            log.warn("Error in database inserting: " + ex);
        }
        return false;
    }

    public void DeleteBook(String name){
        try {
            String str = "DELETE FROM books WHERE name=" + name + ";";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public void UpdateBook(int count, String name, String author){
        try {
            String str = "UPDATE books SET count=" + count + " WHERE name= '"+ name +"' and author = '"+ author+"';";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public Book GetBook(String bookName){
        try {
            ResultSet rs = this.statement.executeQuery("SELECT * FROM books WHERE name='" + bookName + "');");
            while (rs.next()) {
                String name= rs.getString("name");
                String author= rs.getString("author");
                String description= rs.getString("description");
                int count= Integer.parseInt(rs.getString("count"));
                int pages= rs.getInt("pages");
                return new Book(name, author, count, description, pages);
            }
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        } catch (Exception ex) {
            log.warn("Error in database inserting: " + ex);
        }
        return null;
    }

    public void DeleteBookFromUser(String username, String bookName){
        try {
            String str = "DELETE FROM usersBooks WHERE userName='" + username + "' and bookName='"+bookName+"';";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public void AddBookToUser(String username, String bookName){
        try {
            String str = "INSERT INTO usersBooks(username, bookName) VALUES ('" + username + "','" + bookName+ "'); ";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public ArrayList<Book> ReadBooksFromDB(){
        ArrayList<Book> list = new ArrayList<Book>();
        try {
            ResultSet rs = this.statement.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                String name= rs.getString("name");
                String author= rs.getString("author");
                String description= rs.getString("description");
                int count= Integer.parseInt(rs.getString("count"));
                int pages= rs.getInt("pages");
                list.add(new Book(name, author, count, description, pages));
            }
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        } catch (Exception ex) {
            log.warn("Error in database inserting: " + ex);
        }
        return list;
    }

    public ArrayList<User> ReadUsersFromDB(){
        ArrayList<User> list = new ArrayList<User>();
        try {
            ResultSet rs = this.statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String name= rs.getString("name");
                byte age= rs.getByte("age");
                list.add(new User(name, age));
            }
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        } catch (Exception ex) {
            log.warn("Error in database inserting: " + ex);
        }
        return list;
    }
}

