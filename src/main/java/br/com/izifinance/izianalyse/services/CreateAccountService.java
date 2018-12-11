package br.com.izifinance.izianalyse.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.izifinance.izianalyse.model.AccountInfo;
import br.com.izifinance.izianalyse.model.AccountPojo;
import br.com.izifinance.izianalyse.model.Register;

@Service
public class CreateAccountService {

	public AccountInfo newAccountPost(Register register) {
		AccountPojo pojo = new AccountPojo(register);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:8090/accounts/new", pojo, AccountInfo.class);
	}
}
