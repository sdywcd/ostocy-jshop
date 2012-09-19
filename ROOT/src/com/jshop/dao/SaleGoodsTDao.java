package com.jshop.dao;

import java.util.Date;
import java.util.List;

import com.jshop.entity.SalegoodsT;

/**
 * @author 郭建波 商品拍卖DAO
 */
public interface SaleGoodsTDao {
	/**
	 * 管理员添加拍卖商品
	 * 
	 */
	public SalegoodsT addsalegoods(SalegoodsT salegoodst);

	/**
	 * 根据修改所有拍卖商品信息
	 * 
	 */
	public int updatesalegoods(final SalegoodsT salegoodst);

	/**
	 * 
	 * 根据id查询所有拍卖数据
	 */
	public List<SalegoodsT> findsalegoodsById(final String salegoodsid);

	/**
	 * 
	 * 根据商品编号查询拍卖数据
	 */
	public List<SalegoodsT> findsalegoodsByNumber(final String salegoodsnumber);

	/**
	 * 
	 * 查询所有拍卖数据
	 */
	public List<SalegoodsT> findallsalegoods(final int currentPage,
			final int lineSize);

	/**
	 * 根据开始时间查询
	 * 
	 * */
	public List<SalegoodsT> findsalegoodsByBegintime(final Date begingtime);

	/**
	 * 
	 * 根据编号删除拍卖商品
	 */
	public boolean deletesalegoods(final String salegoodsnumber);

	/**
	 * 
	 * 根据id删除拍卖商品
	 */
	public boolean deletesalegoodsById(final String salegoodsid);

	// /**
	// * 查询所有拍卖商品状态
	// *
	// * */
	// public SalegoodsT findSalegoodsstate(String salegoodsstate);

}
