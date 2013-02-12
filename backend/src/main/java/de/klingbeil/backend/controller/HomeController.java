package de.klingbeil.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    protected static final String HOME_VIEW = "home";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPage() {
        return HOME_VIEW;
    }
}
