package com.jshop.dao;

import java.util.List;


import com.jshop.entity.WebsiteMsgT;

public interface WebsiteMsgTDao {
	
	/**
	 * 增加站内性消息
	 * @param mt
	 * @return
	 */
	public abstract int addWebsiteMsgT(WebsiteMsgT wm);
	/**
	 * 批量删除
	 * @param list
	 * @return
	 */
	public abstract int delWebsiteMsgT(String[] list);
	/**
	 * 根据发件人获取其所有消息数据
	 * @param currentPage
	 * @param lineSize
	 * @param userid
	 * @return
	 */
	public abstract List<WebsiteMsgT> findAllWebsiteMsgByFromUserid(int currentPage,int lineSize,String userid);
	/**
	 * 统计根据发件人获取器所有消息数据
	 * @param userid
	 * @return
	 */
	public abstract int countfindAllWebsiteMsgByFromUserid(String userid);
	/**
	 * 查询所有收件人是我的信息
	 * @param currentPage
	 * @param lineSize
	 * @param username
	 * @return
	 */
	public abstract List<WebsiteMsgT>findAllWebsiteMsgByToUsername(int currentPage,int lineSize,String msgtousername);
	/**
	 * 统计查询所有收件人是我的信息
	 * @return
	 */
	public abstract int countfindAllWebsiteMsgByToUsername(String msgtousername);
	/**
	 * 更新消息状态 ，已经读，和未读
	 * @param list 
	 * @param state
	 * @return
	 */
	public abstract int updateWebsiteMsgstate(String []list,String state);
	
	
	
	
	
	
}
