package br.com.izifinance.izianalyse.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.izifinance.izianalyse.model.Register;
import br.com.izifinance.izianalyse.model.StatusRegister;


public interface RegisterRepository extends PagingAndSortingRepository<Register, String> {

	Optional<Register> findByCpf(String cpf);
	
	Optional<Register> findAllByEmail(String email);
	
	Page<Register> findAllByStatus(StatusRegister status, Pageable pageRequest);
}
