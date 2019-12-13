package be.steven.d.dog.recapjee.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CONTACT CONTROLLER
 *
 * @author d.Dog
 */
@Controller
public class ContactCtrl {

    /**
     * @return Get contact page
     */
    @GetMapping(value = "/contact")
    public String showContact(ModelMap map) { return "contact";}
}