package com.jshop.service;

import java.util.List;

import com.jshop.entity.SalegoodsT;

public interface SaleGoodsTService {

	// 制定日志
	/**
	 * 
	 * 添加拍卖商品
	 * */
	public abstract SalegoodsT addsalegoods(SalegoodsT salegoodst);

	public abstract int updatesalegoods(final SalegoodsT salegoodst);

	public abstract List<SalegoodsT> findallsalegoods(final int currentPage,
			final int lineSize);

	public abstract List<SalegoodsT> findsalegoodsById(String salegoodsid);

	public abstract List<SalegoodsT> findsalegoodsByNumber(
			String salegoodsnumber);

	public abstract boolean deletesalegoods(final String salegoodsnumber);

	public abstract boolean deletesalegoodsById(final String salegoodsid);

	public abstract List<SalegoodsT> findsalegoodsByBegintime(
			java.util.Date begingtime);

}