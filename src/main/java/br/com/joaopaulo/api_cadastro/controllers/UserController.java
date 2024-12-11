package br.com.joaopaulo.api_cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopaulo.api_cadastro.models.User;
import br.com.joaopaulo.api_cadastro.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService uService;

    @PostMapping("/cadastro")
    public ResponseEntity<User> cadastrar(@Valid @RequestBody User user){
        return uService.cadastrar(user);
    }

    @GetMapping("/lista")
    public Iterable<User> listar(){
        return uService.listar();
    }

}