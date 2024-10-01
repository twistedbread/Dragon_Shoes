package com.pos.dragonShoes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "member_id", nullable = true)
	private User member;
	
	@Column(nullable = true)
	private double totalAmt;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(User member, double totalAmt) {
		super();
		this.member = member;
		this.totalAmt = totalAmt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	
}
