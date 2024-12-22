package Controllers;

import Entities.Borrower;
import Services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @RequestMapping("/borrowers")
    public List<Borrower> getAllBorrowers() {
        return borrowerService.getAllBorrowers();
    }

    @RequestMapping("/borrowers/{id}")
    public Borrower getBorrower(@PathVariable Integer id) {
        return borrowerService.getBorrowerById(id);
    }

    @RequestMapping("/borrowers/{name}")
    public List<Borrower> getBorrowerByName(@PathVariable String name) {
        return borrowerService.getBorrowerByName(name);
    }

    @RequestMapping("/borrowers/{email}")
    public List<Borrower> getBorrowerByEmail(@PathVariable String email) {
        return borrowerService.getBorrowerByEmail(email);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/borrowers")
    public void addBorrower(@RequestBody Borrower borrower) {
        borrowerService.addBorrower(borrower);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/borrowers/{id}")
    public void updateBorrower(@PathVariable Integer id, @RequestBody Borrower borrower) {
        borrowerService.updateBorrower(id, borrower);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/borrowers/{id}")
    public void deleteBorrower(@PathVariable Integer id) {
        borrowerService.deleteBorrower(id);
    }
}
