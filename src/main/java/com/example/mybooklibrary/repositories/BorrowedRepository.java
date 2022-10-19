package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
// List<Borrowed> findAll();
// }

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Integer> {
    @Query("SELECT b FROM Borrowed b \n" +
            "JOIN b.bookOwner o\n" +
            "ON b.bookOwner.bookOwnerIdTable = o.bookOwnerIdTable \n" +
            "WHERE o.bookOwnerIdTable = :id")
    List<Borrowed> getBorrowedBookByOthers(Integer id);

    @Query("SELECT b FROM Borrowed  b\n" +
            "WHERE b.bookOwner.users.user_id_table = :userId")
    List<Borrowed> getBorrowedByAccount_id(Integer userId);

    @Query("SELECT b FROM Borrowed b \n" +
            "WHERE b.bookOwner.book.author = :search " +
            "OR b.bookOwner.book.title = :search")
    List<Borrowed> getTitleOrAuthor(String search);
//
//    List<Borrowed> findAllByBookOwner_Book(List<Book> book);
//
    @Query("SELECT b FROM Borrowed b \n" +
            "WHERE b.bookOwner.book = :book")
    Borrowed getBorrowedByBookOwner_Book(Book book);

}

/* ideas for the RETURN Date and for the Waiting List later on...

            in Service, scriu .search get AvailableBooksOwner
            apoi scriu QUERY in Repo. "b" poate fi alias pentru Borrowed.
            iar :id il folosesc pt numele variabilei userId.
*/
// Logica de legaturi intre tabela Borrowed si Waiting List s-o fac cu: View sau @Query.
// Eg:
//    @Query("SELECT b FROM Borrowed b \n" +
//            "WHERE b.bookOwner.book.author = :search " +
//            "OR b.bookOwner.book.title = :search")
//    List<Borrowed> getTitleOrAuthor(String search);


/* useful && smartCommands, for:
- hot to auto-indent all lines = ctrl+alt+L
- optimize "import" = ctrl+alt+o (how to get rid of unUsed/useless "import"s)
- how to get rid of unProper variables' names, as user_is instead of userId (camelCase in Java)
- hot to generate "Diagrams" from the DB on the right here.
- better annotate with @... rather than @...
- how to comment multiple lines with // = ctrl+/
- refactor all variables' names everywhere = shift+fn+F6
 */

