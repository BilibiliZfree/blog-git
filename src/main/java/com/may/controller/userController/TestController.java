package com.may.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @GetMapping("/user/login1")
    public String test(Model model){
        model.addAttribute("aaa","bbb");
        return null;
    }
}
