package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.UserTDao;
import com.jshop.entity.UserT;

/**
 * A data access object (DAO) providing persistence and search support for UserT
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jshop.entity.UserT
 * @author MyEclipse Persistence Tools
 */
@Repository("userTDao")
public class UserTDaoImpl extends HibernateDaoSupport implements UserTDao {

	private static final Log log = LogFactory.getLog(UserTDaoImpl.class);

	public int save(UserT transientInstance) {
		log.debug("saving UserT instance");
		try {
			this.getHibernateTemplate().save(transientInstance);
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int delete(UserT persistentInstance) {
		log.debug("deleting UserT instance");
		try {
			this.getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		return 0;
	}

	public UserT findById(java.lang.String id) {
		log.debug("getting UserT instance with id: " + id);
		try {
			UserT instance = (UserT) this.getHibernateTemplate().get("com.jshop.entity.UserT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public UserT login(UserT transientInstance) {
		log.debug("login user");
		try {
			String queryString = "from UserT as u where u.username=:username and u.password=:password and  u.state=:state and u.userstate='1'";
			List<UserT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "username", "password", "state" }, new Object[] { transientInstance.getUsername(), transientInstance.getPassword(), transientInstance.getState() });
			if (list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("login user error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserT> findAllUsert(final int currentPage, final int lineSize) {
		log.debug("find all UserT");
		try {
			List<UserT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from UserT  order by registtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all UserT error", re);
			throw re;
		}
	}

	public int countfindAllUsert() {
		log.debug("count all UserT");
		try {
			String queryString = "select count(*) from UserT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all UserT error", re);
			throw re;
		}
	}

	public UserT checkUserByUsername(UserT transientInstance) {
		log.debug("login check user");
		try {
			String queryString = "from UserT as u where u.username=:username";
			List<UserT> list = this.getHibernateTemplate().findByNamedParam(queryString, "username", transientInstance.getUsername());
			if (list != null && list.size() > 0) {

				return (UserT) list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("login check  user error", re);
			throw re;
		}
	}

	public UserT checkUserByEmail(UserT u) {
		log.debug("login check user");
		try {
			String queryString = "from UserT as u where u.email=:email";
			List<UserT> list = this.getHibernateTemplate().findByNamedParam(queryString, "email", u.getEmail());
			if (list != null && list.size() > 0) {

				return (UserT) list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("login check  user error", re);
			throw re;
		}
	}

	public int updateUserTunpwd(final UserT u) {
		log.debug("update UpdateUserTunpwd");
		try {

			final String queryString = "update UserT as u set u.username=:username,u.email=:email,u.points=:points," + "u.grade=:grade,u.gradename=:gradename,u.gradetime=:gradetime,u.state=:state,u.userstate=:userstate where u.userid=:userid";
			Integer integer=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("userid", u.getUserid());
					query.setParameter("username", u.getUsername());
					query.setParameter("email", u.getEmail());
					query.setParameter("points", u.getPoints());
					query.setParameter("grade", u.getGrade());
					query.setParameter("gradetime", u.getGradetime());
					query.setParameter("state", u.getState());
					query.setParameter("userstate", u.getUserstate());
					query.setParameter("gradename", u.getGradename());
					i = query.executeUpdate();
					return i;
				}
			});
			return integer;
		} catch (RuntimeException re) {
			log.error("update  UpdateUserTunpwd error", re);
			throw re;
		}
	}

	public int delUser(final String[] list) {
		log.debug("del DelUser");
		try {

			final String queryString = "delete from UserT as u where u.userid=:userid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("userid", s);
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
			log.error("del DelUser failed", re);
			throw re;
		}
		return 0;
	}

	public int updateUserforMyInfo(UserT u) {
		log.debug("update UpdateUserforMyInfo");
		try {
			this.getHibernateTemplate().update(u);
			return 1;
		} catch (RuntimeException re) {
			log.error("update  UpdateUserforMyInfo error", re);
			throw re;
		}

	}

	public UserT findByUserName(String name) {
		log.debug("getting UserT instance with name: " + name);
		try {
			UserT instance = (UserT) this.getHibernateTemplate().get("com.jshop.entity.UserT", name);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int updateUserMember(final UserT user) {
		log.debug("update  UpdateUserMember error");
		try {
			// TODO Auto-generated method stub
			final String queryString = "update UserT as u set u.password=:newpassword,u.username=:username where u.userid=:userid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("userid", user.getUserid());
					query.setParameter("username", user.getUsername());
					query.setParameter("newpassword", user.getPassword());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("update  UpdateUserMember error", re);
			throw re;
		}
		return 0;
	}

	public UserT usert(UserT user) {
		log.debug("login user");
		try {
			String queryString = "from UserT as u where u.username=:username and u.password=:password ";
			List<UserT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "username", "password" }, new Object[] { user.getUsername(), user.getPassword() });
			if (list != null && list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("login user error", re);
			throw re;
		}
	}

	public int updateUserstate(final UserT user) {
		log.debug("updateUserstate");
		try {
			// TODO Auto-generated method stub
			final String queryString = "update UserT as u set u.userstate=:userstate where u.userid=:userid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("userid", user.getUserid());
					query.setParameter("userstate", user.getUserstate());
					i = query.executeUpdate();
					++i;
					return i;

				}
			});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("updateUserstate error", re);
			throw re;
		}
		return 0;

	}

	public UserT finduserByuid(String uid) {
		log.debug("finduserByuid");
		try {
			String queryString = "from UserT as u where u.uid=:uid";
			List<UserT> list = this.getHibernateTemplate().findByNamedParam(queryString, "uid", uid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("finduserByuid error", re);
			throw re;
		}
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public List<UserT> sortAllUsert(final int currentPage, final int lineSize, final String queryString) {
		log.debug("find all UserT");
		try {
			List<UserT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all UserT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public String[] findEmailByUser() {
		try {
			final String queryString = "select email from UserT";

			List<String> list = this.getHibernateTemplate().find(queryString);
			String[] email = list.toArray(new String[list.size()]);
			return email;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public UserT checkUserByAnswer(String username, String question, String answer) {
		try {
			final String queryString = " from UserT as u where u.username=:username and u.question=:question and u.answer=:answer";
			List<UserT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "username", "question", "answer" }, new Object[] { username, question, answer });
			if (list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("check user answer error", re);
			throw re;
		}

	}

	public int updateUserPasswordProtection(final String userid, final String question, final String answer) {
		// TODO 设置密码保护
		try {
			final String queryString = "update UserT as u set u.question=:question,u.answer=:answer where u.userid=:userid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("userid", userid);
					query.setParameter("question", question);
					query.setParameter("answer", answer);
					i = query.executeUpdate();
					return i;
				}
				
			});
			
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("update  UpdateUserMember error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateUserRoleMByuserid(final String userid, final String rolemid,
			final String rolemname) {
		try {
			final String queryString = "update UserT as u set u.rolemid=:rolemid,u.rolemname=:rolemname where u.userid=:userid";
			Integer integer=(Integer)this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("userid", userid);
					query.setParameter("rolemname", rolemname);
					query.setParameter("rolemid", rolemid);
					i = query.executeUpdate();
					return i;
				}
				
			});
			return integer;
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("update  UpdateUserMember error", re);
			throw re;
		}
	}

	@Override
	public int updateUserHeadPathByUserId(final UserT user) {
		try {
			final String queryString="update UserT as u set u.headpath=:headpath where u.userid=:userid";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i=0;
					Query query= session.createQuery(queryString);
					query.setParameter("headpath", user.getHeadpath());
					query.setParameter("userid", user.getUserid());
					i=query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException e) {
			throw e;
		}
		return 0;
	}

}