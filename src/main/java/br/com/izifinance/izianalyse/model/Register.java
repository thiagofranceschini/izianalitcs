package br.com.izifinance.izianalyse.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "register")
public class Register {

	@Id
	private String id;
	private String cpf;
	private String name;
	private Date birthday;
	private String email;
	private String password;
	private String phoneNumber;
	private Date registerDate;
	private List<String> uriImageProfile = new ArrayList<>();
	private Address address;
	private StatusRegister status;
	private String iziWalletAddress;
	private String analysedBy;
	private String dataAnalysis;
	private String IziAccountId;

	public Register() {
		super();
	}

	public Register(String cpf, String name, Date birthday, String email, String password, String phoneNumber,
			Address address) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public StatusRegister getStatus() {
		return status;
	}

	public void setStatus(StatusRegister status) {
		this.status = status;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getIziWalletAddress() {
		return iziWalletAddress;
	}

	public List<String> getUriImageProfile() {
		return uriImageProfile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("Register id=").append(id)
			.append(", cpf=").append(cpf)
			.append(", name=").append(name)
			.append(", birthday=").append(birthday)
			.append(", email=").append(email)
			.append(", phoneNumber=")
			.append(phoneNumber).append(", registerDate=")
			.append(registerDate);
		return builder.toString();
	}

	public String getAnalysedBy() {
		return analysedBy;
	}

	public void setAnalysedBy(String analysedBy) {
		this.analysedBy = analysedBy;
	}

	public String getDataAnalysis() {
		return dataAnalysis;
	}

	public void setDataAnalysis(String dataAnalysis) {
		this.dataAnalysis = dataAnalysis;
	}

	public String getIziAccountId() {
		return IziAccountId;
	}

	public void setIziAccountId(String iziAccountId) {
		IziAccountId = iziAccountId;
	}
	
	
	
	

}
