package be.steven.d.dog.recapjee.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * INDEX CONTROLLER
 *
 * @author d.Dog
 */
@Controller
public class IndexCtrl {

    /**
     * @return Get index page
     */
    @GetMapping(value = {"/", "/index"})
    public String showIndex(ModelMap map) {
        return "index";
    }
}
