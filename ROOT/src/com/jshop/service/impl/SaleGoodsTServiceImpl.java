package com.jshop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.SaleGoodsTDao;
import com.jshop.entity.SalegoodsT;
import com.jshop.service.SaleGoodsTService;
@Service("saleGoodsTService")
@Scope("prototype")
public class SaleGoodsTServiceImpl implements SaleGoodsTService {
	private SaleGoodsTDao saleGoodsTDao;
	
	
	public SaleGoodsTDao getSaleGoodsTDao() {
		return saleGoodsTDao;
	}

	public void setSaleGoodsTDao(SaleGoodsTDao saleGoodsTDao) {
		this.saleGoodsTDao = saleGoodsTDao;
	}

	@Override
	public int addsalegoods(SalegoodsT salegoodst) {
		return this.getSaleGoodsTDao().addsalegoods(salegoodst);
	}

	@Override
	public int updatesalegoods(SalegoodsT salegoodst) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsTDao().updatesalegoods(salegoodst);
	}

	@Override
	public List<SalegoodsT> findallsalegoods(int currentPage, int lineSize) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsTDao().findallsalegoods(currentPage, lineSize);
	}

	@Override
	public SalegoodsT findsalegoodsById(String salegoodsid) {
		// TODO Auto-generated method stub
return this.getSaleGoodsTDao().findsalegoodsById(salegoodsid);
	}

	@Override
	public List<SalegoodsT> findsalegoodsByNumber(String salegoodsnumber) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsTDao().findsalegoodsByNumber(salegoodsnumber);
	}

	@Override
	public int deletesalegoods(String salegoodsnumber) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsTDao().deletesalegoods(salegoodsnumber);
	}

	@Override
	public int deletesalegoodsT(String[] list) {
		// TODO Auto-generated method stub
		return this.getSaleGoodsTDao().deletesalegoodsT(list);
	}

	@Override
	public List<SalegoodsT> findsalegoodsByBegintime(Date begingtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAllSalegoodsT() {
		
		return this.getSaleGoodsTDao().countAllSalegoodsT();
	}

	@Override
	public List<SalegoodsT> sortAllSalegoods(int currentPage, int lineSize,
			String queryString) {
		
		return this.getSaleGoodsTDao().sortAllSalegoods(currentPage, lineSize, queryString);
	}

}
