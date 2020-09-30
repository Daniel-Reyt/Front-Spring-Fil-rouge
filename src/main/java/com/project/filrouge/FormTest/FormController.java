package com.project.filrouge.FormTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @GetMapping("/addShape")
    @ResponseBody
    public ModelAndView sendForm(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
//
//    @PostMapping("/addUser")
//    @ResponseBody
//    public String processForm(User user) {
//
//        return "/Square";
//    }

}
