package Services;

import Entities.Author;
import Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }
    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).filter(t -> t.getId() == id).get();
    }
    public List<Author> getAuthorsByName(String name) {
        List<Author> authors = new ArrayList<>();
        authorRepository.findByName(name).forEach(authors::add);
        return authors;
    }
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
    public void updateAuthor(Integer id, Author author) {
        authorRepository.save(author);
    }
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }
}
