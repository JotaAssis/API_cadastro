package br.com.joaopaulo.api_cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopaulo.api_cadastro.models.Response;
import br.com.joaopaulo.api_cadastro.models.User;
import br.com.joaopaulo.api_cadastro.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService uService;

    //Cadastrar
    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody User user){
        return uService.cadastrar(user);
    }

    //Listar
    @GetMapping("/lista")
    public Iterable<User> listar(){
        return uService.listar();
    }

    //Alterar
    @PutMapping("/alterar")
    public ResponseEntity<?> atualizar(@RequestBody User user){
        return uService.atualizar(user);
    }


    //Remover
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Response> remover(@PathVariable Long id){
        return uService.remover(id);
    }

}