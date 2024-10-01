package com.pos.dragonShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.VoucherDetail;
import com.pos.dragonShoes.repository.VoucherDetailRepository;
@Service
public class VoucherDetailService {

	@Autowired
	private VoucherDetailRepository voucherDRep;
	
	public List<VoucherDetail> findAll(){
		return voucherDRep.findAll();
	}

	public Optional<VoucherDetail> findById(long id) {
		return voucherDRep.findById(id);
	}
	
	public void saveVoucherDetail(VoucherDetail vouchD) {
		voucherDRep.save(vouchD);
	}
	
	public void deleteVoucherDetail(VoucherDetail vouchD) {
		try {
			voucherDRep.deleteById(vouchD.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateVoucherDetail(long id, VoucherDetail vouchD) {
		vouchD.setId(id);
		voucherDRep.save(vouchD);
	}
}
