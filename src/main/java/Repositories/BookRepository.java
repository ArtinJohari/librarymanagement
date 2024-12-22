package Repositories;

import Entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public List<Book> findByTitle(String title);
    public List<Book> findByIsbn(String isbn);
}
