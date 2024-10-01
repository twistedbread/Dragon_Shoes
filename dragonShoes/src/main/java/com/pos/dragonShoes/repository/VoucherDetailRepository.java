package com.pos.dragonShoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pos.dragonShoes.entity.VoucherDetail;

public interface VoucherDetailRepository extends CrudRepository<VoucherDetail, Long>{

	public List<VoucherDetail> findAll();
}
