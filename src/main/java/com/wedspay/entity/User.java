package com.wedspay.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;





@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull(message = "is required")
	private String name;
	@Column(unique = true)
	@NotNull(message="is required")
	@Size(max = 10 , message = "wrong input")
	private String mobile;
	@Column(unique = true)
	@NotNull(message="is required")
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Wrong input")
	private String email;
	@Column
	@NotNull(message="is required")
	private String password;
	@Column
	private boolean enabled;
	@Column
	private String role;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "user")
	private List<Person> marriages;
	
	
	// convenience method for adding Person to list.
	public void add(Person p) {
		if(marriages == null) {
			marriages = new ArrayList<Person>();
		}
		marriages.add(p);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Person> getMarriages() {
		return marriages;
	}

	public void setMarriages(List<Person> marriages) {
		this.marriages = marriages;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
