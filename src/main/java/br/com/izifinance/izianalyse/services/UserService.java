package br.com.izifinance.izianalyse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.izifinance.izianalyse.exception.ObjectNotFoundException;
import br.com.izifinance.izianalyse.model.User;
import br.com.izifinance.izianalyse.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> possibleUser = repository.findByEmail(username);
		
		return possibleUser.orElseThrow(() -> new ObjectNotFoundException("Username Not Found!"));
	}

	public UserDetails loadUserById(String userId) {
		Optional<User> possibleUser = repository.findById(userId);
		return possibleUser.orElseThrow(()-> new ObjectNotFoundException("User id not found!"+userId));
	}

}
