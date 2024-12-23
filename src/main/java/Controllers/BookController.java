package Controllers;

import Entities.Book;
import Entities.Borrower;
import Services.BookService;
import Services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowerService borrowerService;

    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @RequestMapping("/books/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @RequestMapping("/books/{isbn}")
    public List<Book> getBookByISBN(@PathVariable String isbn) {
        return bookService.getBooksByIsbn(isbn);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{bookId}/borrow/{borrowerId}")
    public void borrowBook(@PathVariable Integer bookId, @PathVariable Integer borrowerId) {
        Borrower borrower = borrowerService.getBorrowerById(borrowerId);
        Book borrowedBook = bookService.borrowBook(bookId, borrower);
        borrower.getBorrowedBooks().add(borrowedBook);
        borrowerService.addBorrower(borrower);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{bookId}/return/{borrowerId}")
    public void returnBook(@PathVariable Integer bookId, @PathVariable Integer borrowerId) {
        Borrower borrower = borrowerService.getBorrowerById(borrowerId);
        Book returnedBook = bookService.returnBook(bookId);
        borrower.getBorrowedBooks().remove(returnedBook);
        borrowerService.addBorrower(borrower);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
