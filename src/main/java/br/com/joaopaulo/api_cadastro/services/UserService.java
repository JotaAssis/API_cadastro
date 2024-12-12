package br.com.joaopaulo.api_cadastro.services;


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
    public ResponseEntity<User> atualizar(User user){
        User userAtualizado = uP.save(user);
        return new ResponseEntity<User>(userAtualizado, HttpStatus.OK);
    }

    //Metodo para remover
    public ResponseEntity<Response> remover(Long id){
        uP.deleteById(id);
        rm.setMensage("Produto removido");
        return new ResponseEntity<Response>(rm, HttpStatus.OK);
    }

}