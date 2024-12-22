package Repositories;

import Entities.Borrower;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowerRepository extends CrudRepository<Borrower, Integer> {
    public List<Borrower> findByName(String name);
    public List<Borrower> findByEmail(String email);
}
