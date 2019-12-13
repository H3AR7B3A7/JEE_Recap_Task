package be.steven.d.dog.recapjee.ctrl;

import be.steven.d.dog.recapjee.exceptions.ResourceNotFoundException;
import be.steven.d.dog.recapjee.model.Product;
import be.steven.d.dog.recapjee.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

/**
 * PRODUCT CONTROLLER
 *
 * @author d.Dog
 */
@Controller
public class ProductCtrl {

    @Autowired
    ProductRepo repo;

    /**
     * @return Find all - for table
     */
    @ModelAttribute(value = "products")
    public Iterable<Product> findAllProducts() {
        return repo.findAll();
    }

    /**
     * @return Get products page
     */
    @GetMapping(value = "/products")
    public String showProducts(ModelMap map) {
        return "products";
    }

    /**
     * @return Get productdetails page IF it exists
     */
    @GetMapping(value = "/products/{id}")
    public String showProductDetails(ModelMap map, @PathVariable(value = "id") int id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()) {
            map.addAttribute("product", optional.get());
            return "productdetails";
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
