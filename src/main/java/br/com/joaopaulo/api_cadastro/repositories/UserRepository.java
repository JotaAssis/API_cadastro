package br.com.joaopaulo.api_cadastro.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.joaopaulo.api_cadastro.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}