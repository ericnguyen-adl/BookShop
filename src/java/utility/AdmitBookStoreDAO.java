package utility;

import java.util.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Book;

/**
 * DAO to connect with BooksDB database
 * @author nguye
 */
public class AdmitBookStoreDAO {

    private Connection con;

    /**
     * Constructor to establish the connection to BooksDB database
     */
    public AdmitBookStoreDAO() {
        try {
            // Load the Driver class file
//            Class.forName(driver);
            System.err.println("Getting Connection!");
//            con = DriverManager.getConnection(url, user, password);
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/javaDB_Books");
            con = ds.getConnection();            
            if (con != null) {
                System.err.println("Got Connection!");
            }// end if
        } catch (Exception ex) {
            ex.printStackTrace();
        }// end catch
    }// end of Contructor

    // get info on all courses taught by a lecturer

    /**
     * This method to get all the books from database and store in a list
     * @return List of book from database
     * @throws SQLException
     */
    public List getAllBooks() throws SQLException {
        System.out.println("inside getAllBooks");
        Statement statement = con.createStatement();
        ResultSet rs = null;
        List list = new ArrayList();

        rs = statement.executeQuery("SELECT * FROM USER1.TBooks ");
        String isbn = "";
        String title = "";
        String author = "";
        double price = 0.00;
        while (rs.next()) {
            System.out.println("rs has records");
            isbn = rs.getString(1);
            title = rs.getString(2);
            author = rs.getString(3);
            price = rs.getDouble(4);
            list.add(new Book(isbn, title, author, price));
        }
        return list;
    } // end getAllBooks

}