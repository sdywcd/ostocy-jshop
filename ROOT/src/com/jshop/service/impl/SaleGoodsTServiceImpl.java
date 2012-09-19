package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import com.jshop.dao.SaleGoodsTDao;
import com.jshop.entity.SalegoodsT;
import com.jshop.service.SaleGoodsTService;

public class SaleGoodsTServiceImpl implements SaleGoodsTService {
	private SaleGoodsTDao salgoodstdao;
	
	public SaleGoodsTDao getSalgoodstdao() {
		return salgoodstdao;
	}

	public void setSalgoodstdao(SaleGoodsTDao salgoodstdao) {
		this.salgoodstdao = salgoodstdao;
	}

	@Override
	public SalegoodsT addsalegoods(SalegoodsT salegoodst) {
		return salgoodstdao.addsalegoods(salegoodst);
	}

	@Override
	public int updatesalegoods(SalegoodsT salegoodst) {
		// TODO Auto-generated method stub
		return salgoodstdao.updatesalegoods(salegoodst);
	}

	@Override
	public List<SalegoodsT> findallsalegoods(int currentPage, int lineSize) {
		// TODO Auto-generated method stub
		return salgoodstdao.findallsalegoods(currentPage, lineSize);
	}

	@Override
	public List<SalegoodsT> findsalegoodsById(String salegoodsid) {
		// TODO Auto-generated method stub
		return salgoodstdao.findsalegoodsById(salegoodsid);
	}

	@Override
	public List<SalegoodsT> findsalegoodsByNumber(String salegoodsnumber) {
		// TODO Auto-generated method stub
		return salgoodstdao.findsalegoodsByNumber(salegoodsnumber);
	}

	@Override
	public boolean deletesalegoods(String salegoodsnumber) {
		// TODO Auto-generated method stub
		return salgoodstdao.deletesalegoods(salegoodsnumber);
	}

	@Override
	public boolean deletesalegoodsById(String salegoodsid) {
		// TODO Auto-generated method stub
		return salgoodstdao.deletesalegoodsById(salegoodsid);
	}

	@Override
	public List<SalegoodsT> findsalegoodsByBegintime(Date begingtime) {
		// TODO Auto-generated method stub
		return null;
	}

}
