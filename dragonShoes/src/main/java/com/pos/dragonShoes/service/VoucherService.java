package com.pos.dragonShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.Voucher;
import com.pos.dragonShoes.repository.VoucherRepository;

@Service
public class VoucherService {

	@Autowired
	private VoucherRepository voucherRep;
	
	public List<Voucher> findAll(){
		return voucherRep.findAll();
	}

	public Optional<Voucher> findById(long id) {
		return voucherRep.findById(id);
	}
	
	public void saveVoucher(Voucher voucher) {
		voucherRep.save(voucher);
	}
	
	public void deleteVoucher(Voucher voucher) {
		voucherRep.deleteById(voucher.getId());
	}
	
	public void updateVoucher(long id, Voucher voucher) {
		voucher.setId(id);
		voucherRep.save(voucher);
	}
	
}
