package be.steven.d.dog.recapjee.ctrl;

import be.steven.d.dog.recapjee.model.Product;
import be.steven.d.dog.recapjee.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormCtrl {

    @Autowired
    ProductRepo repo;
    /**
     * @return Create a new product/item
     */
    @ModelAttribute(value = "nProduct")
    public Product ProductToSave() {
        return new Product();
    }

    /**
     * @return Add values to newly created product/item
     */
    @PostMapping(value = "/products/form")
    public String saveProduct(@ModelAttribute("nProduct") @Valid Product nProduct, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "form";
        repo.save(nProduct);
        return "redirect:/products";
    }

    /**
     * @return Get form page
     */
    @GetMapping(value = "/products/form")
    public String showForm(ModelMap map) {
        map.addAttribute("form",new Product());
        return "form";
    }
}
