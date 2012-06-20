package com.jshop.service;

import java.util.List;

import com.jshop.entity.GroupCartT;

public interface GroupCartService {
	/**
	 * 根据ID查询团购商品
	 * @param groupid
	 * @return
	 */
	public List<GroupCartT> findGroupById(String groupid);
	/**
	 * 添加团购商品到购物车
	 * @param gc
	 * @return
	 */
	public int addgroupcart(GroupCartT gc);
	/**
	 * 根据ID删除商品
	 * @param groupid
	 * @return
	 */
	public int delGroupCart(String cartid);
}
