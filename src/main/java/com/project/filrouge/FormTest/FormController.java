package com.project.filrouge.FormTest;

import com.project.filrouge.dao.SquareDao;
import com.project.filrouge.models.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

public class FormController {

    @Autowired
    private SquareDao squareDao;

    @GetMapping("/addShape")
    @ResponseBody
    public ModelAndView sendForm(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("/addUser#{size}&{name}&{id}#")
    public void addSquare(@PathVariable String size, @PathVariable int name, @PathVariable int id) {
        Square square = new Square( id, size, name);
        squareDao.save(square);
    }

}
