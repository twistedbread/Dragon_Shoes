package com.pos.dragonShoes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FootwearDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "footwear_id")
	private Footwear footwear;
	
	@Column(nullable = true)
	private String size;
	
	@Column(nullable = true)
	private int qtyInStock;

	public FootwearDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FootwearDetail(Footwear footwear, String size, int qtyInStock) {
		super();
		this.footwear = footwear;
		this.size = size;
		this.qtyInStock = qtyInStock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Footwear getFootwear() {
		return footwear;
	}

	public void setFootwear(Footwear footwear) {
		this.footwear = footwear;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}
	
	
}
