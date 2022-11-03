package com.wedspay.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Payment {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull(message = "is required")
	private String name;
	@Column
	@NotNull(message = "is required")
	@Size(min = 4, message = "wrong Address")
	private String address;
	@Column
	@Min(value = 1)
	private int amount;
	@Transient
	@Size(min = 10, message = "Wrong marriage Id")
	@NotNull(message = "is required")
	private String marriageId;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn
	private Person person;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getMarriageId() {
		return marriageId;
	}
	public void setMarriageId(String marriageId) {
		this.marriageId = marriageId;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", name=" + name + ", address=" + address + ", amount=" + amount + ", marriageId="
				+ marriageId + "]";
	}
	
}
