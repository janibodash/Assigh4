package BookService;

import DBconnect.DBconnect;
import com.example.libraryrest.entities.Book;
import com.example.libraryrest.entities.Library;
import java.sql.*;

public class BookService {
    public void ShowBooks(Library library) {
        library.getBooks().clear();

        try (Connection conn = DBconnect.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getString("description")
                );
                library.addBook(book);
            }
        } catch (Exception e) {
            System.out.println("DB error: " + e.getMessage());
        }
        library.showAllBooks();
    }


    public void addBook(Book book) {
        try (Connection conn = DBconnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO books(title, author, year,description) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.executeUpdate();
            ps.setString(4, book.getDescription());

        } catch (Exception e) {
            System.out.println("DB error: " + e.getMessage());
        }


    }

    public void findBook (Library library, String title) {
        library.getBooks().clear();

        try (Connection conn = DBconnect.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement("SELECT * FROM books WHERE title ILIKE ?");
            ps.setString(1, title);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getString("description")

                );
                library.addBook(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        library.showAllBooks();
    }

    public void filterByYear (Library library, int year) {
        library.getBooks().clear();

        try (Connection conn = DBconnect.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement("SELECT * FROM books WHERE year >= ?");
            ps.setInt(1, year);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getString("description")

                );
                library.addBook(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        library.showAllBooks();
    }

    public void sortByYear (Library library) {
        library.getBooks().clear();

        try (Connection conn = DBconnect.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getString("description")

                );
                library.addBook(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        library.sortByYear();
        library.showAllBooks();
    }

    public void deleteBook(String title) {
        try (Connection conn = DBconnect.getConnection()) {

            PreparedStatement ps =
                    conn.prepareStatement("DELETE FROM books WHERE title ILIKE ?");

            ps.setString(1, title);
            ps.executeUpdate();   //

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateYearBook(String title, int newYear) {
        try (Connection conn = DBconnect.getConnection()) {

            PreparedStatement ps =
                    conn.prepareStatement(
                            "UPDATE books SET year = ? WHERE title ILIKE ?"
                    );

            ps.setInt(1, newYear);
            ps.setString(2, title);

            ps.executeUpdate();   //

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAuthorBook(String title, String newAuthor) {
        try (Connection conn = DBconnect.getConnection()) {

            PreparedStatement ps =
                    conn.prepareStatement(
                            "UPDATE books SET author = ? WHERE title ILIKE ?"
                    );

            ps.setString(1, title);
            ps.setString(2, title);

            ps.executeUpdate();   // ← UPDATE

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}