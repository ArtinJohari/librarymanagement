package Services;

import Entities.Book;
import Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).filter(t -> t.getId() == id).get();
    }
    public List<Book> getBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();
        bookRepository.findByTitle(title).forEach(books::add);
        return books;
    }
    public List<Book> getBooksByIsbn(String isbn) {
        List<Book> books = new ArrayList<>();
        bookRepository.findByIsbn(isbn).forEach(books::add);
        return books;
    }
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public void updateBook(Integer id, Book book) {
        bookRepository.save(book);
    }
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
