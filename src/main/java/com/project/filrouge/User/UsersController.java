package com.project.filrouge.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "gestion de tout les user éxistants")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {
    @Autowired
    UsersDao usersDao;

    @ApiOperation(value = "recupère tout les users de la BDD")
    @GetMapping(value = "/user")
    public List<Users> createSquare(){
        return usersDao.findAll();
    }

    @ApiOperation(value = "Ajoute un user dans la BDD")
    @PostMapping(value = "/user")
    public Users createSquare(@RequestBody UsersJob user){
        return usersDao.save(new Users(user));
    }

    @ApiOperation(value = "Supprime un user de la BDD en fonction de son id")
    @DeleteMapping(value = "/user/{id}")
    public List<Users> createSquare(@PathVariable int id){
        usersDao.deleteById(id);
        return usersDao.findAll();
    }
}
