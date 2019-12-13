package be.steven.d.dog.recapjee.ctrl;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorCtrl implements ErrorController {

    @RequestMapping({"products/error", "/error"})
    public String handleError() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
