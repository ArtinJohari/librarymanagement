package Services;

import Entities.Borrower;
import Repositories.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;
    public List<Borrower> getAllBorrowers() {
        List<Borrower> borrowers = new ArrayList<>();
        borrowerRepository.findAll().forEach(borrowers::add);
        return borrowers;
    }
    public Borrower getBorrowerById(Integer id) {
        return borrowerRepository.findById(id).filter(t -> t.getId() == id).get();
    }
    public List<Borrower> getBorrowerByName(String name) {
        List<Borrower> borrowers = new ArrayList<>();
        borrowerRepository.findByName(name).forEach(borrowers::add);
        return borrowers;
    }
    public List<Borrower> getBorrowerByEmail(String email) {
        List<Borrower> borrowers = new ArrayList<>();
        borrowerRepository.findByEmail(email).forEach(borrowers::add);
        return borrowers;
    }
    public void addBorrower(Borrower borrower) {
        borrowerRepository.save(borrower);
    }
    public void updateBorrower(Integer id, Borrower borrower) {
        borrowerRepository.save(borrower);
    }
    public void deleteBorrower(Integer id) {
        borrowerRepository.deleteById(id);
    }
}
