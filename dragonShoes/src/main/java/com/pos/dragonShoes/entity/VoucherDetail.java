package com.pos.dragonShoes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VoucherDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "salesOrder_id")
	private Voucher order;
	
	@ManyToOne
	@JoinColumn(name = "footwear_id")
	private Footwear footwear;
	
	@Column(nullable = true)
	private int quantity;
	
	@Column(nullable = true)
	private double amount;

	public VoucherDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoucherDetail(Voucher order, Footwear footwear, int quantity, double amount) {
		super();
		this.order = order;
		this.footwear = footwear;
		this.quantity = quantity;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Voucher getVoucher() {
		return order;
	}

	public void setVoucher(Voucher voucher) {
		this.order = voucher;
	}

	public Footwear getProduct() {
		return footwear;
	}

	public void setProduct(Footwear product) {
		this.footwear = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Voucher getOrder() {
		return order;
	}

	public void setOrder(Voucher order) {
		this.order = order;
	}

	public Footwear getFootwear() {
		return footwear;
	}

	public void setFootwear(Footwear footwear) {
		this.footwear = footwear;
	}
	
	
	
}
