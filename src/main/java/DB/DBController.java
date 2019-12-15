package DB;

import Beans.Book;
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
            String str = "INSERT INTO users(name,gender,age,password) VALUES ('" + user.getName() + "'," + user.getGender() + ", "+user.getAge()+", '"+user.getPassword()+"'); ";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public void InsertBook(Book b){
        try {
            String str = "INSERT INTO books(name,author,image,description,pages) VALUES ('" + b.getName() + "','" + b.getAuthor()+ "','" + b.getImage()+ "','"+b.getDescription()+"'," + b.getPages() + "); ";
            this.statement.execute(str);
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        }
    }

    public void DeleteBook(int id){
        try {
            String str = "DELETE FROM books WHERE id=" + id + ";";
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
                String image= rs.getString("image");
                int pages= rs.getInt("pages");
                list.add(new Book(name, author, image, description, pages));
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
                byte gender= rs.getByte("gender");
                list.add(new User(name, gender, age));
            }
        } catch (SQLException ex) {
            log.warn("Error in database inserting: " + ex);
        } catch (Exception ex) {
            log.warn("Error in database inserting: " + ex);
        }
        return list;
    }
}

