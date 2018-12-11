package br.com.izifinance.izianalyse.dto;

public class AuthenticationOutputDto {

	private String tokenType;
	private String token;

	public AuthenticationOutputDto(String tokenType, String token) {
		super();
		this.tokenType = tokenType;
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public String getToken() {
		return token;
	}

}
