package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.WebsiteMsgTDao;
import com.jshop.entity.WebsiteMsgT;

/**
 * A data access object (DAO) providing persistence and search support for
 * WebsiteMsgT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.WebsiteMsgT
 * @author MyEclipse Persistence Tools
 */
@Repository("websiteMsgTDao")
public class WebsiteMsgTDaoImpl extends HibernateDaoSupport implements WebsiteMsgTDao {
	
	private static final Log log = LogFactory.getLog(WebsiteMsgTDaoImpl.class);
	

	public int addWebsiteMsgT(WebsiteMsgT wm) {
		log.debug("save WebsiteMsgT");
		try {
			this.getHibernateTemplate().save(wm);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int countfindAllWebsiteMsgByFromUserid(String userid) {
		log.debug("count all countfindAllWebsiteMsgBySenduserid");
		try {
			String queryString = "select count(*) from WebsiteMsgT as wm where wm.msgfromuserid=:userid";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllWebsiteMsgByFromUserid error", re);
			throw re;
		}
	}

	public int delWebsiteMsgT(final String[] list) {
		log.debug("del DelWebsiteMsgT");
		try {

			final String queryString = "delete from WebsiteMsgT as wm where wm.msgid=:msgid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("msgid", s);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del DelWebsiteMsgT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<WebsiteMsgT> findAllWebsiteMsgByFromUserid(final int currentPage, final int lineSize, final String userid) {
		log.debug("find all findAllWebsiteMsgByFromUserid");
		try {
			List<WebsiteMsgT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from WebsiteMsgT as wm where wm.msgfromuserid=:userid order by wm.createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("userid", userid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findAllWebsiteMsgByFromUserid error", re);
			throw re;
		}
	}

	public int updateWebsiteMsgstate(final String[] list, final String state) {
		log.debug("update updateWebsiteMsgstate");
		try {
			final String queryString = "update WebsiteMsgT as wm set wm.state=:state where wm.msgid=:msgid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("msgid", s);
						query.setParameter("state", state);
						i = query.executeUpdate();
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});

		} catch (RuntimeException re) {
			log.error("update updateWebsiteMsgstate error", re);
			throw re;
		}
		return 0;
	}

	public int countfindAllWebsiteMsgByToUsername(String msgtousername) {
		log.debug("count all countfindAllWebsiteMsgByToUsername");
		try {
			String queryString = "select count(*) from WebsiteMsgT as wm where wm.msgtousername=:msgtousername";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "msgtousername", msgtousername);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all WebsiteMsgT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<WebsiteMsgT> findAllWebsiteMsgByToUsername(final int currentPage, final int lineSize, final String msgtousername) {
		log.debug("find all findAllWebsiteMsgByToUsername");
		try {
			List<WebsiteMsgT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from WebsiteMsgT as wm where wm.msgtousername=:msgtousername";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("msgtousername", msgtousername);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findAllWebsiteMsgByToUsername error", re);
			throw re;
		}
	}
}