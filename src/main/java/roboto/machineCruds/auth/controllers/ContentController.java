package roboto.machineCruds.auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import roboto.machineCruds.auth.model.UserEntity;

@Controller
public class ContentController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
