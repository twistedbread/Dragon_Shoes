package com.pos.dragonShoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pos.dragonShoes.entity.Voucher;

public interface VoucherRepository extends CrudRepository<Voucher, Long> {

	public List<Voucher> findAll();
}
