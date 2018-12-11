package br.com.izifinance.izianalyse.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.izifinance.izianalyse.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	Optional<User>findByEmail(String email);
}
