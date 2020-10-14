package com.project.filrouge.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DessinsController {

    @GetMapping(value = "/dessins")
    public String findAllDessins() {
        return "Heyyy";
    }

}
