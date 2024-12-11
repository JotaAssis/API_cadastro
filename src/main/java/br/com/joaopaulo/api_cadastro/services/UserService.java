package br.com.joaopaulo.api_cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.api_cadastro.models.User;
import br.com.joaopaulo.api_cadastro.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository uP;

    //Metodo de cadastro
    public ResponseEntity<User> cadastrar(User user){
        User novoUser = uP.save(user);
        return new ResponseEntity<User>(novoUser, HttpStatus.CREATED);
    }

    //Metodo Listar
    public Iterable<User> listar(){
        return uP.findAll();
    }

}