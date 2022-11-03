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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Person {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull(message = "is required")
	private String firstName;
	@Column
	@NotNull(message = "is required")
	private String lastName;
	@Column
	private String marriageId;
	@Column
	@NotNull(message = "is required")
	@Size(min = 4)
	private String address;
	@Column
	@NotNull(message = "is required")
	@Size(min = 10, message = "Wrong Upi")
	private String upiId;
	@Column
	@NotNull(message = "is required")
	private String girlName;
	@Column
	@NotNull(message = "is required")
	private String boyName;
	@Column
	@NotNull(message = "is required")
	private String marriageDate;
	
	@OneToMany(mappedBy = "person",fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private List<Payment> payments;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn
	private User user;
	// add method
	public void add(Payment p) {
		if(payments == null) {
			payments = new ArrayList<Payment>();
		}
		payments.add(p);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getGirlName() {
		return girlName;
	}

	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}

	public String getBoyName() {
		return boyName;
	}

	public void setBoyName(String boyName) {
		this.boyName = boyName;
	}

	public String getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(String marriageDate) {
		this.marriageDate = marriageDate;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMarriageId() {
		return marriageId;
	}
	public void setMarriageId(String marriageId) {
		this.marriageId = marriageId;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", marriageId=" + marriageId
				+ ", address=" + address + ", upiId=" + upiId + ", girlName=" + girlName + ", boyName=" + boyName
				+ ", marriageDate=" + marriageDate + "]";
	}
	
}
