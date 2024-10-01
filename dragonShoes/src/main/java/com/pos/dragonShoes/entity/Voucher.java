package com.pos.dragonShoes.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Voucher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "mem_id")
	private User member;
	
	@Column(nullable = false)
	private Date voucherDate;

	@Column(nullable = true)
	private int deliveryFee;
	
	@Column(nullable = true)
	private double tax;
	
	@Column(nullable = true)
	private double totalAmt;

	@Column(nullable = false)
	private String paymentType;
	
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Voucher(User member, Date voucherDate, int deliveryFee, double tax, double totalAmt, String paymentType) {
		super();
		this.member = member;
		this.voucherDate = voucherDate;
		this.deliveryFee = deliveryFee;
		this.tax = tax;
		this.totalAmt = totalAmt;
		this.paymentType = paymentType;
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

	public Date getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}

	public int getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
	
}
