package be.steven.d.dog.recapjee.ctrl;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ERROR CONTROLLER
 *
 * @author d.Dog
 */
@Controller
public class ErrorCtrl implements ErrorController {

    /**
     * @return Get 404 page
     */
    @GetMapping({"products/error", "/error"})
    public String handleError() {
        return "404";
    }

    /**
     * @return Catch error with override
     */
    @Override
    public String getErrorPath() {
        return "error";
    }
}
