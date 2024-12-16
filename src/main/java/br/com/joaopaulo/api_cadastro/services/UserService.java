package br.com.joaopaulo.api_cadastro.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.api_cadastro.models.Response;
import br.com.joaopaulo.api_cadastro.models.User;
import br.com.joaopaulo.api_cadastro.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository uP;

    @Autowired
    private Response rm;

    //Metodo de cadastro
    public ResponseEntity<?> cadastrar(User user){
        if (user.getPassword().equals("") || user.getPassword().length() < 8){
            rm.setMensage("A senha não pode ser nula e não pode ter menos que 8 caracteres");
            return new ResponseEntity<Response>(rm, HttpStatus.BAD_REQUEST);
        }if (user.getUsername().equals("") || user.getUsername().length() < 2) {
            rm.setMensage("O usuário não pode ser nulo e não pode ter menos que 2 caracteres");
            return new ResponseEntity<Response>(rm, HttpStatus.BAD_REQUEST);
        }
            User novoUser = uP.save(user);
            return new ResponseEntity<User>(novoUser, HttpStatus.CREATED);       
    }

    //Metodo Listar
    public Iterable<User> listar(){
        return uP.findAll();
    }

    //Metodo para atualizar User
    public ResponseEntity<?> atualizar(User user){
        if (user.getId() == null || user.getId() < 0) {
            rm.setMensage("Id do usuário invalido!");
            return new ResponseEntity<Response>(rm, HttpStatus.BAD_REQUEST);
        }
        Optional<User> userOptional = uP.findById(user.getId());
        if (userOptional.isEmpty()) {
            rm.setMensage("Usuário não encontrado!");
            return new ResponseEntity<Response>(rm, HttpStatus.NOT_FOUND);
        }
        User userAtualizado = uP.save(user);
        return new ResponseEntity<User>(userAtualizado, HttpStatus.OK);
    }

    //Metodo para remover
    public ResponseEntity<Response> remover(Long id){
        if (id == null || id < 0) {
            rm.setMensage("Id do usuário invalido!");
            return new ResponseEntity<Response>(rm, HttpStatus.BAD_REQUEST);
        }
        Optional<User> userOptional = uP.findById(id);
        if (userOptional.isEmpty()) {
            rm.setMensage("Usuário não encontrado!");
            return new ResponseEntity<Response>(rm, HttpStatus.NOT_FOUND);
        }
        uP.deleteById(id);
        rm.setMensage("Usuário removido");
        return new ResponseEntity<Response>(rm, HttpStatus.OK);
    }

}