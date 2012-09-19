package com.jshop.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jshop.dao.SaleGoodsTDao;
import com.jshop.entity.SalegoodsT;
import com.jshop.service.SaleGoodsTService;

/**
 * @author 郭建波 拍卖实现
 * 
 */
public class SaleGoodsTDaoImpl extends HibernateDaoSupport implements
		SaleGoodsTDao, SaleGoodsTService {
	private static final Logger log = LoggerFactory
			.getLogger(SaleGoodsTDaoImpl.class);

	// 制定日志
	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#addsalegoods(com.jshop.entity.SalegoodsT)
	 */
	public SalegoodsT addsalegoods(SalegoodsT salegoodst) {
		log.debug("add SalegoodsT");// 添加日志信息
		try {
			this.getHibernateTemplate().save(salegoodst);// 把salegoodst对象存进去
			log.debug("add SalegoodsT Success");
		} catch (DataAccessException e) {
			log.debug("add SalegoodsT failed");
			throw e;
		}
		return salegoodst;

	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#updatesalegoods(com.jshop.entity.SalegoodsT)
	 */
	@Override
	public int updatesalegoods(final SalegoodsT salegoodst) {
		log.debug("update SalegoodsT");
		final String queryString = "update SalegoodsT as sale set sale.salegoodname=:salegoodname,sale.salegoodsnumber=:salegoodsnumber,sale.salegoodspictureurl=:salegoodspictureurl,sale.salegoodsinformation=:salegoodsinformation,sale.salegoodsstate=:salegoodsstate,sale.begingtime=:begingtime,sale.endingtime=:endingtime,sale.salepeople=:salepeople,sale.salestartingprice=:salestartingprice,sale.salejoinpeople=:salejoinpeople,sale.salebudget=:salebudget,sale.realname=:realname,sale.userid=:userid,sale.saleprice=:saleprice where sale.salegoodsid=salegoodsid";
		try {
			Integer integer = (Integer) this.getHibernateTemplate().execute(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							int i = 0;
							Query query = session.createQuery(queryString);
							query.setParameter("salegoodsname",
									salegoodst.getSalegoodsname());
							query.setParameter("salegoodsnumber",
									salegoodst.getSalegoodsnumber());
							query.setParameter("salegoodspictureurl",
									salegoodst.getSalegoodspictureurl());
							query.setParameter("salegoodsinformation",
									salegoodst.getSalegoodsinformation());
							query.setParameter("salegoodsstate",
									salegoodst.getSalegoodsstate());
							query.setParameter("begingtime",
									salegoodst.getBegingtime());
							query.setParameter("endingtime",
									salegoodst.getEndingtime());
							query.setParameter("salepeople",
									salegoodst.getSalepeople());
							query.setParameter("salestartingprice",
									salegoodst.getSalestartingprice());
							query.setParameter("salejoinpeople",
									salegoodst.getSalejoinpeople());
							query.setParameter("salebudget",
									salegoodst.getSalebudget());
							query.setParameter("realname",
									salegoodst.getRealname());
							query.setParameter("userid", salegoodst.getUserid());
							query.setParameter("saleprice",
									salegoodst.getSaleprice());
							query.setParameter("salegoodsid",
									salegoodst.getSalegoodsid());
							i = query.executeUpdate();

							return i;
						}
					});

			return integer;
		} catch (DataAccessException e) {
			log.debug("update SalegoodsT field");
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findallsalegoods(int, int)
	 */
	@Override
	public List<SalegoodsT> findallsalegoods(final int currentPage,
			final int lineSize) {
		log.debug("select * findallsalegoods");
		try {
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						String queryString = "select count(*) from SaleGoodsT";

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult((currentPage - 1) * lineSize);
							query.setMaxResults(lineSize);
							List<SalegoodsT> list = query.list();
							return list;
						}
					});

			log.debug("already find SalegoodsT");
			return list;
		} catch (DataAccessException e) {
			log.debug("not find SalegoodsT");
			throw e;
		}

	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findsalegoodsById(java.lang.String)
	 */
	@Override
	public List<SalegoodsT> findsalegoodsById(String salegoodsid) {
		log.debug("find SalegoodsT byId");

		try {
			String queryString = "select count(*) from SalegoodsT as sale where s.salegoodsid=:salegoodsid";
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate()
					.findByNamedParam(queryString, "salegoodsid", salegoodsid);
			return list;
		} catch (DataAccessException e) {
			log.debug("not find SalegoodsT byId");
			throw e;

		}
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findsalegoodsByNumber(java.lang.String)
	 */
	@Override
	public List<SalegoodsT> findsalegoodsByNumber(String salegoodsnumber) {
		log.debug("find SalegoodsT byNumber");

		try {
			String queryString = "select count(*)from SalegoodsT as sale where s.salegoodsnumber=:salegoodsnumber";
			@SuppressWarnings("unchecked")
			List<SalegoodsT> list = this.getHibernateTemplate()
					.findByNamedParam(queryString, "salegoodsnumber",
							salegoodsnumber);
			if (!list.isEmpty()) {
				return list;
			}
			return list;

		} catch (DataAccessException e) {
			log.debug("not find SalegoodsT byNumber");
			throw e;

		}
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#deletesalegoods(java.lang.String)
	 */
	@Override
	public boolean deletesalegoods(final String salegoodsnumber) {
		log.debug("delete SalegoodsByNumber");
		final String queryString = "delete from SalegoofdT as sale where sale.salegoodsnumber=:salegoodsnumber";
		boolean b = (Boolean) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(queryString);
						query.setParameter("salegoodsnumber", salegoodsnumber);
						int i = 0;
						i = query.executeUpdate();

						return i;
					}
				});

		return b;
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#deletesalegoodsById(java.lang.String)
	 */
	@Override
	public boolean deletesalegoodsById(final String salegoodsid) {
		log.debug("delete SalegoodsById");
		final String queryString = "delete from SalegoofdT as sale where salegoodsid=:salegoodsid";
		boolean b = (Boolean) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(queryString);
						query.setParameter("salegoodsid", salegoodsid);
						int i = 0;
						i = query.executeUpdate();

						return i;
					}
				});

		return b;
	}

	/* (non-Javadoc)
	 * @see com.jshop.dao.impl.SaleGoodsTService#findsalegoodsByBegintime(java.util.Date)
	 */
	@Override
	public List<SalegoodsT> findsalegoodsByBegintime(java.util.Date begingtime) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		SaleGoodsTDao s = new SaleGoodsTDaoImpl();
		SalegoodsT sg = new SalegoodsT();
		sg.setBegingtime(new java.util.Date());
		sg.setEndingtime(new java.util.Date());
		sg.setRealname("小三");
		sg.setSalebudget("无");
		sg.setSalegoodsinformation("一张图片");
		sg.setSalegoodsname("男用领带");
		sg.setSalegoodsnumber("gbk2020-7");
		sg.setSalegoodspictureurl("www.xxx.com");
		sg.setSalegoodsstate("1");
		sg.setSalejoinpeople(20);
		sg.setSalepeople("ddd");
		sg.setSaleprice(200000);
		sg.setSalestartingprice(122220000);
		sg.setUserid("1");
		s.addsalegoods(sg);

	}

}
