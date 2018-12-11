package br.com.izifinance.izianalyse.model;

public class AccountPojo {

	private String cpf;
	private String name;
	private String email;
	private String password;
	private String self;
	private String phoneNumber;
	
	public AccountPojo(Register register) {
		super();
		this.cpf = register.getCpf();
		this.name = register.getName();
		this.email = register.getEmail();
		this.password = register.getPassword();
		if(register.getUriImageProfile().size()>=1) {
			this.self = register.getUriImageProfile().get(0);
		}
		this.phoneNumber = register.getPhoneNumber();
	}
	public AccountPojo() {
		super();
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
