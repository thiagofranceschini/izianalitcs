package br.com.izifinance.izianalyse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.izifinance.izianalyse.email.Mailer;
import br.com.izifinance.izianalyse.email.MessageReprovation;
import br.com.izifinance.izianalyse.exception.ObjectNotFoundException;
import br.com.izifinance.izianalyse.exception.OperationNotAllowedException;
import br.com.izifinance.izianalyse.model.Register;
import br.com.izifinance.izianalyse.model.StatusRegister;
import br.com.izifinance.izianalyse.repositories.RegisterRepository;

@Service
public class AproveAndReproveService {

	@Autowired
	private RegisterRepository repository;
	
	@Autowired
	private CreateAccountService accountService;
	
	@Autowired
	private Mailer mailer;

	public Page<Register> getPageByStatus(StatusRegister status, Pageable pageRequest) {
		return repository.findAllByStatus(status, pageRequest);
	}

	public Register changeStatusRegisterToAuthorized(String registerId) {
		Register register = findById(registerId);
		verifyStatusRegisterToAprove(register);
		register.setStatus(StatusRegister.ALLOWED);
		register.setIziAccountId(accountService.newAccountPost(register).getId());//captacao do id na outra app
		return repository.save(register);
	}
	
	public Register changeStatusRegisterToNotAllowed(String registerId) {
		Register register = findById(registerId);
		verifyStatusRegisterToReprove(register);
		register.setStatus(StatusRegister.NOT_ALLOWED);
		mailer.send(new MessageReprovation(register));
		return repository.save(register);
		
	}
	
	private void verifyStatusRegisterToAprove(Register register) {
		if(register.getStatus().equals(StatusRegister.ALLOWED)) {
			throw new OperationNotAllowedException("Register status already allowed!");
		}
		if(register.getStatus().equals(StatusRegister.BLOCKED)) {
			throw new OperationNotAllowedException("Register status blocked");
		}
	}
	
	private void verifyStatusRegisterToReprove(Register register) {
		if(register.getStatus().equals(StatusRegister.NOT_ALLOWED)) {
			throw new OperationNotAllowedException("Register status already reproved");
		}
		if(register.getStatus().equals(StatusRegister.BLOCKED)) {
			throw new OperationNotAllowedException("Register status blocked");
		}
		if(register.getStatus().equals(StatusRegister.SUSPENDED)) {
			throw new OperationNotAllowedException("Register status suspended");
		}
	}
	
	private Register findById(String registerId) {
		return repository.findById(registerId)
				.orElseThrow(() -> new ObjectNotFoundException("Register not found." + registerId));
	}
}
