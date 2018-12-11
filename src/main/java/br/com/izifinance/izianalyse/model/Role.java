package br.com.izifinance.izianalyse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document
public class Role implements GrantedAuthority{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String authority;
	
	@Override
	public String getAuthority() {
		return this.authority;
	}

}
