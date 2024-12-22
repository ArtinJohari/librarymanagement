package Controllers;

import Entities.Author;
import Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @RequestMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable Integer id) {
        return authorService.getAuthorById(id);
    }

    @RequestMapping("/authors/{name}")
    public List<Author> getAuthorByName(@PathVariable String name) {
        return authorService.getAuthorsByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/authors")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/authors/{id}")
    public void updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/authors/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
    }
}
